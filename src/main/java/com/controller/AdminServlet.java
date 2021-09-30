package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Food;
import com.beans.PizzaStore;
import com.beans.UserCredentials;
import com.services.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			String uname = request.getParameter("username");
			String pwd = request.getParameter("pass");
			UserCredentials user = new UserCredentials();
			user.setUserId(uname);
			user.setPassword(pwd);
			HttpSession sn = request.getSession();
			AdminService as = new AdminService();
			boolean flag=as.login(user);
			if(flag)
			{
				sn.setAttribute("user", uname);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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
		
		else if(action.equals("user")) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("UserId", "text");
			map.put("Password", "text");
			map.put("LoginStatus", "text");
			ArrayList<UserCredentials> admin = new ArrayList<UserCredentials>();
			AdminService as = new AdminService();
			admin = as.getAdmin();
			request.setAttribute("columns", map);
			request.setAttribute("records", admin);
			request.setAttribute("add", "user");
			RequestDispatcher rd = request.getRequestDispatcher("admin-add.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("add-user")) {
			AdminService as = new AdminService();
			String uname = request.getParameter("UserId");
			String pwd = request.getParameter("Password");
			UserCredentials user = new UserCredentials();
			user.setLoginStatus(true);
			user.setPassword(pwd);
			user.setUserId(uname);
			user.setUserType("admin");
			if(as.add(user))
			{
				request.setAttribute("message", "Added Successful");
			}
			else {
				request.setAttribute("message", "Error : User Cannot be added ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=user");
			rd.forward(request, response);
		}
		
		else if(action.equals("delete-user")) {
			String userId = request.getParameter("id");
			UserCredentials user = new UserCredentials();
			user.setUserId(userId);
			AdminService as = new AdminService();
			if(as.delete(user)) {
				request.setAttribute("message", "Deleted Successful");
			}
			else {
				request.setAttribute("message", "Error : User Cannot be deleted ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=user");
			rd.forward(request, response);
		}
		
		else if(action.equals("dish")) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("FoodId", "text");
			map.put("Name", "text");
			map.put("Type", "text");
			ArrayList<Food> dishes = new ArrayList<Food>();
			AdminService as = new AdminService();
			dishes = as.getDishes();
			LinkedHashMap<String, String> other = new LinkedHashMap<String, String>();
			other.put("Price", "number");
			request.setAttribute("columns", map);
			request.setAttribute("records", dishes);
			request.setAttribute("add", "dish");
			request.setAttribute("others", other);
			RequestDispatcher rd = request.getRequestDispatcher("admin-add.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("add-dish")) {
			AdminService as = new AdminService();
			String foodId = request.getParameter("FoodId");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
            String description = request.getParameter("Description");
            int price = Integer.parseInt(request.getParameter("Price"));
            String image = name.replaceAll("\\s+", "")+".jpg";
            image = image.toLowerCase();
			Food dish = new Food(foodId, name, type, description, price, image);
			if(as.add(dish))
			{
				request.setAttribute("message", "Added Successful");
			}
			else {
				request.setAttribute("message", "Error : Dish Cannot be added ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=dish");
			rd.forward(request, response);
		}
		
		else if(action.equals("delete-dish")) {
			String foodId = request.getParameter("id");
			Food food = new Food();
			food.setFoodId(foodId);
			AdminService as = new AdminService();
			if(as.delete(food)) {
				request.setAttribute("message", "Deleted Successful");
			}
			else {
				request.setAttribute("message", "Error : Food Cannot be deleted ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=dish");
			rd.forward(request, response);
		}
		else if(action.equals("update-dish")) {
			ArrayList<String> al = new ArrayList<String>();
			al.add("FoodId");
			al.add("Name");
			al.add("Type");
			ArrayList<Food> dishes = new ArrayList<Food>();
			AdminService as = new AdminService();
			dishes = as.getDishes();
			request.setAttribute("columns", al);
			request.setAttribute("records", dishes);
			request.setAttribute("update", "dish");
			RequestDispatcher rd = request.getRequestDispatcher("admin-update.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("store")) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("StoreId", "text");
			map.put("Name", "text");
			map.put("MobileNumber", "number");
			ArrayList<PizzaStore> stores = new ArrayList<PizzaStore>();
			AdminService as = new AdminService();
			stores = as.getStores();
			LinkedHashMap<String, String> other = new LinkedHashMap<String, String>();
			other.put("Street", "text");
			other.put("City", "text");
			other.put("State", "text");
			other.put("Pincode", "number");
			request.setAttribute("columns", map);
			request.setAttribute("records", stores);
			request.setAttribute("add", "store");
			request.setAttribute("others", other);
			RequestDispatcher rd = request.getRequestDispatcher("admin-add.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("add-store")) {
			AdminService as = new AdminService();
			String city = request.getParameter("City");
			long mobileNo = Long.parseLong(request.getParameter("MobileNumber"));
			String name = request.getParameter("Name");
			int pincode = Integer.parseInt(request.getParameter("Pincode"));
			String state = request.getParameter("State");
			String storeId = request.getParameter("StoreId");
			String street = request.getParameter("Street");
			PizzaStore store = new PizzaStore(storeId, name, mobileNo, city, street, state, pincode);
			if(as.add(store))
			{
				request.setAttribute("message", "Added Successful");
			}
			else {
				request.setAttribute("message", "Error : Store Cannot be added ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=store");
			rd.forward(request, response);
		}
		
		else if(action.equals("delete-store")) {
			String foodId = request.getParameter("id");
			PizzaStore store = new PizzaStore();
			store.setStoreId(foodId);
			AdminService as = new AdminService();
			if(as.delete(store)) {
				request.setAttribute("message", "Deleted Successful");
			}
			else {
				request.setAttribute("message", "Error : Store Cannot be deleted ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=store");
			rd.forward(request, response);
		}
		
		else if(action.equals("update-store")) {
			ArrayList<String> al = new ArrayList<String>();
			al.add("StoreId");
			al.add("Name");
			al.add("MobileNumber");
			ArrayList<PizzaStore> stores = new ArrayList<PizzaStore>();
			AdminService as = new AdminService();
			stores = as.getStores();
			request.setAttribute("columns", al);
			request.setAttribute("records", stores);
			request.setAttribute("update", "store");
			RequestDispatcher rd = request.getRequestDispatcher("admin-update.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
