package service;

import model.GoogleJWT;
import model.User;

public interface LoginService {
	public User login(User user);
	public int Register(String is_checked, User user);
	public int getGoogleUserInfo(GoogleJWT googleJwt);
	public void registerGoogleUserInfo(String tokens);
}
