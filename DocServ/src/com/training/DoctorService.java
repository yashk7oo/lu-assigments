package com.training;

import com.training.entity.*;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.training.daos.DoctorDaoImpl;



@Path("/doctors")
public class DoctorService {
	public String message="";
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response getMessage() {
		
		
		DoctorDaoImpl dao = new DoctorDaoImpl();
		 List<Doctor> list = dao.findAll();
		return Response.status(200).entity(list).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDoctor(Doctor doc) {	
		
		DoctorDaoImpl dao = new DoctorDaoImpl();
		int rowAdded= dao.add(doc);
		if(rowAdded == 1) {
			return Response.status(201).entity(doc).build();
		} else {
			return Response.status(500).entity("Exception").build();
		}
		
		
	}

}
