package cn.leelei.bms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import cn.leelei.bms.dao.UserDao;
import cn.leelei.bms.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 注册
	// private List<User> list;
	//
	//
	// public List<User> getList() {
	// return list;
	// }
	//
	//
	// public void setList(List<User> list) {
	// this.list = list;
	// }
	// public void registUser(){
	//
	// }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * //1.中方式 实现用户登录并显示到页面 String uesrName =
		 * request.getParameter("userName"); String passWord =
		 * request.getParameter("passWord"); //获取dao中密码账户 User user = new
		 * User(); //将用户输入的密码账户传到User中 user.setUserName(uesrName); //MD5加密
		 * user.setUpassWord(DigestUtils.md5Hex(passWord)); //得到dao中的校验方法
		 * UserDao userDao = new UserDao();
		 * 
		 * User LoginUser = userDao.ValidateUser(user); //存储用户信息到Session中
		 * request.getSession().setAttribute("LoginUser", LoginUser); //转发到用户界面中
		 * request.getRequestDispatcher("WEB-INF/users/index.jsp").forward(
		 * request, response);
		 */

		// 2.使用BeanUtils 实现用户登录并显示到页面
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			// 得到dao中的校验方法
			UserDao userDao = new UserDao();
			// 得到需要的操作
			String method = request.getParameter("method");
			if ("login".equals(method)) {
				user.setPassWord(DigestUtils.md5Hex(user.getPassWord()));

				// 校验密码
				User LoginUser = userDao.ValidateUser(user);
				// 判断LoginUser 登录用户 不为空就登陆成功
				if (LoginUser != null) {

					// 存储用户信息到Session中
					request.getSession().setAttribute("LoginUser", LoginUser);

					// fzc start
					// 获取传入的页面参数
					int currentPage = Integer.parseInt(request.getParameter("currentPage"));

					// 获取分页数据(传入当前页数参数为1)
					List<User> list = userDao.findUserListByCurrentPage(currentPage);

					//获取总页数
					int userTotalNum=userDao.findUserTotalNum();
					
					System.err.println(userTotalNum+"==="+list);//测试总数核查出来的数
					
					int pageNum=userTotalNum/4;
					if(userTotalNum%4!=0){
						pageNum++;
					}
					
					
					  //得到所有的数据 // 
					 //List<User> list = userDao.findall();
					  
					  //fzc end //将数据放到
					  request.setAttribute("users",list);
					  
					  request.setAttribute("pageNum",pageNum);
					  //转发到用户界面中 //修改jsp文件，重新填充数据
					 
					  
					  
					 request.getRequestDispatcher("WEB-INF/users/index.jsp").forward(request, response);
					 // 返回列表界面重定向
					response.sendRedirect(request.getContextPath() + "/LoginServlet");
					return ;
					

				} else {
					// 登陆失败的 给出提示并跳转到登录注册页面
					request.setAttribute("msg", "用户或者密码有误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				// 否则删除 删除后回到列表界面
			} else if ("delete".equals(method)) {
				userDao.deleteUserByid(user);
				// 返回列表界面重定向
				response.sendRedirect(request.getContextPath() + "/LoginServlet");
			} else if (method == null) {
				// 列表界面
				List<User> list = userDao.findall();
				// 将数据放到request中
				request.setAttribute("users", list);
				// 转发到用户界面中
				request.getRequestDispatcher("WEB-INF/users/index.jsp").forward(request, response);
			} else if ("logout".equals(method)) {
				HttpSession session = request.getSession();
				// 清除所有数据
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");

			} else if ("toAdd".equals(method)) {
				// 到达添加界面
				request.getRequestDispatcher("WEB-INF/users/add.jsp").forward(request, response);
			} else if ("add".equals(method)) {
				// 添加操作 操作完城跳转到列表页面
				user.setPassWord(DigestUtils.md5Hex(user.getPassWord()));

				userDao.AddUser(user);
				// 跳转到列表页面
				response.sendRedirect(request.getContextPath() + "/LoginServlet");
				// 编辑界面
			} else if ("toEdit".equals(method)) {
				// 1.将需要修改的数据库中查询出来
				User temp = userDao.findUserinfoById(user.getId());
				// 2 .放到request 中去
				request.setAttribute("editUser", temp);
				// 3 .转发到编辑界面
				request.getRequestDispatcher("WEB-INF/users/modify.jsp").forward(request, response);
				// 修改， 判断一下密码是否修改如修改就加密
			} else if ("update".equals(method)) {
				if ("1".equals(request.getParameter("flag"))) {
					user.setPassWord(DigestUtils.md5Hex(user.getPassWord()));// 界面传过来的密码

				}
				// 更新数据库中的数据
				userDao.updateUser(user);
				// 跳转到列表页面
				response.sendRedirect(request.getContextPath() + "/LoginServlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
