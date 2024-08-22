package com_Jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Studentdetails
 */
@WebServlet("/Studentdetails")
public class Studentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("u_name");
		String hobbies =  request.getParameter("u_hobb");
		String dob = request.getParameter("u_date");
		
		int length = name.length();
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		if(length > 8) {
			out.write("<h1>welcome</h1>");
			rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);		
			}else {
			out.write("<h1>Not welcome</h1>");
			rd = request.getRequestDispatcher("RegistrationForm.html");
			rd.forward(request, response);
		}
		
	}

}
