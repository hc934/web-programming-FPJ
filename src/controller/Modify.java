package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountCheck;
import model.User;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
		String mod = request.getParameter("mod");
		if ("mod".equals(mod)){
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String education = request.getParameter("education");
			String accountName = request.getParameter("accountName");
			String password = request.getParameter("password");
			
			User user = AccountCheck.addNewUser(name, address, phoneNumber, education, accountName, password, hashMap);
			
			hashMap.put(accountName, user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Admin");
			dispatcher.forward(request, response);
		}
		else{
			String	accountName = request.getParameter("accountName");
			
			User user = hashMap.get(accountName);
			hashMap.remove(accountName);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	}


