package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.service.LoginServiceImpl;
import com.cts.vo.LoginVo;

@Controller
public class HelloWorldController {

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@RequestMapping("hello")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("helloworld");
		return mv;
	}

	@RequestMapping("hello1")
	public ModelAndView searchPageInisialise() {
		ModelAndView mv = new ModelAndView("search");
		return mv;
	}
	@RequestMapping("hello2")
	public ModelAndView csspage() {
		ModelAndView mv = new ModelAndView("TestCSS");
		return mv;
	}


	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginDetails(@ModelAttribute(value = "loginpage") LoginVo loginVo, BindingResult result) {
		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			model.addObject("msg", "Error While Procesing!!");
			model.setViewName("helloworld");
		} else {
			String name = loginServiceImpl.addLogin(loginVo);
			model.addObject("msg", name);
			model.setViewName("helloworld");
		}
		return model;
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView searchDetails(@ModelAttribute(value = "searchpage") LoginVo loginVo, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("msg", "Error While Procesing!!");
			modelAndView.setViewName("search");
		}

		else {
			List<LoginVo> allList = loginServiceImpl.getList(loginVo);
			modelAndView.addObject("getlist", allList);
			modelAndView.setViewName("resultlist");
		}
		return modelAndView;
	}
}
