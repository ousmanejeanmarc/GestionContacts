package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ContactGroup;
import services.ContactGroupService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		
		if(name.equals(password)){
			
			
			
			RequestDispatcher rd =request.getRequestDispatcher("accueil.jsp");		
			rd.forward(request, response);
			/****add jean-marc ***/			
		/*	RequestDispatcher rd =request.getRequestDispatcher("home.jsp");		
			rd.forward(request, response);
	*/
		
			
		}else {
			//response.sendRedirect("index.html");
			response.sendRedirect("index.jsp");
		}
	}

}
