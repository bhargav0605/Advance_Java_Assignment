package com.phoenix.web.login;

import java.io.IOException;
import java.io.PrintWriter;

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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//content type
		response.setContentType("text/html");
		
		//getting parameter
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		
		//response writer
		PrintWriter out = response.getWriter();
		
		//validation of username and password
		if(username != null 
				&& password != null 
				&& username.equals("Thomas") 
				&& password.equals("thomas12")) {
			out.println("<h2> Welcome " + username+"</h2>");
		} else {
			out.println("<h2> Error: Username or password is wrong. Please check. </h2>");
		}
		
		//closing writer
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //end of class
