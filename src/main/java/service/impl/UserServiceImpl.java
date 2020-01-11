package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private User user;
	
	@Autowired
	private SqlSession sqlSession;

	public void setUserMapper(User user) {
		sqlSession.insert("com.closet.closet.mapper.UserMapper.insertUser",user);
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.closet.closet.mapper.UserMapper.getUser","qqq");
	}

	public List<ArrayList> getRegisterClothList(User loginUser) {
		return sqlSession.selectList("com.closet.closet.mapper.UserMapper.getClothList", loginUser);
	}

	@Override
	public String checkDuplicateUser(User user) {
		return sqlSession.selectOne("com.closet.closet.mapper.UserMapper.checkUser", user);
	}
	

}
