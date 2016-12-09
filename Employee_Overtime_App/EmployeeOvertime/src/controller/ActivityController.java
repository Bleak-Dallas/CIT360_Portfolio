package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Activity;
import model.ActivityModel;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet("/ActivityController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityModel am = new ActivityModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityController() {
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
		Activity a = new Activity();
		String errorMessage = null;
		if (request.getParameter("activityName") != "" && request.getParameter("activityDate") != "") {
			// format and parse the date before setting the hire date
			String activityDateStr = request.getParameter("activityDate");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date activityDate = in.parse(activityDateStr);
				a.setActivityName(request.getParameter("activityName"));
				a.setActivityDate(activityDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.am.addActivity(a);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			errorMessage = "No fields can be blank <br> Please try again";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("addActivity.jsp").forward(request, response);
				
		}
	}

}
