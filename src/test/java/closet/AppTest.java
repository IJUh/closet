package closet;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/config/spring/*-context.xml"})
public class AppTest {
	
	@Inject
    private SqlSessionFactory sqlSessionFactory;
	
    @Test
    public void testFactory(){
    	/*User user = new User();
    	user.setUserId("bepanthol");
    	user.setUserName("∫Ò∆«≈Á");
    	user.setDeleted("Y");
    	user.setPhone("010-1234-5678");
    	sqlSessionFactory.openSession().insert("com.closet.closet.mapper.UserMapper.insertUser", user);*/
    }
}
