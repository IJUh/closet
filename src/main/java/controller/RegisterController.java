package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Cloth;
import model.User;
import service.ClothService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	ClothService clothService;
	
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
	
}
