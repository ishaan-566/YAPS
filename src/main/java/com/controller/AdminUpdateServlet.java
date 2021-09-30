package com.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Food;
import com.beans.PizzaStore;
import com.services.AdminService;

/**
 * Servlet implementation class AdminUpdateServlet
 */
@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");

		if(action.equals("update-dish")) {
			String foodId = request.getParameter("id");
			String name = request.getParameter("Name");
			int price = Integer.parseInt(request.getParameter("Price"));
			String type = request.getParameter("Type");
			String image = name.replaceAll("\\s+", "")+".jpg";
            image = image.toLowerCase();
			String description = request.getParameter("Description");
			Food food = new Food(foodId, name, type, description, price, image);
			AdminService as = new AdminService();
			if(as.update(food)) {
				request.setAttribute("message", "Update Successful");
			}
			else {
				request.setAttribute("message", "Error : Dish Cannot be Updated ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=update-dish");
			rd.forward(request, response);
		}
		
		else if(action.equals("dish")) {
			LinkedHashMap<String, String> al = new LinkedHashMap<String, String>();
			String foodId = request.getParameter("id");
			AdminService as = new AdminService();
			Food food = as.getFood(foodId);
			al.put("Name", food.getName());
			al.put("Type", food.getType());
			al.put("Price", Integer.toString(food.getPrice()));
			request.setAttribute("columns", al);
			request.setAttribute("id", foodId);
			request.setAttribute("Description", food.getDescription());
			request.setAttribute("update", "dish");
			RequestDispatcher rd = request.getRequestDispatcher("update-page.jsp");
			rd.forward(request, response);
		}
		
		if(action.equals("update-store")) {
			String city = request.getParameter("City");
			long mobileNo = Long.parseLong(request.getParameter("MobileNumber"));
			String name = request.getParameter("Name");
			int pincode = Integer.parseInt(request.getParameter("Pincode"));
			String state = request.getParameter("State");
			String storeId = request.getParameter("id");
			String street = request.getParameter("Street");
			PizzaStore store = new PizzaStore(storeId, name, mobileNo, city, street, state, pincode);
			AdminService as = new AdminService();
			if(as.update(store)) {
				request.setAttribute("message", "Update Successful");
			}
			else {
				request.setAttribute("message", "Error : Store Cannot be Updated ");
			}
			RequestDispatcher  rd= request.getRequestDispatcher("AdminServlet?action=update-store");
			rd.forward(request, response);
		}
		
		else if(action.equals("store")) {
			LinkedHashMap<String, String> al = new LinkedHashMap<String, String>();
			String storeId = request.getParameter("id");
			AdminService as = new AdminService();
			PizzaStore store = as.getStore(storeId);
			al.put("Name", store.getName());
			al.put("MobileNumber", Long.toString(store.getMobileNo()));
			al.put("Street", store.getStreet());
			al.put("City", store.getCity());
			al.put("Pincode", Integer.toString(store.getPincode()));
			al.put("State", store.getState());
			request.setAttribute("columns", al);
			request.setAttribute("id", storeId);
			request.setAttribute("update", "store");
			RequestDispatcher rd = request.getRequestDispatcher("update-page.jsp");
			rd.forward(request, response);
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
