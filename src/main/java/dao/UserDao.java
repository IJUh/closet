package dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDao {

	@Inject
	SqlSession sqlSession;

	public User login(User user) {
		return sqlSession.selectOne("com.closet.closet.mapper.UserMapper.getUser", user);
	}

	public int Register(User user) {
		return sqlSession.insert("com.closet.closet.mapper.UserMapper.insertUser", user);
	}

}
