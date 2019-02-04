import com.google.gson.Gson;
import com.xbh.bos.dao.BaseDao;
import com.xbh.bos.dao.StaffDao;
import com.xbh.bos.domain.vo.PageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbh
 * @date 2019年1月19日14:52:05
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-servlet.xml")
public class Test2 {
	@Autowired
	StaffDao staffDao;

	@Test
	public void name() {
		String deltagByid = staffDao.getDeltagByid("2036ec921acf11e9af1000e04c22e365");
		System.out.println(deltagByid);
		System.out.println(123);
	}
}
