package com.training.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.entity.User;
import com.training.service.Validator;




/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
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
		String userName= request.getParameter("userName");
		String password=request.getParameter("password");
		String role="Developer";
		
		User loginInfo=new User(userName,password,role);
		
		boolean result=Validator.validate(loginInfo);
		RequestDispatcher newDispatcher;
		if(result== true) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			request.setAttribute("message","Welcome "+userName );
			newDispatcher = request.getRequestDispatcher("addDonor.jsp");
		} else {
			request.setAttribute("message","Invalid Access" );
			newDispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		newDispatcher.forward(request,response);
	}

}
