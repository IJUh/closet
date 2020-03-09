package service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.fss.fsswms.base.retrofit2.godomall.GodomallStatusRetrofit2ClientService;

import service.StibeeAddRetrofit2ClientService;

public class StibeeTest {

	@Autowired
	StibeeAddRetrofit2ClientService stibeeAddRetrofit2ClientService;
	/**
	 * 심사 저장
	 * 
	 * @param paramMap
	 * @exception Exception
	 */
	public void mainSave(Box box, ModelMap model) throws Exception {
		String loginUserId = sessionUtil.getUserId(box.getSession());

		Box dataBox = JsonUtil.toObject(box.getString("dataForm2"), Box.class);

		dataBox.put("loginUserId", loginUserId);

		String serverSchema = request.getHeader("X-Forwarded-Proto");
		if (StringUtils.isEmpty(serverSchema)) {
			serverSchema = request.getScheme();
		}
		String serverName = request.getServerName();
		String serverAddr = serverSchema + "://" + serverName;

		if ("".equals(dataBox.getString("godPrefix"))) {
			dataBox.remove("godPrefix");
		}

		// 심사 정보 저장
		commonMapper.insert("classic.std.std21.apprSave", dataBox);

		if (dataBox.getInt("appr_status") == 8) { // 심사 승인일때만 센터값 배정
			// 센터 정보 저장
			commonMapper.insert("classic.std.std21.deleteWhData", dataBox);
			commonMapper.insert("classic.std.std21.insertWhData", dataBox);

			// 사용자 Role 저장
			commonMapper.insert("classic.std.std21.insertRoleData", dataBox);
		}

		model.put("result", "success");

		if (dataBox.getInt("appr_status") > 4) {
			String siteType = "";

			int siteTypeIndex = serverName.indexOf("-");
			if (siteTypeIndex >= 0) {
				siteType = "(" + serverName.substring(0, siteTypeIndex).toUpperCase() + ")";
			}

			Box info = commonMapper.selectOne("classic.std.std21.detlList", dataBox);

			String apprStatus = "";

			// 심사 결과 메일 발송
			switch (dataBox.getString("appr_status")) {
			case "8":
				// 심사 승인
				apprStatus = "approved";

				break;
			default: // 5:심사 거절(센터 보관량 초과), 6:심사 거절(센터 인력 부족), 7:심사 거절(고객정보문제), 9:심사 거절 (기타)
				apprStatus = "rejected";

				break;
			}

			emailService.sendServiceApprovalMail(info, apprStatus, siteType);

			final String retStatus = apprStatus;

			// 외부 연동 정보 업체 조회 - local 아닌 경우에만 실행
			if (!"(LOCAL)".equals(siteType)) {
				List<Box> customerShopList = commonMapper.selectList("classic.std.std21.getCstShopList", dataBox);
				if (customerShopList != null) {
					for (Box cstBox : customerShopList) {
						if ("godo".equals(cstBox.getString("shopPartner"))) {
							Box godoToken = godomallTokenRetrofit2ClientService.requestToken(serverAddr,
									cryptoService.decrypt(godoTokenId), cryptoService.decrypt(godoTokenSecret));
							log.debug("godoToken =[{}]", godoToken);

							if (godoToken != null && "success".equals(godoToken.getString("result"))) {
								// 고도몰 측 토큰에서 검증 오류가 간헐적으로 발생하여 딜레이 발급 후 3초의 딜레이
								Thread.sleep(3000);

								// 고도몰 측으로 서비스 심사 결과 상태 값("approved" or "rejected") 전송
								String godoMallStatus = stibeeAddRetrofit2ClientService.statusUpdate(
										godoToken.getString("data"), serverAddr, cstBox.getString("shopCstCode"),
										dataBox.getString("appr_cst_cd"), retStatus, info.getString("godoApprTime"));
								log.debug("godoMallStatus =[{}]", godoMallStatus);
							}
						}
					}
				}
			}
		}

		// 재조회
		Map<String, Object> schData = JsonUtil.toObject(box.getString("schParam"), Box.class);

		Box schBox = new Box();
		for (Map.Entry<String, Object> m : schData.entrySet()) {
			schBox.put(m.getKey(), m.getValue());
		}

		List<Box> stdList = commonMapper.selectList("classic.std.std21.mainList", schBox);
		model.put("list", stdList);
	}
}
