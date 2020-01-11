package service.impl;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import model.User;
import service.LoginService;;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}

	public int Register(User user) {
		return userDao.Register(user);
	}
}
