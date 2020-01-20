package service.impl;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import dao.UserDao;
import exception.InvalidRegisterAccessException;
import exception.InvalidRegisterException;
import model.ErrorCode;
import model.User;
import service.LoginService;;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	UserDao userDao;

	public User login(User user) {
		return userDao.login(user);
	}

	public int Register(String is_checked, User user) {

		if ("1".equals(is_checked)) {
			// 중복 체크
			int registerCnt = userDao.Register(user);
			if (registerCnt < 0) {
				throw new InvalidRegisterException("시스템 내부 사정으로 회원가입하지 못 했습니다. 다시 시도해주시기 바랍니다.",
						ErrorCode.SIGN_UP_INPUT_INVALID);
			} else {
				return 1;
			}
		} else {
			// 아이디 중복확인 미실행 후 등록 잘못된 접근방식으로 오류 처리
			throw new InvalidRegisterAccessException("아이디 중복확인 후 회원가입 가능합니다.", ErrorCode.SIGN_UP_ACCESS_INVALID);
		}
	}
}
