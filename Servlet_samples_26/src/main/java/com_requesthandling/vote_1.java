package com_requesthandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;


/**
 * Servlet implementation class vote_1
 */
@WebServlet("/vote_1")
public class vote_1 extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		try {
			String name = request.getParameter("u_name");
			String password = request.getParameter("u_paw");
			RequestDispatcher rd = null;
			User1 use = getDetails(name,password);
			PrintWriter out = response.getWriter();
		if(use != null) 
				rd = request.getRequestDispatcher("validate");
			else 
				rd = request.getRequestDispatcher("Notvalidate"); 
		rd.forward(request, response);
			
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	private User1 getDetails(String name, String password) throws SQLException, ClassNotFoundException {
		User1 use = null;
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kumar","root","root");
		
		PreparedStatement ps = con.prepareStatement("select userid,email from user where name=? and password=?");
		
		ps.setString(1, name);
		ps.setString(2, password);
		
		
		ResultSet rs =  ps.executeQuery();
		
		if(rs.next()) {
			use = new User1();
		    use.setUserid(rs.getInt(1));
		    use.setEmail(rs.getString(2));
		}
		con.close();
		return use;
		
	}
		
	}

	

