package service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cloth;
import model.User;
import service.ClothService;;

@Service
public class ClothServiceImpl implements ClothService {

	@Autowired
	private User user;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public void setClothMapper(Cloth cloth) {
		sqlSessionFactory.openSession().insert("com.closet.closet.mapper.ClothMapper.insertCloth",cloth);
	}

	@Override
	public Cloth getCloth() {
		return sqlSessionFactory.openSession().selectOne("com.closet.closet.mapper.ClothMapper.getCloth","qqq");
	}
	

}
