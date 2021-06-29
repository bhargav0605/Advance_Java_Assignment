package com.phoenix.web.login;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 * @author bhargav.parmar@stltech.in
 */
@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//getting parameters
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		
		PrintWriter out = response.getWriter();
		
		//validating username and password
		if(username != null 
				&& password != null 
				&& username.equals("Thomas") 
				&& password.equals("thomas12")) {
			
			//dispatching request to welcome
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			
		} else {
			
			//Error
			out.println("<h1 style='color:red;'>Please try again.</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		//close print writer
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //end of class
