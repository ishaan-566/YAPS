package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.beans.UserCredentials;
import com.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String action = request.getParameter("action");
		String isAdmin = request.getParameter("isadmin");
		HttpSession sn = request.getSession(false);
		if(isAdmin!=null && isAdmin.equals("true")) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminServlet");
			rd.forward(request, response);
		}
		else {
			if(action.equals("login")) {
				String uname = request.getParameter("username");
				String pwd = request.getParameter("pass");
				UserCredentials user = new UserCredentials();
				user.setUserId(uname);
				user.setPassword(pwd);
				LoginService ls = new LoginService();
				boolean flag=ls.login(user);
				if(flag)
				{
					sn.setAttribute("user", uname);
					sn.setAttribute("isLogin", "true");
					RequestDispatcher rd = request.getRequestDispatcher("HomeServlet?action=index");
					rd.forward(request, response);
				}
				else
				{
					sn = request.getSession();
					sn.setAttribute("user", "Invalid User");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			}
			
			else if(action.equals("signup")) {
				LoginService ls = new LoginService();
				String uname = request.getParameter("username");
				String pwd = request.getParameter("pass");
				String cpwd = request.getParameter("confirm");
				if(pwd.equals(cpwd)) {
					UserCredentials user = new UserCredentials();
					user.setLoginStatus(true);
					user.setPassword(pwd);
					user.setUserId(uname);
					user.setUserType("regular");
					if(ls.signup(user))
					{
						sn.setAttribute("user", uname);
						RequestDispatcher  rd= request.getRequestDispatcher("register.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("message", "Error : Cannot create an account ");
						RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
						rd.forward(request, response);
					}
				}
				else {
					request.setAttribute("message", "Error : Password Did not match");
					RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					rd.forward(request, response);
				}
			}
			
			else if(action.equals("register")){
				LoginService ls = new LoginService();
				String userId = (String) sn.getAttribute("user");
				String firstName = request.getParameter("fname");
				String lastName = request.getParameter("lname");
				Date d = null;
				try {
					d= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Date dateOfBirth = d;
				String gender = request.getParameter("gender");
				String street = request.getParameter("street");
				String location = request.getParameter("location");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				int pincode = Integer.parseInt(request.getParameter("pincode"));
				long mobileNumber = Long.parseLong(request.getParameter("number"));
				String emailId = userId;
				User user = new User(userId, firstName, lastName, dateOfBirth, gender,
						street, location, city, state, pincode, mobileNumber, emailId);
				if(ls.register(user)){
					RequestDispatcher  rd= request.getRequestDispatcher("HomeServlet?action=menu");
					rd.forward(request, response);
				}
				
			}
			
			else if(action.equals("logout")) {
				LoginService ls = new LoginService();
				String user = (String) sn.getAttribute("user");
				if(ls.logout(user)) {
					sn.invalidate();
					response.sendRedirect("login.jsp");
				}	
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
