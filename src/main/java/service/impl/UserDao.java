package service.impl;

import model.User;

public interface UserDao {
	public User login(User user);

	public int Register(User user);
}
