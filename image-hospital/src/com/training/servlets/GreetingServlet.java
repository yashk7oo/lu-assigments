package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.java.Doctor;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServlet() {
        super();
        System.out.println("Constructor called");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(request.getClass().getName());
		System.out.println(response.getClass().getName());
		
		
		request.setAttribute("heading", "Our Specialists");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("showDoctor.jsp");
		dispatcher.forward(request,response);
		//PrintWriter writer = response.getWriter();
		//response.setContentType("text/html");
		//writer.println("<h1 style='text-align:center'>Image Hospital</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
		String doctorName=request.getParameter("doctorName");
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
	    long doctorNumber=Long.parseLong(request.getParameter("doctorNumber"));
		String specialization=request.getParameter("specialization");
		LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dateOfBirth"));
		
		Doctor doc=new Doctor(doctorId,doctorName,doctorNumber,specialization,dateOfBirth);
		
		
		
		request.setAttribute("doctor", doc);
		RequestDispatcher newDispatcher=request.getRequestDispatcher("success.jsp");
		newDispatcher.forward(request,response);
		
		
	}

}
