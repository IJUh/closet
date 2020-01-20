package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Cloth;
import model.User;
import service.ClothService;
import service.LoginService;
import service.UserService;

@Controller
public class ItemController {
	
	@Autowired
	ClothService clothService;

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	User userModel;
	
	@Autowired
	Cloth clothModel;
	
	@RequestMapping(value="/register/cloth", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(@ModelAttribute Cloth clothModel) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int registerCloth = clothService.registerCloth(clothModel);
		if(registerCloth > 0) {
			resultMap.put("1", "상품을 등록하였습니다.");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/modify/cloth", method=RequestMethod.POST)
	public String modifyRegisterInfo(@ModelAttribute Cloth clothModel) {
		//clothService.modifyCloth(clothModel);
		int registerCloth = clothService.registerCloth(clothModel);
		return "/admin/page";
	}
}
