package com.jm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jm.pojo.UserCustom;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		//获得登录请求的uri
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		//login.jsp,userLogin.do放行
		if(uri.indexOf("login.jsp")!=-1||uri.indexOf("userLogin.do")!=-1||uri.indexOf("findValidateCode.do")!=-1){
	
			chain.doFilter(request, response);
		}else{
			UserCustom userCustom = (UserCustom) session.getAttribute("userCustom");
			if(userCustom!=null&&userCustom.getUsername().length()>0){
				chain.doFilter(request, response);
			}else{
				//用户没有登录
				req.setAttribute("msg", "不登录不好使");
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
