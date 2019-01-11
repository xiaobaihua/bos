import com.xbh.bos.dao.UserDao;
import com.xbh.bos.utils.Cipher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
		byte b = 112;

		System.out.println(b);
	}
}
