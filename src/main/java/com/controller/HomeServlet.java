package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDao;
import com.beans.Cart;
import com.beans.Food;
import com.services.CartService;
import com.services.HomeService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		CartService cs = new CartService();
		LoginDao ld = new LoginDao();
		String isLogin = "false";
		try {
			isLogin = session.getAttribute("isLogin").toString();
		}catch(NullPointerException n) {
			isLogin = "false";
		}
		if(isLogin.equals("true")) {
			String action = request.getParameter("action");
			ArrayList<Food> pizzas = new ArrayList<Food>();
			ArrayList<Food> burgers = new ArrayList<Food>();
			ArrayList<Food> drinks = new ArrayList<Food>();
			ArrayList<Food> pastas = new ArrayList<Food>();
			HomeService hs = new HomeService();
			pizzas = hs.getPizzas();
			burgers = hs.getBurgers();
			drinks = hs.getDrinks();
			pastas = hs.getPastas();
			session.setAttribute("pizzas", pizzas);
			session.setAttribute("burgers", burgers);
			session.setAttribute("drinks", drinks);
			session.setAttribute("pastas", pastas);
			if(action.equals("index")) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("menu")) {
	
				session.setAttribute("size", pizzas.size()/2+1);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("services")) {
				RequestDispatcher rd = request.getRequestDispatcher("services.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("about")) {
				RequestDispatcher rd = request.getRequestDispatcher("about.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("contact")) {
				RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("cart")) {
				String userId = session.getAttribute("user").toString();
				String source = request.getParameter("source").toString();
				String cartId = userId;
				String foodId = request.getParameter("foodid");
				int quantity = 1;
				Date orderDate = new Date();
				System.out.println(orderDate);
				Cart cart = new Cart(cartId, userId, foodId, quantity, orderDate);
				if(cs.addCart(cart)) {
					session.setAttribute("message", "Message: Added to cart");
					RequestDispatcher rd = request.getRequestDispatcher("HomeServlet?action="+source);
					rd.forward(request, response);
				}
			}
			else if(action.equals("cartView")) {
				@SuppressWarnings("unused")
				String userId = session.getAttribute("user").toString();
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			}
			else if(action.equals("delete")) {
				String userId = session.getAttribute("user").toString();
				String cartId = userId;
				String foodId = request.getParameter("foodid");
				Cart cart = new Cart(cartId, userId, foodId, 0, null);
				if(cs.deleteCart(cart)) {
					response.sendRedirect("HomeServlet?action=cartView");
				}
			}
			else if(action.equals("update")) {
				String userId = session.getAttribute("user").toString();
				String cartId = userId;
				String foodId = request.getParameter("foodid");
				Date orderDate = new Date();
				int quantity = -1;
				if(request.getParameter("source").equals("cart-plus"))
					quantity = 1;
				Cart cart = new Cart(cartId, userId, foodId, quantity, orderDate);
				if(cs.updateCart(cart)) {
					response.sendRedirect("HomeServlet?action=cartView");
				}
			}
			else if(action.equals("checkout")) {
				ld.deleteCart(session.getAttribute("user").toString());
				response.sendRedirect("landing2.jsp");
			}
		}
		else
			response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
