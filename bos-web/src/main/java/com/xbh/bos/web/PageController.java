package com.xbh.bos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xbh
 * @date 2018年12月30日16:43:47
 * @Description
 */
@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/{pageName}")
	public String toPage(@PathVariable String pageName){
		String[] strings = pageName.split("_");
		return "/pages/" + strings[0] + "/" + strings[1];
	}
}
