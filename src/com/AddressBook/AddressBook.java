package com.AddressBook;

import java.util.Scanner;

/**
 * Program for creating contact in address book
 * @author Sheetal
 * @since 2021-08-12
 */
public class AddressBook {
			//variables
			private  String FirstName;
			private String LastName;
			private String State;
			private String City;
			private String Address;
			private long ZipCode;
			private long PhoneNO;
			private String Email;
			
			
			Scanner userinput = new Scanner(System.in);
			
			//getters and setters  for  each variable
			public String getFirstName() {
				return FirstName;
			}
			public void setFirstName(String firstName) {
				FirstName = firstName;
			}
			public String getLastName() {
				return LastName;
			}
			public void setLastName(String lastName) {
				LastName = lastName;
			}
			public String getState() {
				return State;
			}
			public void setState(String state) {
				State = state;
			}
			public String getCity() {
				return City;
			}
			public void setCity(String city) {
				City = city;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			public long getZipCode() {
				return ZipCode;
			}
			public void setZipCode(long zipCode) {
				ZipCode = zipCode;
			}
			public long getPhoneNO() {
				return PhoneNO;
			}
			public void setPhoneNO(long phoneNO) {
				PhoneNO = phoneNO;
			}
			public String getEmail() {
				return Email;
			}
			public void setEmail(String email) {
				Email = email;
			}
			
			/**
			 * This method takes details from user and
			 * set parameters to that details and then
			 * print all the details of user
			 */
			public void contactDisplay()
			{
				    System.out.println("Enter a first name: ");
				    setFirstName(userinput.nextLine()); 
				
				    System.out.println("Enter a last name: ");
				    setLastName(userinput.nextLine()); 
				    
				    System.out.println("Enter a state: ");
				    setState(userinput.next());
				    
				    System.out.println("Enter a city: ");
				    setCity(userinput.next());
					  
				    
				    
				    System.out.println("Enter a address: ");
				    setAddress(userinput.next());
				   
				    System.out.println("Enter a zipcode: ");
				    setZipCode(userinput.nextLong());
				    
				    
				    System.out.println("Enter a phoneno: ");
				    setPhoneNO(userinput.nextLong());
				   
				    System.out.println("Enter a email: ");
				    setEmail(userinput.next());
				    
				    
				    
				    System.out.println("name: " + this.getFirstName());
				    System.out.println("last name: " + this.getLastName());
				    System.out.println("state: " + this.getState());
				    System.out.println("zipcode: " + this.getZipCode());
				    System.out.println("city: " + this.getCity());
				    System.out.println("phone_no: " + this.getPhoneNO());
				    System.out.println("email: " + this.getEmail());
				    System.out.println("email: " + this.getEmail());
							
			
			}
			
			/**
			 * This is the main method that
			 * creates object of user in class addressbook and
			 * calls contactDisplay method to main 
			 */
			public static void main(String[] args)
			{

				 AddressBook user1 = new  AddressBook();
				 user1.contactDisplay();
			}
}
