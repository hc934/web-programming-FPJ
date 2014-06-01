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
		String accountName = request.getParameter("accountName");
		String password = request.getParameter("password");
		String message = "";
		/*
		// 取得submit參數
		String page = request.getParameter("submit");
		if (page.equals("送出")){
			accountName = request.getParameter("accountName");
			password = request.getParameter("password");
		}*/
		System.out.println("HIIIIIII");
		
		//get hashmap
		HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
		if (hashMap == null){
			HashMap<String, User> newMap = new HashMap<String, User>();
			getServletContext().setAttribute("hashMap", newMap);
		}
		
		Cookie[] cookies = request.getCookies();
		//自動登入，Cookie紀錄使用者資料
		if (cookies != null){
			System.out.println("COOOOO");
			String uname = "";
			String pwd = "";
			for (Cookie cookie : cookies){
				String cname = cookie.getName();
				String cvalue = cookie.getValue();
				if (cname.equals("accountName")){
					uname = cvalue;
				}
				else if (cname.equals("password")){
					pwd = cvalue;
				}
			
			//HashMap <String , User> hashMap = (HashMap<String, User>) this.getServletConfig().getServletContext().getAttribute("hashMap");
				if (!hashMap.isEmpty()){
					if (AccountCheck.checkAccountNameExistence(uname,hashMap)){
						if (AccountCheck.checkPassword(uname, pwd,hashMap)){
							User user = hashMap.get(uname);
							request.setAttribute("user",user);
							jspPageToForward = "userInfoLogin.jsp";
						}
					}
				}			
			}
			jspPageToForward = "login.jsp";
		}
		//帳號錯誤
		else if (!AccountCheck.checkAccountNameExistence(accountName,hashMap)){
			System.out.println("accountttt");
			message = "輸入帳號錯誤，查無此帳號";
			request.setAttribute("message", message);
			jspPageToForward = "login.jsp";
		}
		//密碼錯誤
		else if (!AccountCheck.checkPassword(accountName, password,hashMap)){
			System.out.println("passss");
			message = "輸入密碼錯誤";
			request.setAttribute("message", message);
			jspPageToForward = "login.jsp";
		}
		//沒有輸入accountName == null
		else if (accountName.equals("")&&password.equals("")){
			System.out.println("NOOOOO");
			message = "請輸入帳號與密碼";
			request.setAttribute("message", message);
			jspPageToForward = "login.jsp";
		}
		else{
			String page = request.getParameter("submit");
			if (page.equals("送出")){
				System.out.println("GOOOD");
				User user = hashMap.get(accountName);
				request.setAttribute("user", user);		
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
			else{
				System.out.println("firstttt");
				jspPageToForward = "login.jsp";
			}
			
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
