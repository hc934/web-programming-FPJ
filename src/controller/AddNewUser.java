package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// 取得submit參數
		String page = request.getParameter("submit");

		// 若Client是填寫完資料後的呼叫
		if ("下一頁".equals(page)) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String education = request.getParameter("education");
			//User newUser = AccountCheck.addNewUser(name, address, phoneNumber, education);
			HttpSession session = request.getSession();
			session.setAttribute("name",name);
			session.setAttribute("address",address);
			session.setAttribute("phoneNumber",phoneNumber);
			session.setAttribute("education",education);
			
			// forward到userInfoPage
			jspPageToForward = "addUserPage2.jsp";
		}
		// 若Client端是第一次呼叫此Servlet程式, 準備填寫資料
		else if ("重設".equals(page)) {
			// forward到新增使用者的第1頁
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
