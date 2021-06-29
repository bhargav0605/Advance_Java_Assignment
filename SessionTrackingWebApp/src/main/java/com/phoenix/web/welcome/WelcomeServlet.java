package com.phoenix.web.welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 * @author bhargav.parmar@stltech.in
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setting content type
		response.setContentType("text/html");
		
		//Getting the user name parameter 
		String username = request.getParameter("username");
		
		/**
		 * HTTP Tasks
		 */
		
		//Http session
		HttpSession session = request.getSession();
		
		//session time-out
		//session.setMaxInactiveInterval(10);
		
		//Check session ID
		System.out.println("Welcome Servlet Session ID: "+session.getId());
		
		//Storing data in object
		session.setAttribute("user", username);
		
		//encoding product url / embedding 
		String encodedProductUrl = response.encodeURL("products");
		//System.out.println("Encoded URL of product: "+encodedProductUrl);
		
		//Printing values on HTML
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='pink'>"
				+ "<h2>Welcome "+username+"</h2>"
				+ "<h3> To enjoy shopping <a href='"+encodedProductUrl+"'>Click Here</a></h3>"
				+ "<p>Session time out is: " + session.getMaxInactiveInterval() + " seconds" 
				+ "</body>");
		
		//Redirect to google.com
		//response.sendRedirect("https://www.google.com");
		
		//close print writer
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
