package cn.leelei.bms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter("/")
public class RightFileter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//先获取附加参数
		String method = request.getParameter("method");
		//说明是登录请求
		if("login".equals(method)){
			//登录请求放行
			filterChain.doFilter(request, response);
		}else{
			//判断用户是否登陆过
			if(request instanceof HttpServletRequest){
				Object user = ((HttpServletRequest) request).getSession().getAttribute("LoginUser");
				
				if(user!=null){
					filterChain.doFilter(request, response);
				}else{
					request.setAttribute("msg", "请重新登陆");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {


	}

}
