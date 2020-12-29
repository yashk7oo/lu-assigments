package com.training;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.assignment.daos.ContactDaoImpl;
import com.assignment.ifaces.DataAccess;
import com.assignment.model.Contact;

public class Application {
	
	public static void main(String args[]) {
		
		 String name;
	     String address;
		 Long mobileNumber;
		 String profilePicture;
		 LocalDate dateOfBirth=LocalDate.now();
		 String email;
		 String  groupName;
		 String file="";
		 int option;
		 int choice = 10;
		 
		 List<String> list=new ArrayList<String>();
		 
		 Scanner sc = new Scanner(System.in);
		 
		 boolean operationsLeft=true;
		 
		 while(operationsLeft ==  true) {
			 System.out.println("Please Choose your option\n1: Add New Contact\t"
			 		+ "2: Update Existing Contact\t3: Remove Contact\n4:Read data from file\t5: Generate BirthDay Report By Month\t"
			 		+ "6: Generate Contact List Based on Group\n"
			 		+ "7: Generate Contact List Based on Group Size\n"
			 		+ "8: List contacts with name and email\t9:List contacts with name and mobile\t10:Exit");
			 
			 System.out.print("Enter your Choice := ");
			 
			 try{
				 choice =  sc.nextInt();
				 
			} catch (Exception e) {
				System.out.println("Invalid Choice");
				// TODO: handle exception
			}
			
			 
			 DataAccess<Contact> dao = new ContactDaoImpl();
			 
			 switch(choice){
			 
			 
			 case 1:
				 
				 System.out.println("Enter contact name");
				 
				 name=sc.next()+sc.nextLine();
				 
                  System.out.println("Enter contact number as 10 digit");
				 
				 mobileNumber=sc.nextLong();
				 
				 int result=dao.findByNumber(mobileNumber);
				 
				 if(result == 1 ) {
					 System.out.println("Another user with contact number "+mobileNumber+" already exists.\n"
					 		+ "To update contact press 1 or else type any digit to go to main menu");
					 int newChoice=sc.nextInt();
					 
					 if(newChoice == 1) {
						 
						 System.out.println("Enter new contact name");						 
						 name=sc.next()+sc.nextLine();
						 
                         System.out.println("Enter new contact address");						 
						 address=sc.next()+sc.nextLine();
						 
                         System.out.println("Enter new profile picture");						 
						 profilePicture=sc.next()+sc.nextLine();
						 
                         System.out.println("Enter new Date Of Birth as YYYY-MM-DD");						 
						 String dob =sc.next()+sc.nextLine();						 
						 try {
							 dateOfBirth = LocalDate.parse(dob);
						} catch (Exception e) {
							//e.printStackTrace();
							System.out.println("Invalid date format");
						}
                      
						 System.out.println("Enter new email");						 
						 email=sc.next()+sc.nextLine();
						 
                         System.out.println("Enter new group(relative, close friend or professional friend");						 
						 groupName=sc.next()+sc.nextLine();
						 
						Contact newContact = new Contact(name,address,mobileNumber,profilePicture,dateOfBirth
								,email,groupName);
						
						result=dao.update(newContact);
						
						if(result == 1) {
							System.out.println("Contact updated successfully");
						} 
						 
						 
					 } 
				 } else {
					 
					 System.out.println("Enter contact address");					 
					 address=sc.next()+sc.nextLine();
					 
					 
					 System.out.println("Enter profile picture");					 
					 profilePicture=sc.next()+sc.nextLine();
					 
                     System.out.println("Enter Date Of Birth as YYYY-MM-DD");					 
					 String dob =sc.next()+sc.nextLine();
					 try {
						 dateOfBirth = LocalDate.parse(dob);
					} catch (Exception e) {
						//e.printStackTrace();
						System.out.println("Invalid date format");
					}
					 
                  
					 System.out.println("Enter email");					 
					 email=sc.next()+sc.nextLine();
					 
                     System.out.println("Enter group(relative, close friend or professional friend");					 
					 groupName=sc.next()+sc.nextLine();
					 
					 Contact newContact = new Contact(name,address,mobileNumber,profilePicture,dateOfBirth
							,email,groupName);
					 
					 result=dao.add(newContact);
					 
					 if(result == 1) {
							System.out.println("Contact added successfully");
						} 
					 
				 }
				 
				 
				 break;
				 
				 
				 
				 
			 case 2:
				 
				 System.out.println("Enter new contact name");						 
				 name=sc.next()+sc.nextLine();
				 
                 System.out.println("Enter new contact address");						 
				 address=sc.next()+sc.nextLine();
				 
                 System.out.println("Enter already existing contact number as 10 digit");
				 
				 mobileNumber=sc.nextLong();
				 
                 System.out.println("Enter new profile picture");						 
				 profilePicture=sc.next()+sc.nextLine();
				 
                 System.out.println("Enter new Date Of Birth as YYYY-MM-DD");						 
				 String dob =sc.next()+sc.nextLine();						 
				 try {
					 dateOfBirth = LocalDate.parse(dob);
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Invalid date format");
				}
              
				 System.out.println("Enter new email");						 
				 email=sc.next()+sc.nextLine();
				 
                 System.out.println("Enter new group(relative, close friend or professional friend");						 
				 groupName=sc.next()+sc.nextLine();
				 
				Contact newContact = new Contact(name,address,mobileNumber,profilePicture,dateOfBirth
						,email,groupName);
				
				result=dao.update(newContact);
				
				if(result == 1) {
					System.out.println("Contact updated successfully");
				} 
				
				break;
				
				
				
				
				
			 case 3:
					System.out.print("Enter contact number");
					mobileNumber = sc.nextLong();
					int rowsDeleted = dao.remove(mobileNumber);
					
					if(rowsDeleted == 1) {
					System.out.println("Contact with mobile number "+mobileNumber+" successfully deleted");
					} else {
						System.out.println("Could not find/delete contact having mobile number "+mobileNumber);
					}
				   break;
				   
				   
				   
				   
				   
			 case 4:
				 
				 System.out.print("Enter Name of csv file");
				   file = sc.next()+sc.nextLine();
				   File myFile = new File(file);
				   int rowsAdded = dao.addContactFromFile(myFile);
				   System.out.println("Successfully added "+rowsAdded+" records");
				   break;
				   
				   
				   
				   
				   
				   
			 case 5:
				 boolean bdayLoop = true;
				 
				 System.out.println("Enter the value of month in integer to generate report");
				 int month= sc.nextInt();
				 
				 if(month>13 || month<1) {
					 System.out.println("Invalid Input");
				 } else {
					 while(bdayLoop) {
						 System.out.println("\n 1) Genrate Report in Console\t2) Genrate Report in File\t3) exit\nSelect Option := ");
						 option=sc.nextInt();
						 
						 if(option ==1 || option== 2) {
						 dao.birthdayReport(month, option);
						 
					 } else {
						 bdayLoop=false;
					 }
				 }
			   
				 
				 
			 }
				 break;
				 
				 
				 
				 
				 
				 
			 case 6:
				 
				 boolean groupLoop = true;
				 
				 while(groupLoop) {
					 System.out.println("\n 1) Genrate Report in Console\t2) Genrate Report in File\t3) exit\nSelect Option := ");
					 option=sc.nextInt();
					 
					 if(option ==1 || option== 2) {
					 dao.contactByGroup(option);
					 
				 } else {
					 groupLoop=false;
				 }
			 }
				 break;
				 
				 
				 
				 
				 
				 
				 
			 case 7:
				 boolean groupSizeLoop = true;
				 while(groupSizeLoop) {
					 System.out.println("\n 1) Genrate Report in Console\t2) Genrate Report in File\t3) exit\nSelect Option := ");
					 option=sc.nextInt();
					 
					 if(option ==1 || option== 2) {
					 dao.contactByGroupSize(option);
					 
				 } else {
					 groupSizeLoop=false;
				 }
			 }
				 break;
			 case 8:
				 
				 boolean iLoop = true;
				 while(iLoop) {
					 System.out.println("\n 1) Genrate Report in Console\t2) Genrate Report in File\t3) exit\nSelect Option := ");
					 option=sc.nextInt();
					 if(option ==1 || option== 2) {
					 dao.contactByNameAndEmail(option);
					 
				 } else {
					 iLoop=false;
				 }
			 }
				 break;
			 case 9:
				 
				 boolean inLoop = true;
				 while(inLoop) {
					 System.out.println("\n 1) Genrate Report in Console\t2) Genrate Report in File\t3) exit\nSelect Option := ");
					 option=sc.nextInt();
					 
					 if(option ==1 || option== 2) {
					 dao.contactByNameAndMobile(option);
					 
				 } else {
					 inLoop=false;
				 }
			 }
				 break;
				 
				 default:
					 operationsLeft = false;
					 System.out.println("Thanks for using my application");
					 break;
				 
				 
		   
				 
				 
				 
		 }
	}

}
}
