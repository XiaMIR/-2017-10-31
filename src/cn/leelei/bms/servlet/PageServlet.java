package cn.leelei.bms.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.leelei.bms.dao.PageUser;
import cn.leelei.bms.entity.User;

public class PageServlet extends HttpServlet {
	int recordCount;
	private static final long serialVersionUID = 1L;


	public PageServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int pageNo = 1;
		PageUser paguser=new PageUser();
		List<User> lists=new ArrayList<User>();
		String pageno=request.getParameter("pageNos");
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}
		lists=paguser.listUser(pageNo);
		
		recordCount = paguser.getPage();
		request.setAttribute("recordCount", paguser.getPage());
		request.setAttribute("listss", lists);
		request.setAttribute("pageNos", pageNo);
		request.getRequestDispatcher("WEB-INF/users/index.jsp").forward(request, response);
		
	
	}

	
	public void init() throws ServletException {
		
	}

}
