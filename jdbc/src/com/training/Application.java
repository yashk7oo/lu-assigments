package com.training;

import java.sql.*;

import java.time.LocalDate;

import java.time.Month;

import com.training.daos.DoctorDaoImpl;
import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

public class Application {

	public static void main(String[] args) {
		
		
		int key=2;
		DataAccess<Doctor> dao= new DoctorDaoImpl();
	switch (key) {
	case 1:
		Doctor doc = new Doctor(103,"Suresh",944413000,"ORTHO",LocalDate.of(1970, Month.DECEMBER, 12));
		int rowAdded= dao.add(doc);
		System.out.println("Row Added :="+rowAdded);
		
		break;
	case 2:
		dao.findAll().stream().forEach(System.out::println);
		break;
	case 3:
		int id=103;
		int result=dao.remove(id);
		if(result>0)
		System.out.println("Record with id "+id+" removed succesfully");
		else
			System.out.println("No such record exists");
        break;
	case 4:
		Doctor docFound=dao.findById(103);
		System.out.println(docFound.toString());
		break;
	case 5:
		Doctor doc1= new Doctor(107,"Nikhil",6376383,"Pede",LocalDate.of(1972,Month.APRIL, 12));
		Doctor doc2= new Doctor(110,"Yash",6376383,"Pede",LocalDate.of(1975,Month.JANUARY, 21));
		
		int[] result1=dao.addInBatch(doc1,doc2);
		
		for(int resp: result1) {
			System.out.println(resp);
			
		}
		break;
	case 6:
		 DoctorDaoImpl dao2 = (DoctorDaoImpl)dao;
		 dao2.usingTransaction();
		 break;
		
	default:
		break;
	}
		

	}

}
