package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountCheck;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	String jspPageToForward = null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String accountName = "";
		String password = "";
		
		
		// 取得submit參數
		String page = request.getParameter("submit");
		if (page.equals("送出")){
			accountName = request.getParameter("accountName");
			password = request.getParameter("password");
		}
		
		
		//get hashmap
		HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
		if (hashMap == null){
			HashMap<String, User> newMap = new HashMap<String, User>();
			getServletContext().setAttribute("hashMap", newMap);
		}
		
		Cookie[] cookies = request.getCookies();
		//自動登入，Cookie紀錄使用者資料
		if (cookies != null){
			for (Cookie cookie : cookies){
				String cname = cookie.getName();
				String cvalue = cookie.getValue();
				if (cname.equals("accountName")){
					accountName = cvalue;
				}
				else if (cname.equals("password")){
					password = cvalue;
				}
			}
			//HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
			if (!hashMap.isEmpty()){
				if (AccountCheck.checkAccountNameExistence(accountName,hashMap)){
					if (AccountCheck.checkPassword(accountName, password,hashMap)){
						User user = hashMap.get(accountName);
						request.setAttribute("user",user);
						RequestDispatcher dispatcher = request.getRequestDispatcher("userInfoLogin.jsp");
						dispatcher.forward(request, response);
					}
				}
			}			
		}
		else if (!AccountCheck.checkAccountNameExistence(accountName,hashMap)){
			String message = "輸入帳號錯誤，查無此帳號";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else if (!AccountCheck.checkPassword(accountName, password,hashMap)){
			String message = "輸入密碼錯誤";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

		else{
			//用Cookies處理自動登入
			String auto = request.getParameter("auto");
			if (auto.equals("勾選")){
				Cookie accountCookie = new Cookie("accountName",accountName);
				accountCookie.setMaxAge(24*60*60); 
				response.addCookie(accountCookie);
				Cookie pwdCookie = new Cookie("password",password);
				pwdCookie.setMaxAge(24*60*60); 
				response.addCookie(pwdCookie);
			}
			
			// show使用者的資料
			jspPageToForward = "userInfoLogin.jsp";
		}
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(jspPageToForward);
		dispatcher.forward(request, response);
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
