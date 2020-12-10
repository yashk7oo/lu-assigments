package com.example.demo.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileService {
	
	public boolean writeToFile(String[] arr,File file) {
		
		boolean result = false;
		
try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
			
			outStream.writeObject(arr);
			
			result = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	public void readFromTextFile(File file) {
		
		String line=null;
		
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			int i=0;
			while( (line=reader.readLine())!=null) {
				
				String[] values= line.split(",");
				System.out.println(Integer.parseInt(values[0])+" "+values[1]+" "+values[2]+" "+values[3]);
				i++;
	            }
     

           } catch(IOException e) {
				e.printStackTrace();
			}
	}
}
