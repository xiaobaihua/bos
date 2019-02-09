package com.xbh.bos.web;

import com.google.gson.Gson;
import com.xbh.bos.domain.Staff;
import com.xbh.bos.domain.vo.PageVO;
import com.xbh.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

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

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");

		PageVO vo = staffService.getStaffList(page, rows);
		Gson gson = new Gson();

		System.out.println(gson.toJson(vo));
		String s = gson.toJson(vo);
		return s;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam String ids){
		String[] strings = ids.split(",");

		Boolean aBoolean = staffService.deleteALLByList(Arrays.asList(strings));

		return (aBoolean?"1":"0");
	}

	@RequestMapping("/restore")
	@ResponseBody
	public String restore(@RequestParam String ids){
		String[] strings = ids.split(",");

		Boolean aBoolean = staffService.restoreAllByList(Arrays.asList(strings));

		return (aBoolean?"1":"0");
	}

	@RequestMapping("/findStaffs")
	@ResponseBody
	public String findStaffs(Staff staff){
		Gson gson = new Gson();
		Set list = staffService.queryStaffByTelORNameORStation(staff);
		PageVO vo = new PageVO();
		vo.setrows(new ArrayList(list));
		vo.setTotal(Integer.valueOf(list.size()).longValue());
		String s = gson.toJson(vo);

		return s;
	}

	/**
	 * @param staff
	 * @return 0失败
	 */
	@RequestMapping("/editStaff")
	@ResponseBody
	public int editStaffs(Staff staff){
		int i = staffService.updateByID(staff);
		return i;
	}
}
