package sitemanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DBHandlers.siteManagement;
import microwaveDataEntry.JsonmicroConverter;

/**
 * Servlet implementation class eraseSite
 */
@WebServlet("/eraseSite")
public class eraseSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String siteid = request.getParameter("siteIdString");
		
		System.out.println(siteid);
		siteManagement mgmt = new siteManagement();
		List<opcodata> list = new ArrayList<opcodata>();			
		list = mgmt.getOPCOS(siteid);
			 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(new jsonOpcodata(list));
		PrintWriter pw = response.getWriter();
		pw.println(json);		
	}

}
