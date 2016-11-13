package com.dbleak42;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		HttpSession session = request.getSession(); // used to save variables across requests
		ServletContext context = request.getServletContext();
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName); // saves the variable into the session
			context.setAttribute("savedUserName", userName); // saves the variable across all servlets and sessions
		}
		
		out.println("GET Hello " + "<strong>" + userName + "</strong>" +". <br>" + "Your user id is " + userId + "<br>");
		out.println("<font color='red'>" + "SESSION " + "</font>" + "Hello " + session.getAttribute("savedUserName") +". <br>");
		out.println("<font color='blue'>" + "CONTEXT " + "</font>" + "Hello " + context.getAttribute("savedUserName") +". <br>");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String profession = request.getParameter("profession");
		String hoursWorked = request.getParameter("hoursWorked");
		String[] availability = request.getParameterValues("availability");  // gets multiple values
		out.println("POST  Hello " + userName + "<br><br>");
		out.println("\nYour user id is " + userId + "<br><br>");
		out.println("Chosen profession: " + profession + "<br><br>");
		out.println("Hours Worked: " + hoursWorked + "<br><br>");
		out.println("AVAILABILITY: <br>");
		for (int i = 0; i < availability.length; i++) {
			out.println(availability[i]+ "<br>");
			System.out.println();
		}
	}

}
