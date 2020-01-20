package dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Cloth;

@Repository
public class ClothDao {

	@Inject
	SqlSession sqlSession;
	
	private static final String namespace = "com.closet.mapper.ClothMapper.";
	
	public String selectCompanyItemNo(Cloth clothModel) {
		return sqlSession.selectOne(namespace + "selectCompanyItemNo", clothModel);
	}

	public int registerItem(Cloth clothModel) {
		return sqlSession.insert(namespace + "insertItem", clothModel);
	}

}
