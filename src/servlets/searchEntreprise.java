package servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Contact;
import entities.Entreprise;
import services.ContactService;
import services.EntrepriseService;
import services.IContactService;
import services.IEntrepriseService;

/**
 * Servlet implementation class searcheContact
 */
public class searchEntreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchEntreprise() {
        super();
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
		//recuperation des parmatres 
		
		String numSiret=request.getParameter("numSiret");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		String country=request.getParameter("country");
		String zip=request.getParameter("zip");
				
		//recuperation du groupe
		//String group = request.getParameter("group");
		
		IEntrepriseService entrepriseService=new EntrepriseService();
		List<Entreprise> searchResut=new ArrayList<Entreprise>();
		
		System.out.println("iam in the servlet");
		
		//searchResut=contactService.searchContact(firstName);
	
		//searchResut= contactService.searchContact(firstName,lastName,email,city,street,country,zip,phone);
	
		searchResut = entrepriseService.searchEntrepriseBy(numSiret,firstName,lastName,email,city,street,country,zip);

		RequestDispatcher rd=request.getRequestDispatcher("searchEntreprise.jsp");
		request.setAttribute("result", searchResut);
		rd.forward(request, response);	
		
	}

}