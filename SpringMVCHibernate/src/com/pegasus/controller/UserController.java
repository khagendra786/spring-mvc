package com.pegasus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.pegasus.bean.UserBean;
import com.pegasus.model.User;
import com.pegasus.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute("command")UserBean userBean, BindingResult result){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", prepareListOfUser(userService.listUsers()));
		return new ModelAndView("register.jsp", model);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginUser(){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", prepareListOfUser(userService.listUsers()));
		return new ModelAndView("login.jsp", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("index");
	}
	
	private List<UserBean> prepareListOfUser(List<User> users){
		List<UserBean> beans = new ArrayList<UserBean>();;
		if (users != null && ! users.isEmpty()) {
			UserBean bean = null;
			for (User iterator : users) {
			bean = new UserBean();
			bean.setId(iterator.getId());
			bean.setUsername(iterator.getUsername());
			bean.setPassword(iterator.getPassword());
			beans.add(bean);
			}
		}
		return beans;
	}
}
