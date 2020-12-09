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
	
	public boolean writeTotextFile(Professor prof,File file) {
		boolean result = false;
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))) {
			
			writer.println(prof);
			result=true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
		public Professor[] readFromTextFile(File file) {
			Professor[] list = new Professor[4];
			Professor newList[] = list;
			
			
			
			
			String line=null;
			
			try(BufferedReader reader=new BufferedReader(new FileReader(file))){
				int i=0;
				while( (line=reader.readLine())!=null) {
					
					String[] values= line.split(",");
					Professor prof= new Professor(Integer.parseInt(values[0]),values[1],values[2],values[3]);
					list[i]=prof;
					
					
					if(i == (list.length-1)) {
						 System.arraycopy(list, 0, newList, 0, list.length);
						  list = new Professor[list.length*2];
						  System.arraycopy(newList, 0, list, 0, newList.length);
						  newList = list;
						
					}
						
					i++;
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
				return list;
	}
	
}
