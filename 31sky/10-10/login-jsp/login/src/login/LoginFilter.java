package login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class LoginFilter{
	  public void destroy() {
		  
	  }
	  
	  public void doFilter(ServletRequest arg0, ServletResponse arg1,
	      FilterChain arg2) throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest)arg0;
	      HttpServletResponse resp =(HttpServletResponse) arg1;
	      HttpSession session = req.getSession();
	      
	      String path = req.getRequestURI();
	      
	      String password = (String) session.getAttribute("pwd");
	      
	      if(path.indexOf("login.jsp") > -1) {
	    	  arg2.doFilter(req, resp);
	          return;
	      }else{
	    	  if (password == null || "".equals(password)) {
	    		  resp.sendRedirect("login.jsp");
	    	  }else{
	    		  arg2.doFilter(req, resp);
	            }
	    	  }
	      }
	  public void init(FilterConfig arg0) throws ServletException {
		  
	  }

}
