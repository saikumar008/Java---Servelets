package com_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_entity.Team;
import com_service.Service_Implementations;

/**
 * Servlet implementation class IPL_WEB_APP_FSD_26
 */
@WebServlet("/IPL_WEB_APP_FSD_26")
public class IPL_WEB_APP_FSD_26 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPL_WEB_APP_FSD_26() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		List<Team> teamList= new Service_Implementations().fetchAll();
		request.setAttribute("allTeams",teamList);
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
		} 
		catch (ClassNotFoundException |SQLException e ) 
		{
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String RequestType=request.getParameter("request_type");
		PrintWriter out =response.getWriter();
		
		if(RequestType.equalsIgnoreCase("addteam"))
			{
				
				try {
					String name=request.getParameter("teamname");
					String city=request.getParameter("teamcity");
					String state=request.getParameter("teamstate");
					Team team=new Team();
					team.setName(name);
					team.setCity(city);
					team.setState(state);
					int r=new Service_Implementations().insertion(team);
					if(r!=0)
						doGet(request, response);
					else
						out.write("<h1>data not inserted</h1>");
				    } 
				 catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if(RequestType.equalsIgnoreCase("modifyteam"))
		{
			
			try {
				int teamid=Integer.parseInt(request.getParameter("teamid"));
				Team team=new Service_Implementations().getTeamById(teamid);
				request.setAttribute("team",team);
				RequestDispatcher rd=request.getRequestDispatcher("EditTeam.jsp");
				rd.include(request, response);
			} 
			catch (ClassNotFoundException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(RequestType.equalsIgnoreCase("updateteam"))
		{	
			try {
				Team team=new Team();
				team.setName(request.getParameter("teamname"));
				team.setCity(request.getParameter("city"));
				team.setState(request.getParameter("state"));
				team.setTeamid(Integer.parseInt(request.getParameter("teamid")));
				int r=new Service_Implementations().Update(team);
				if(r==0)
				{
					out.write("<h1>data not updated</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("EditTeam.jsp");
					rd.include(request, response);
				}	
				else
				{
					doGet(request, response);
				}
				
			    } 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(RequestType.equalsIgnoreCase("deleteteam"))
		{
			try {
				int teamid=Integer.parseInt(request.getParameter("teamid"));
				int r = new Service_Implementations().deletion(teamid);
				if(r==0)
				{
					out.write("<h1>data not deleted</h1>");
				}	
				else
				{
					doGet(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}

