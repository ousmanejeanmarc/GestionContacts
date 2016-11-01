package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContactGroupService;
import services.IContactGroupService;

public class UpdateGroup extends HttpServlet{
	IContactGroupService groupService = new ContactGroupService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idHide = request.getParameter("idGroup");
		System.out.println("idGroup------"+idHide + "new name "+request.getParameter("groupName"));
		if(idHide!="")
		{
			Long idGroup =Long.parseLong(idHide);
			String groupName = request.getParameter("groupName");
			groupService.updateGroup(idGroup,groupName);
			
			
			
		}

	}

}
