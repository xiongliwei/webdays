package com.atguigu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web.bean.User;
import com.atguigu.web.dao.UserDao;
import com.atguigu.web.dao.UserDaolmpl;

public class LoginServlet extends HttpServlet{

	private UserDao userdao;
	
	public LoginServlet(){
		userdao=new UserDaolmpl();
	}
	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("用户名："+username+"，密码："+password);
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		User fu;
		try {
			fu = userdao.findUserByNameAndPassword(username, password);
			if (fu == null) {
				req.setAttribute("errorInfo", "用户名或密码错误！");
				
				//  /0508_Day02/index.jsp
				req.getRequestDispatcher("/index.jsp").forward(req, resp);;
			}else {
				writer.print("登陆成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
