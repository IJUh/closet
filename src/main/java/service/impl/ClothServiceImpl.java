package service.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClothDao;
import exception.BusinessException;
import model.Cloth;
import model.ErrorCode;
import model.User;
import service.ClothService;;

@Service
public class ClothServiceImpl implements ClothService {

	@Autowired
	private User user;
	
	@Inject
	ClothDao dao;
	
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

	@Override
	public int registerCloth(Cloth clothModel) {
		String companyNo = clothModel.getCompanyNo();
		if(companyNo.equals(dao.selectCompanyItemNo(clothModel))) {
			throw new BusinessException("이미 등록된 제품 번호입니다.", ErrorCode.ITEM_NO_ALREADY_REGISTER);
		} else {
			dao.registerItem(clothModel);
		}
		return 0;
	}
	

}
