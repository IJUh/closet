package dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.GoogleJWT;
import model.User;

@Repository
public class UserDao {

	@Inject
	SqlSession sqlSession;
	
	final static String namespace = "com.closet.closet.mapper.UserMapper";

	public User login(User user) {
		return sqlSession.selectOne("com.closet.closet.mapper.UserMapper.getUser", user);
	}

	public int Register(User user) {
		return sqlSession.insert("com.closet.closet.mapper.UserMapper.insertUser", user);
	}

	public int getGoogleUserInfo(GoogleJWT googleJwt) {
		if(sqlSession.selectOne(namespace + ".getGoogleUserInfo",googleJwt) == null) {
			return 0;
		} else {
			return 1;
		}
	}

	public void registerGoogleUserInfo(String tokens) {
		sqlSession.insert(namespace + ".registerGoogleUserInfo", tokens);
	}

}
