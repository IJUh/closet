package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

public interface UserService {
	
	public void setUserMapper(User user);
	public User getUser();
	public List<ArrayList> getRegisterClothList(User loginUser);
}
