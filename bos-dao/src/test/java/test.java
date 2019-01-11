import com.xbh.bos.dao.daoImp.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xbh
 * @date
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-servlet.xml")
public class test {
	@Test
	public void testDao() {
		UserDaoImpl userDao = new UserDaoImpl();

		userDao.updatePasswordById("2", "132123213213");
	}
}
