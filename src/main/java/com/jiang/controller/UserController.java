package com.jiang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiang.entity.User;
import com.jiang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.findById(userId);
		List<User> list=new ArrayList<User>();
		list.add(user);
		model.addAttribute("list",list);
		
		return "showUser";
	}	
	
	@RequestMapping("/showAll")
	public String ShowAllInfo(Map<String,Object> map,Model model){
		List<User> list = userService.findAll();
		logger.info(list);
		model.addAttribute("list",list);
		return "index.jsp";
	}
	
	//用户登录
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public String login(User user,HttpSession session){
		boolean loginType=userService.login(user.getUsername(), user.getPassword());

			if(loginType){
				//登录成功
				session.setAttribute("user", user);
				return "index.jsp";
			}else{
				session.setAttribute("message", "登录失败");
				return "error.jsp";
			}
	}
	
	//注册
	@RequestMapping("/register")
	public String register(HttpSession session,User user){
		int status = userService.InsertUser(user);
		if(status==1){
			return "redirect:/login.jsp";
		}else{
			return "register.html";
		}
	}
	
	@RequestMapping(value="checkUser",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody	
	public boolean checkUser(String username,HttpSession session){
		boolean exist = this.userService.checkUser(username);
		return exist;
		
	}
}
