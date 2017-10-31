package cn.leelei.bms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import cn.leelei.bms.dao.UserDao;
import cn.leelei.bms.entity.User;
@WebServlet("/Register")
public class Register extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public Register() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String realname = request.getParameter("realName");
	/*	System.err.println(username+password+realName);*/
		UserDao userdao = new UserDao();
		User users= new User();
		users.setPassWord(DigestUtils.md5Hex(password));
		users.setUserName(username);
		users.setRealName(realname);
		userdao.AddUser(users);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	public void init() throws ServletException {
		
	}

}
