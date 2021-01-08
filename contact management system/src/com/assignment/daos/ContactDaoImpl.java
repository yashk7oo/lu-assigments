package com.assignment.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.assignment.ifaces.DataAccess;
import com.assignment.model.Contact;
import com.assignment.utils.DbConnectionUtil;


public class ContactDaoImpl implements DataAccess<Contact>{
	
	private Connection con;

	public ContactDaoImpl() {
		super();
		con=DbConnectionUtil.getMySqlConnection();
		
	}

	public ContactDaoImpl(Connection con){
		super();
		this.con = con;
	}
	
	@Override
	public int findByNumber(Long mobileNumber) {
		 int size=0;
		
		String sql= "select * from contacts where mobileNumber=?";
		
		try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			pstmt.setLong(1, mobileNumber);
		  ResultSet rs=pstmt.executeQuery();
		  try {
			    rs.last();
			    size = rs.getRow();
			    rs.beforeFirst();
			}
			catch(Exception ex) {
			    return size;
			}

		 
		
		
	} catch (Exception e) {
		System.err.println("Error accessing details for "+mobileNumber);
		//e.printStackTrace();
	}
		
		return size;
		
	}
	
	@Override
	public int add(Contact t) {
		
	    String sql= "insert into contacts values (?,?,?,?,?,?,?)";
		int rowsAdded=0;
		try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			
			pstmt.setString(1,t.getName());
			pstmt.setString(2, t.getAddress());
			pstmt.setLong(3,t.getMobileNumber());
			pstmt.setString(4, t.getProfilePicture());			
			pstmt.setDate(5, Date.valueOf(t.getDateOfBirth()));
			pstmt.setString(6, t.getEmail());	
			pstmt.setString(7, t.getGroupName());	
			
			rowsAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error adding contact");
			e.printStackTrace();
		}
		return rowsAdded;
	}
	
	
	

	@Override
	public int update( Contact t) {
		String updateSql ="UPDATE contacts SET name= ?,address=?,profilePicture=?,dateOfBirth=?,email=?,groupName=? WHERE mobileNumber =  ?";
		int rowsAdded=0;
	    
		try(PreparedStatement pstmt= con.prepareStatement(updateSql)) {
			
			pstmt.setString(1,t.getName());
			pstmt.setString(2, t.getAddress());			
			pstmt.setString(3, t.getProfilePicture());			
			pstmt.setDate(4, Date.valueOf(t.getDateOfBirth()));
			pstmt.setString(5, t.getEmail());	
			pstmt.setString(6, t.getGroupName());	
			pstmt.setLong(7,t.getMobileNumber());
			rowsAdded = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("Could not update cobtact");
			e.printStackTrace();
			
		}
		return rowsAdded;
	}
	
	
	

	@Override
	public int remove(Long mobileNumber) {
		// TODO Auto-generated method stub
          int result = 0;
		
		
		
		String sql = "DELETE FROM contacts WHERE mobileNumber = ?";
					
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
						
				pstmt.setLong(1, mobileNumber);
						
				result =  pstmt.executeUpdate();
			} 
			catch (Exception e) {	
					//e.printStackTrace();
				System.err.println("Could not find/delete contact having mobile number "+mobileNumber);
			}
					
		return result;
	}
	
	
	
	
	@Override
	public int addContactFromFile(File myFile) {
		

        int count=0;
        int result=0;


          BufferedReader lineReader;
		try {
			lineReader = new BufferedReader(new FileReader(myFile));
		    String lineText = lineReader.readLine();
		     
		   
		    

	         while (lineText  != null) {
	              String[] data = lineText.split(",");
	              String name = data[0];
	              String address = data[1];
	              Long mobileNumber = Long.parseLong(data[2]);
	              String profilePicture = data[3];
	              LocalDate dateOfBirth = LocalDate.parse( data[4] );
	              String email = data[5];
	              String groupName = data[6];
	             
	              result=findByNumber(mobileNumber);
	              
	              if(result == 1) {
	            	  System.out.println("Record with mobile number "+mobileNumber+" alredy in database! Cannot be added");
	              } else {
	            	  
	            	  Contact newContact = new Contact(name,address,mobileNumber,profilePicture,dateOfBirth
								,email,groupName);
						 
						 add(newContact);
						 count++;
						 
	              }
	              lineText = lineReader.readLine();

	            
	             }
	          
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
          
    return count;
          }
	
	

	@Override
	public void birthdayReport(int month, int option) {
		
		Map<String, LocalDate> contactMap = new HashMap<>();
		 
		String sql= "select name,dateOfBirth from contacts where MONTH(dateOfBirth)=?";
		 ResultSet rs;
		 
		 try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			 
			   pstmt.setLong(1, month);
			   rs=pstmt.executeQuery();
			   
			   while(rs.next()) {
				   
					 String name=rs.getString("name");
					 LocalDate dateOfBirth=rs.getDate("dateOfBirth").toLocalDate();
					 
					 contactMap.put(name,dateOfBirth);			 
					 
			   }
			
		} catch (Exception e) {
			System.err.println("Error fetching birthdays");
			e.printStackTrace();
		}
		 
		 if(option == 1) {
			 
			 System.out.println("Birthdays in month "+ month+" are:\nName\tDate Of Birth\n\n");
			 
			 contactMap.forEach((key, value) -> System.out.println(key + "\t"+ value)); 
			 
		 } else if( option == 2 ) {
			 
			 writeToFIle(contactMap,"Birthdaylist.txt");
			 
		 }	else {
			 return;
		 }
			
		}

	private void writeToFIle(Map<String, LocalDate> contactMap, String fileName) {
		
		 try {
		      File myObj = new File(fileName);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      }
		      
		      FileWriter myWriter = new FileWriter(fileName);
		      myWriter.write("Name\tDate Of Birth\n\n");
		      
		      contactMap.forEach((key, value) -> {
				try {
					myWriter.write(key+"\t"+value+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} ); 
	     
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } catch (Exception e) {
		      System.out.println("Could not write to file");
		      e.printStackTrace();
		    }
		
	}

	@Override
	public void contactByGroup(int option) {
		

		List<String> list = new ArrayList<String>();
		 
		String sql= "select name,mobileNumber,groupName from contacts order by groupName";
		 ResultSet rs;
		 
		 try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			 
			   
			   rs=pstmt.executeQuery();
			   
			   while(rs.next()) {
				   
					 String name=rs.getString("name");
					 Long mobileNumber=rs.getLong("mobileNumber");
					 String groupName = rs.getString("groupName");
					 
					 
					 
					 list.add(name+"\t"+mobileNumber+"\t\t"+groupName);
					 
			   }
			
		} catch (Exception e) {
			System.err.println("Error fetching records");
			e.printStackTrace();
		}
		 
		 if(option == 1) {
			 
			 System.out.println("Contacts by Group :=");
			 
			
			 
			 list.forEach((value) -> System.out.println(value)); 
			 
			 
			 
		 } else if( option == 2 ) {
			 
			 writeToFIle(list,"ContactByGroup.txt");
			 
		 }	else {
			 return;
		 }
		
		
		
		
	}
	
	private void writeToFIle(List<String> list , String fileName) {
		
		 try {
		      File myObj = new File(fileName);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      }
		      
		      FileWriter myWriter = new FileWriter(fileName);
		   
		      
		      list.forEach((value) -> {
				try {
					myWriter.write(value+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} ); 
	     
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } catch (Exception e) {
		      System.out.println("Could not write to file");
		      e.printStackTrace();
		    }
		
	}

	@Override
	public void contactByGroupSize(int option) {
		
		
		List<String> list = new ArrayList<String>();
		List<String> freqCount= new ArrayList<String>();
		
		String fileHeader = ("CONTACT TYPE\t\tTOTAL COUNT\n\n");
		
		list.add(fileHeader);
		 
		String sql= "select groupName,count(*) as total from contacts group by groupName order by count(*)";
		 ResultSet rs;
		 
		 try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			 
			   
			   rs=pstmt.executeQuery();
			   
			   
			   
			   while(rs.next()) {
				   
				   String groupName = rs.getString("groupName");
				   String totalCount  = rs.getString("total");
					 
					 
					 list.add(groupName+"\t\t"+totalCount+"\n");
					 freqCount.add(groupName);
					 
					 
			   }
			
		} catch (Exception e) {
			System.err.println("Error fetching records");
			e.printStackTrace();
		}
		 
		 ListIterator<String> 
         iterator = freqCount.listIterator(); 	
		 
		 while(iterator.hasNext()) {
			 
			 String gName= iterator.next();
			 
			 String sqlNew= "select name,mobileNumber,groupName from contacts where groupName=?";
			 
			 try(PreparedStatement pstmt= con.prepareStatement(sqlNew)) {
				 
				   pstmt.setString(1, gName);
				   rs=pstmt.executeQuery();
				   list.add(gName.toUpperCase()+"\n");
				   
				   list.add("Name\tMobile\t\tGroup Name\n");
				   
				   
				   while(rs.next()) {				   
					
					   
					   
					     String name=rs.getString("name");
						 Long mobileNumber=rs.getLong("mobileNumber");
						 String groupName = rs.getString("groupName");
						 
						 
						 
						 list.add(name+"\t"+mobileNumber+"\t"+groupName);
						 
				   }
				   
				   list.add("\n\n");
				
			} catch (Exception e) {
				System.err.println("Error fetching records");
				e.printStackTrace();
			}
			 
			 
		 }
		 

		 
		 
		 if(option == 1) {
			 
			 
			 
			 System.out.println("Contacts by GroupSize :=");
			 
			
			 
			 list.forEach((value) -> System.out.println(value)); 
			 
			 
			 
		 } else if( option == 2 ) {
			 
			 writeToFIle(list,"ContactByGroupSize.txt");
			 
		 }	else {
			 return;
		 }
		
		
	}
	
	

	
	@Override
	public void contactByNameAndEmail(int option) {
		
		List<String> list = new ArrayList<String>();
		
          String fileHeader = ("CONTACT NAME\t\tEMAIL\n\n");
		
		list.add(fileHeader);
		 
		String sql= "select name,email from contacts";
		 ResultSet rs;
		 
		 try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			 
			   
			   rs=pstmt.executeQuery();
			   
			   while(rs.next()) {
				   
					 String name=rs.getString("name");
					 String email=rs.getString("email");
					 
					 list.add(name+"\t\t"+email);			 
					 
			   }
			
		} catch (Exception e) {
			System.err.println("Error fetching records");
			e.printStackTrace();
		}
		 
		 if(option == 1) {
			 
			 
			 
			 list.forEach((value) -> System.out.println(value)); 
			 
		 } else if( option == 2 ) {
			 
			 writeToFIle(list,"ContactByNameAndEmail.txt");
			 
		 }	else {
			 return;
		
		
	}
	}

	@Override
	public void contactByNameAndMobile(int option) {
		
		List<String> list = new ArrayList<String>();
		
        String fileHeader = ("CONTACT NAME\t\tMOBILE\n\n");
		
		list.add(fileHeader);
		 
		String sql= "select name,mobileNumber from contacts";
		 ResultSet rs;
		 
		 try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			 
			   
			   rs=pstmt.executeQuery();
			   
			   while(rs.next()) {
				   
					 String name=rs.getString("name");
					 Long mobileNumber=rs.getLong("mobileNumber");
					 
					 list.add(name+"\t\t"+mobileNumber);			 
					 
			   }
			
		} catch (Exception e) {
			System.err.println("Error fetching records");
			e.printStackTrace();
		}
		 
		 if(option == 1) {
			 
			 
			 
			 list.forEach((value) -> System.out.println(value)); 
			 
		 } else if( option == 2 ) {
			 
			 writeToFIle(list,"ContactByNameAndMobile.txt");
			 
		 }	else {
			 return;
		
		
	}
		
	}

	
	

	
	
	

}
	
	


	
	
	
	


