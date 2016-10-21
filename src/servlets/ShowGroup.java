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
import services.IContactGroupService;

public class ShowGroup  extends HttpServlet{
	
	private IContactGroupService groupeService = new ContactGroupService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("me voici "+req.getParameter("groupe"));
		List<ContactGroup> groupes = groupeService.showGroup();
		req.setAttribute("groupes", groupes);//les groupes 
		RequestDispatcher rd=req.getRequestDispatcher("showGroup.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
