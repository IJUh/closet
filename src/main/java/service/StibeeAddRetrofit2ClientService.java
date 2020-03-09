package service;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * The Class StibeeAddRetrofit2ClientService.
 *
 * @Class Name : StibeeAddRetrofit2ClientService.java
 * @Description : 스티비측으로 주소록에 구독자 추가
 * @Modification Information
 *
 * @author
 * @version 1.0
 * @see  Copyright (C) by UIJ All right reserved.
 * @since 2020.03.09
 * @
 * @ 수정일			수정자		수정내용
 * @ -----------	---------   -------------------------------
 * @ 2020.03.09 	UIJ       최초생성 : 스티비측으로 주소록에 구독자 추가
 */
public class StibeeAddRetrofit2ClientService {
    private static final Logger log = LoggerFactory.getLogger(StibeeAddRetrofit2ClientService.class);
    private StibeeRetrofit2Api stibeeRetrofit2Api;

    public StibeeAddRetrofit2ClientService(String baseUrl) {
        log.debug("StibeeAddRetrofit2ClientService baseUrl=[{}]", baseUrl);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        		
        this.stibeeRetrofit2Api = ((StibeeRetrofit2Api)retrofit.create(StibeeRetrofit2Api.class));
    }
    
    public String addSubscribers(String accessToken, String listId, String groupIds, String[][] subscribers) throws IOException {
    	log.debug("token=[{}], referer=[{}], serviceCode=[{}], siteCode=[{}], status=[{}], updatedDate=[{}]", accessToken, groupIds, subscribers);

		HashMap<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("eventOccuredBy", "MANUAL");
		bodyMap.put("confirmEmailYN", "N");
		bodyMap.put("subscribers", subscribers);

		Response<Object> res = stibeeRetrofit2Api.addSubscribers(accessToken, listId, bodyMap).execute();
		log.debug("res ::: [{}]", res);

        return res.toString();
    }
    
}