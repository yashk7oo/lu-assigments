package com.training.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.DonorDaoImpl;
import com.training.entity.BloodDonor;
import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

/**
 * Servlet implementation class BloodDonorsServlet
 */
@WebServlet("/blood")
public class BloodDonorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection con;
	 DataAccess<BloodDonor> dao=null;
    public BloodDonorsServlet() {
        super();
        // TODO Auto-generated constructor stub
        con =DbConnectionUtil.getMySqlConnection();
        dao= new DonorDaoImpl();
    }
    
  
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //response.getWriter().append(con.toString()).append(request.getContextPath());
		
		List<BloodDonor> list = dao.findAll();
		System.out.println(list);
		
		request.setAttribute("donorList", list);
		RequestDispatcher newDispatcher=request.getRequestDispatcher("viewDonors.jsp");
		newDispatcher.forward(request,response);
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  String name=request.getParameter("donorName");
		  int age=Integer.parseInt(request.getParameter("donorAge"));
		  String gender=request.getParameter("donorGender");
	      String bloodGroup=request.getParameter("donorBloodGroup");
		  int phoneNumber=Integer.parseInt(request.getParameter("donorNumber"));
		  String email=request.getParameter("donorEmail");
		  LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dateOfBirth"));
		 
		 BloodDonor donor = new BloodDonor(name,age,gender,bloodGroup,phoneNumber,email,dateOfBirth);
		 
		 int rowAdded=dao.add(donor);
		 
			request.setAttribute("rowsAdded", rowAdded);
			RequestDispatcher newDispatcher=request.getRequestDispatcher("addDonor.jsp");
			newDispatcher.forward(request,response);
	}

}
