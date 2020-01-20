package service;

import model.User;

public interface LoginService {
	public User login(User user);
	public int Register(String is_checked, User user);
}
