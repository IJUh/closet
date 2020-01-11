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
			//���� login�̶� ���� ���� �����Ѵٸ�
			session.removeAttribute("login"); //�������� ����
		}
		
		//DB�� �α��� ���� ���� ��ȯ
		User loginUser = loginService.login(user);
		
		if(loginUser != null) {
			//�α��� ���� ���� �� ���ǿ� �α��� ���� ���
			session.setAttribute("login", loginUser);
			List<ArrayList> clothList = userService.getRegisterClothList(loginUser);
			mv.addObject("closthList", clothList);
			mv.setViewName("main");
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	/*@RequestMapping(value="/register/user", method=RequestMethod.POST)
	public ModelAndView registerUser(HttpSession session, @RequestParam String user_id, @RequestParam String password,@RequestParam String phone, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		user.setUserId(user_id);
		user.setPassword(password);
		user.setPhone(phone);
		userService.setUserMapper(user);
		
		int login = loginService.Register(user);
		
		if(login != -1) {
			mv.setViewName("sign_up");
		} else {

			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");
			}
			//�α��� ���� ���� �� ���ǿ� �α��� ���� ���
			

			User loginUser = loginService.login(user);
			
			session.setAttribute("login", loginUser);
			mv.setViewName("main");
			
		}
		
		return mv;
	}*/
	
	@RequestMapping(value="/register/user", method=RequestMethod.POST)
	public ModelAndView registerUser(HttpSession session, @RequestParam String is_checked, @ModelAttribute User user, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//login�� ���� user�� ���� �����ؾ���! java ���ϵ� ������ ��
		//userService.setUserMapper(user);
		
		//�ߺ� üũ�� ������ ���
		if("1".equals(is_checked)) {
			int login = loginService.Register(user);
			
			if(login != -1) {
				mv.setViewName("sign_up");
			} else {

				if(session.getAttribute("login") != null) {
					session.removeAttribute("login");
				}
				//�α��� ���� ���� �� ���ǿ� �α��� ���� ���
				

				User loginUser = loginService.login(user);
				
				session.setAttribute("login", loginUser);
				mv.setViewName("main");
			}
		} else {
			throw new Exception();
		}
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/check/duplicate/user", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkUser(HttpSession session, @RequestBody User user, HttpServletResponse response) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		String check = userService.checkDuplicateUser(user);
		
		if("0".equals(check)) {
			//�ߺ� ������ ������
			resultMap.put("message","�ش� ���̵�� ����� �� �ֽ��ϴ�.");
		} else {
			resultMap.put("message","�ߺ��� ���̵��Դϴ�.");
			
		}
		return resultMap;
	}
	
	/*@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MyBadDataException.class)
	@ResponseBody ErrorInfo
	handleBadRequest(HttpServletRequest req, Exception ex) {
	    return new ErrorInfo(req.getRequestURL(), ex);
	} */
	
}
