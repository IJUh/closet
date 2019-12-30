package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

///로그인 처리를 담당하는 인터셉터
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	// preHandle() : 컨트롤러보다 먼저 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("login") != null) {
		//로그인이 됐으면
			response.sendRedirect("/");
			//login객체가 없기 때문에 login화면으로 이동
			return false;		
		}
		return true;	//원래 호출하려던 uri 호출
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
