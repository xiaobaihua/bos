package com.xbh.bos.web;

import com.xbh.bos.domain.Staff;
import com.xbh.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xbh
 * @date 2019年1月17日11:16:04
 * @Description
 */
@Controller
@RequestMapping("/staff")
public class StaffController {


	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Staff staff){
		return String.valueOf(staffService.save(staff));
	}
}
