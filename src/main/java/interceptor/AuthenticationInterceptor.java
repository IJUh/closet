package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

///�α��� ó���� ����ϴ� ���ͼ���
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	// preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("login") != null) {
		//�α����� ������
			response.sendRedirect("/");
			//login��ü�� ���� ������ loginȭ������ �̵�
			return false;		
		}
		return true;	//���� ȣ���Ϸ��� uri ȣ��
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
