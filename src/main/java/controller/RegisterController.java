package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	User user;
	
	/*@RequestMapping("/register.com/cloth")
	public ModelAndView register(@RequestParam String user_id, @RequestParam String phone, @RequestParam String user_name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("USER_ID", user_id);
		mv.addObject("PHONE", phone);
		mv.addObject("USER_NAME", user_name);
		User user = new User();
		user.setPhone(phone);
		user.setUserId(user_id);
		user.setUserName(user_name);
		userService.setUserMapper(user);
		mv.setViewName("main");
		return mv;
	}*/
	
	@RequestMapping(value="/cloth", method=RequestMethod.POST)
	public ModelAndView register(@RequestParam String query) {
		ModelAndView mv = new ModelAndView();
		/*mv.addObject("USER_ID", user_id);
		mv.addObject("PHONE", phone);
		mv.addObject("USER_NAME", user_name);*/
		Cloth cloth = new Cloth();
		cloth.setItemNo(query);
		clothService.setClothMapper(cloth);
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpSession session, User user, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("login") != null) {
			//기존 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); //기존값을 제거
		}
		
		//DB의 로그인 유저 정보 반환
		User loginUser = loginService.login(user);
		
		if(loginUser != null) {
			//로그인 정보 존재 시 세션에 로그인 정보 담기
			session.setAttribute("login", loginUser);
			List<ArrayList> clothList = userService.getRegisterClothList(loginUser);
			mv.addObject("closthList", clothList);
			mv.setViewName("main");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
}
