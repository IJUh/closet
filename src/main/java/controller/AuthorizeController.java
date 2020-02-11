package controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.DecoderException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;

import model.GoogleJWT;
import service.LoginService;
import service.impl.GoogleAuthServiceImpl;

@Controller
public class AuthorizeController {

	@Inject
	LoginService login;

	@Inject
	GoogleAuthServiceImpl googleAuthService;

	@Inject
	GoogleJWT googleJwt;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String authLogin(HttpServletResponse response, HttpServletRequest request, Model model) {

		// 구글auth api 생성
		String url = googleAuthService.authLogin();
		model.addAttribute("google_url", url);

		String[] state = url.split("state");
		request.getSession().setAttribute("state", state[0]);

		return "/login";
	}

	@RequestMapping(value = "/googleSiginIn/auth", method = RequestMethod.GET, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String sendAuthenticationRequest(HttpServletResponse response, HttpServletRequest request) throws IOException, RestClientException, URISyntaxException, DecoderException {
		String code = request.getParameter("code");
		googleJwt = googleAuthService.siginIn(code);

		if (login.getGoogleUserInfo(googleJwt) != 1) {
			return "redirect:/register";
		} else {
			request.getSession().setAttribute("id_token", (String) googleJwt.getAzp());
			return "redirect:/main";
		}
		
	}
}
