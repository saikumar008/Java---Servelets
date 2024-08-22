package com_examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello_26
 */
@WebServlet("/Hello_26")
public class Hello_26 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello_26() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		int num = 101;
//		String name = "Sai kumar";
//		PrintWriter out = response.getWriter();
//		out.write("<html><body style='background-color: skyblue; text-align: center'>");
//		out.write("<h style='color: white'>Welcome "+ name + num + "</h>");
//		out.write("</html></body>");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();
		PrintWriter out = response.getWriter();
		if(num%2==0) {
			out.write("<html><body>");
			out.write("<h1>It is not a prime"+ num +"</h1>");
			out.write("</html></body>");
		}else {
			out.write("<html><body>");
			out.write("<h1>It is a prime " + num +"</h1>");
			out.write("</html></body>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
