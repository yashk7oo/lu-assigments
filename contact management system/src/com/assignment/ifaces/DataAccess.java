package com.assignment.ifaces;

import java.io.File;
import java.util.List;

public interface DataAccess<T> {
	
	public int findByNumber(Long mobileNumber);
	public int add(T t);
	public int update(T update);
	public int remove(Long mobileNumber);

	
	public int addContactFromFile(File myFile);
	public void birthdayReport(int month,int choice);
	public void contactByGroup(int option);
	public void contactByGroupSize(int option);
	public void contactByNameAndEmail(int option);
	public void contactByNameAndMobile(int option);
	

}
