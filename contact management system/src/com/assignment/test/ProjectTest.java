package com.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.assignment.daos.ContactDaoImpl;
import com.assignment.ifaces.DataAccess;
import com.assignment.model.Contact;
import com.assignment.utils.DbConnectionUtil;

import org.junit.jupiter.api.Test;


class ProjectTest {

	private Connection con;
	private DataAccess<Contact> dao;
	@BeforeEach
	public void beforeTestMethod()  {
		con = DbConnectionUtil.getMySqlConnection();
		 dao = new ContactDaoImpl();
	   }
	
	 @Test
	 @DisplayName(value="Test return 1 if Number is Already in Database ")
	    public void testFindStatus() {
	    
		 Contact  newContact = new Contact("Jatin","Lucknow",8095557454L,"./home",LocalDate.parse("1977-12-10"),"jatin95@yahoo.com","relative");

		  int numberStatus = dao.findByNumber(newContact.getMobileNumber());
		  		   
		   assertEquals(1, numberStatus);
	        return;
	    }
	 
	 @Test
	 @DisplayName(value="Test returns 1 if Contact Not Present in Database")
	    public void testAddData()
	    {
		 Contact  newContact = new Contact("udit","chennai",9867509863L,"udit.jpg",LocalDate.parse("1977-12-10"),"udit@gmail.com","relative");
		  int ContactAdded = dao.add(newContact);

		  assertEquals(1, ContactAdded);
		   
	        return;
	    }
	 
	 @Test
	 @DisplayName(value="Test returns 1 if Contact Not Present in Database")
	    public void testUpdateData()
	    {
		 
	
		 
		 Contact  newContact = new Contact("udit","Lucknow",9867509863L,"udit.jpg",LocalDate.parse("1977-12-10"),"udit@gmail.com","relative");
		  
		  int ContactUpdate = dao.update(newContact);
		  assertEquals(0, ContactUpdate);
		   
	        return;
	    }
	 
	 @Test
	 @DisplayName(value="Test returns 1 if Contact Present in Database and deletes it")
	    public void testDeleteData()
	    {
		 Long mobileNumber=8095557454L;
		
		  int ContactDeleted = dao.remove(mobileNumber);
		  assertEquals(1, ContactDeleted);
	        return;
	    }
	 
	 

}
