package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {
  public MyMappingExceptionResolver() {
    // Enable logging by providing the name of the logger to use
    setWarnLogCategory(MyMappingExceptionResolver.class.getName());
  }

  @Override
  public String buildLogMessage(Exception e, HttpServletRequest req) {
    return "MVC exception: " + e.getLocalizedMessage();
  }
    
  @Override
  protected ModelAndView doResolveException(HttpServletRequest req,
        HttpServletResponse resp, Object handler, Exception ex) {
	  	ModelAndView mav = super.doResolveException(req, resp, handler, ex);
        
    // Make the full URL available to the view - note ModelAndView uses
    if(ex instanceof MyBatisSystemException) {
    	mav.addObject("ex",ex.getMessage());
    	mav.setViewName("error/runtimeError");
    }
    return mav;
  }
}