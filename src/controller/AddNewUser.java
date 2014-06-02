package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import model.AccountCheck;
import model.User;

/**
 * 這支Servlet程式扮演Controller的角色
 */
@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String jspPageToForward = null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		// 取得submit參數
		String page = request.getParameter("submit");

		// 若Client是填寫完資料後的呼叫
		if ("下一頁".equals(page)) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String education = request.getParameter("education");
			
			//HttpSession session = request.getSession();
			session.setAttribute("name",name);
			session.setAttribute("address",address);
			session.setAttribute("phoneNumber",phoneNumber);
			session.setAttribute("education",education);
			
			// forward到userInfoPage
			jspPageToForward = "addUserPage2.jsp";
		}
		else if ("送出".equals(page)){
			HashMap <String , User> hashMap = (HashMap <String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
			String accountName = request.getParameter("accountName");
			if (AccountCheck.checkAccountNameExistence(accountName, hashMap)==true){
				String message = "所輸入的帳戶名稱已經有人使用，請輸入另一個帳戶名稱!";
				request.setAttribute("message", message);
				jspPageToForward = "addUserPage2.jsp";
			}
			else{
				String password = request.getParameter("password");
				//HttpSession session = request.getSession();
				String name = (String)session.getAttribute("name");
				String address = (String)session.getAttribute("address");
				String phoneNumber = (String)session.getAttribute("phoneNumber");
				String education = (String)session.getAttribute("education");
				
				//System.out.println(name);
				//System.out.println(address);
				//System.out.println(accountName);
				
				User newUser = AccountCheck.addNewUser(name,address,phoneNumber,education,accountName,password,hashMap);
				request.setAttribute("user",newUser);
				//System.out.println(hashMap.get(accountName).getName());
				
				//System.out.println(newUser.getName());
				
				jspPageToForward = "userInfoPage.jsp";
			}
			session.invalidate();
		}
		else{
			jspPageToForward = "addUserPage.jsp";
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(jspPageToForward);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
