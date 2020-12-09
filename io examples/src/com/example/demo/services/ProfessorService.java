package com.example.demo.services;

import java.io.*;

import com.example.demo.*;

public class ProfessorService {

	public boolean writeObjectToFile(Professor prof,File file) {
		
		boolean result= false;
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
			
			outStream.writeObject(prof);
			
			result = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Object readObjectFromFile(File file) {
		
		Object obj = null;
		
		try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))) {
			obj= inStream.readObject();
			
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
}
