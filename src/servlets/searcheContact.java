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

import entities.Contact;
import entities.Entreprise;
import services.ContactService;
import services.IContactService;

/**
 * Servlet implementation class searcheContact
 */
public class searcheContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searcheContact() {
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
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		String country=request.getParameter("country");
		String zip=request.getParameter("zip");
		long numSiret = 0;
		String phoneNumber=request.getParameter("phoneNumber");
		if (request.getParameter("numSiret")!=""){
			numSiret=Long.parseLong(request.getParameter("numSiret"));
		}
				
				
		//recuperation du groupe
		//String group = request.getParameter("group");
		
		IContactService contactService=new ContactService();
		List<Contact> searchResut=new ArrayList<Contact>();
		//searchResut=contactService.searchContact(firstName);
	
		//searchResut= contactService.searchContact(firstName,lastName,email,city,street,country,zip,phoneNumber);
	
		searchResut= contactService.searchContactBy(firstName,lastName,email,city,street,country,zip);

		RequestDispatcher rd=request.getRequestDispatcher("searchContact.jsp");
		request.setAttribute("result", searchResut);
		rd.forward(request, response);	
		
	}

}
