package service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private User user;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public void setUserMapper(User user) {
		sqlSessionFactory.openSession().insert("com.closet.closet.mapper.UserMapper.insertUser",user);
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession().selectOne("com.closet.closet.mapper.UserMapper.getUser","qqq");
	}
	

}
