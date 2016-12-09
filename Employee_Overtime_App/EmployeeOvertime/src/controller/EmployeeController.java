package controller;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.*;
import model.*;
import java.util.*;


/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeModel em = new EmployeeModel();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			this.em.deleteEmployee(this.em.findEmployee(id));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee ep = new Employee();
		String action = request.getParameter("action");
		String errorMessage = null;
 
		if (action.equals("add")) {
		if (request.getParameter("name") != "" && request.getParameter("hireDate") != "" && request.getParameter("seniority") != "") {
			int seniority = Integer.parseInt(request.getParameter("seniority"));
			if (!em.checkSeniority(seniority)) {
				ep.setEmployeeName(request.getParameter("name"));
				ep.setEmployeeSeniority(seniority);
				// format and parse the date before setting the hire date
				String hireDateStr = request.getParameter("hireDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date hireDate = sdf.parse(hireDateStr);
					ep.setEmployeeHireDate(hireDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.em.addEmployee(ep);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				errorMessage = "Seniority cannot match any other employees seniority <br> Please try again";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
			}
		}
		else {
			errorMessage = "No fields can be blank <br> Please try again";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
			
		}
	}	
	}
}

