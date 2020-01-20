package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.Cloth;
import model.User;
import service.ClothService;
import service.LoginService;
import service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	ClothService clothService;

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	User userModel;
	
	@RequestMapping(value="/cloth", method=RequestMethod.POST)
	public ModelAndView register(@RequestParam String query) {
		ModelAndView mv = new ModelAndView();
		Cloth cloth = new Cloth();
		cloth.setItemNo(query);
		clothService.setClothMapper(cloth);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpSession session, @ModelAttribute User user, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("login") != null) {
			//기존 세션 제거
			session.removeAttribute("login");
		}

		userModel = loginService.login(user);
		
		if(userModel != null) {
			//로그인 정보 존재 시 세션에 로그인 정보 담기
			session.setAttribute("login", userModel);
			List<ArrayList> clothList = userService.getRegisterClothList(userModel);
			mv.addObject("closthList", clothList);
			mv.setViewName("main");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value="/register/user", method=RequestMethod.POST)
	public ModelAndView registerUser(HttpSession session, @RequestBody String is_checked, @ModelAttribute User user, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		//서비스단으로 넘겨줘서 정리
		int register = loginService.Register(is_checked, user);
		if(register == 1) {
			userModel = loginService.login(user);
			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");
			}
			session.setAttribute("login", userModel);
			mv.setViewName("main");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value="/check/duplicate/user", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkUser(HttpSession session, @RequestBody User user, HttpServletResponse response) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		String check = userService.checkDuplicateUser(user);
		
		if("0".equals(check)) {
			//중복 유저가 없으면
			resultMap.put("message","해당 아이디는 사용할 수 있습니다.");
		} else {
			resultMap.put("message","중복된 아이디입니다.");
			
		}
		return resultMap;
	}
	
}
