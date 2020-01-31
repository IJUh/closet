package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
	public String authLogin(HttpServletResponse response, HttpServletRequest request);
}
