package com.phoenix.web.products;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductServlet
 * @author bhargav.parmar@stltech.in
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setting content type
		response.setContentType("text/html");
		
		//Print writer to display html on web app
		PrintWriter out = response.getWriter();
		
		//HTTP Session Object
		HttpSession session = request.getSession(false); //return null if no session
		
		if(session != null) {
			System.out.println("Product Servlet session ID: "+session.getId());
			String username = (String) session.getAttribute("user");
			out.println("<h2>Dear " + username +" continue shopping.</h2>");
		} else {
			out.println("<h3> Sorry! No session.</h3>");
		}
		
		//Close the printwriter
		//out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
