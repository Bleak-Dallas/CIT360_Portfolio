package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActivityModel;

/**
 * Servlet implementation class EmployeeActivityController
 */
@WebServlet("/EmployeeActivityController")
public class EmployeeActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityModel am = new ActivityModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeActivityController() {
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
			this.am.deleteActivity(this.am.findActivity(id));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
