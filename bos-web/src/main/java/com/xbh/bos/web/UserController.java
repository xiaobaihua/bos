package com.xbh.bos.web;

import com.xbh.bos.domain.User;
import com.xbh.bos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xbh
 * @date 2018年12月30日16:47:01
 * @Description
 */
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public ModelAndView userLogin(HttpServletRequest req, HttpServletResponse res){
		ModelAndView view = new ModelAndView();
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		final String checkcode = req.getParameter("checkcode");

		// 提示
		String hint = "";

		String attribute = (String)req.getSession().getAttribute("key");
				// 校验验证码是否一致
		if (checkcode.equals(attribute)) {
			User user = userService.getUserByUsernameAndPassword(username, password);

			if (user != null) {
				req.getSession().setAttribute("user", user);
				view.setViewName("redirect:/index.jsp");
			}else {
				//为空就提示
				hint = "用户名密码错误";
				view.setViewName("/login");
			}
		}else{
			hint = "验证码错误";
			view.setViewName("/login");
		}

		view.addObject("hint", hint);
		return view;
	}

	@RequestMapping("/logout")
	public String userLogout(HttpServletRequest req, HttpServletResponse res){
		req.getSession().removeAttribute("user");
		return "redirect:/login.jsp";
	}
}