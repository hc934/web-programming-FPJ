package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
		if (hashMap == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("null.jsp");
			dispatcher.forward(request, response);
		}
		else if (hashMap.isEmpty()){
			RequestDispatcher dispatcher = request.getRequestDispatcher("null.jsp");
			dispatcher.forward(request, response);
		}
		
		else{			
			ArrayList <User> users = new ArrayList <User>();
			for (String key : hashMap.keySet()){
				users.add(hashMap.get(key));
			}
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
