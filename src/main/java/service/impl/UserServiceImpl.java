package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private User user;
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void setUserMapper(User user) {
		//sqlSessionFactory.openSession().insert("com.closet.closet.mapper.UserMapper.insertUser",user);
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.closet.closet.mapper.UserMapper.getUser","qqq");
	}

	@Override
	public List<ArrayList> getRegisterClothList(User loginUser) {
		return sqlSession.selectList("com.closet.closet.mapper.UserMapper.getClothList", loginUser);
	}
	

}
