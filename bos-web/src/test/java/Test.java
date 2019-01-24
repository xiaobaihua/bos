import com.google.gson.Gson;
import com.xbh.bos.dao.BaseDao;
import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.dao.UserDao;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.User;
import com.xbh.bos.domain.vo.PageVO;
import com.xbh.bos.service.UserService;
import com.xbh.bos.utils.Cipher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xbh
 * @date 2018年12月28日16:20:16
 * @Description 测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-servlet.xml")
public class Test {
	@Autowired
	UserDao userDao;
	@Autowired
	private StaffDao staffDao;


	@org.junit.Test
	public void testDao() {


		userDao.updatePasswordById("2", "3111aaaaa");
	}

	@org.junit.Test
	public void testCipher() {
		try {
			//Cipher.getMd5Cipher("1111");
			String md5Cipher = Cipher.getMd5Cipher("123");
			String md5Cipher1 = Cipher.getMd5Cipher("1231111111111111111111111111111111");

			System.out.println(md5Cipher);
			System.out.println(md5Cipher1);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void test1s() {
		Staff staff = new Staff();
		staff.setName("哈哈哈");
		staff.setTelephone("123");

		staffDao.save(staff);
	}

	@org.junit.Test
	public void name() {

	}

}