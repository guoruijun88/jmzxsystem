package com.jm.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jm.pojo.Funs;
import com.jm.pojo.UserCustom;


/**
 * 判断该用户有没有越级访问
 * @author Administrator
 *
 */

public class SafeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
System.out.println("SafeFilter.doFilter()");
		//获得HttpServeltRequest对象，取得session
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		//获得访问资源uri
		String uri = req.getRequestURI();
		if(uri.indexOf("login.jsp")!=-1||uri.indexOf("userLogin.do")!=-1||uri.indexOf("findValidateCode.do")!=-1){
			chain.doFilter(request, response);
		}else{
			UserCustom userCustom = (UserCustom) session.getAttribute("userCustom");
System.out.println("SafeFilter.doFilter()"+userCustom);
				List<Funs> funs = userCustom.getFuns();
				boolean flag = false;
				for(Funs fun:funs){
					if(fun.getFunurl()!=null){
						if(uri.indexOf(fun.getFunurl())!=-1){
				System.out.println(fun.getFunurl());	
							flag=true;
							break;
						}
					}
				}
				if(flag){
					chain.doFilter(request, response);
				}else{
					((HttpServletResponse)response).sendRedirect("/norole.jsp");
				}
			}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
