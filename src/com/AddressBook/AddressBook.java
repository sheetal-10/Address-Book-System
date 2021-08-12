package com.AddressBook;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Program for creating contact in address book
 * @author Sheetal
 * @since 2021-08-12
 */
public class AddressBook {
	static Scanner sc = new Scanner(System.in);
	 static ArrayList<Contact> contactList = new ArrayList<>();
	   
	    public static void main(String[] args) 
	    {
	    	// Welcome message
	        System.out.println("Welcome to the Address book program"); 
	        AddressBook addressBook = new AddressBook();
	        addressBook.addingContactList();
	    }
    
    /** 
     * To display the names of persons that are added 
     */
	    public void display(ArrayList<Contact> contactList)
		   {
		        for (Contact contact : contactList) 
		        {
		            System.out.println(contact);
		        }
		    }
		    
    
    /** 
     * Asks the user for details of the person and storing in person List 
     */
    public void addContact(Contact contactItems, ArrayList<Contact> contactList) {

        contactItems = new Contact();

        System.out.println("Enter first name : ");
        contactItems.firstName = sc.next();

        System.out.println("Enter last name : ");
        contactItems.lastName = sc.next();

        System.out.println("Enter address : ");
        contactItems.address = sc.next();
       

        System.out.println("Enter city : ");
        contactItems.city = sc.next();

        System.out.println("Enter state : ");
        contactItems.state = sc.next();

        System.out.println("Enter zip code : ");
        contactItems.zip = sc.nextInt();

        System.out.println("Enter phone number : ");
        contactItems.phoneNumber = sc.nextLong();

        System.out.println("Enter email : ");
        contactItems.email = sc.next();

        contactList.add(contactItems);

    }

    /** 
     * Asks the user to edit existing details using the name of the person 
     */
    
    public void editContact() 
	{

        System.out.println("Enter the first name of contact you wish to edit");
        String edit = sc.nextLine();
        System.out.println("Press 1 - To edit first name");
        System.out.println("Press 2 - To edit last name");
        System.out.println("Press 3 - To edit address");
        System.out.println("Press 4 - To edit city");
        System.out.println("Press 5 - To edit state");
        System.out.println("Press 6 - To edit zip code");
        System.out.println("Press 7 - To edit phone number");
        System.out.println("Press 8 - To edit email");
        int choice = sc.nextInt();
        if (choice == 1) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new first name");
                    contactItems.firstName = sc.next();
                }
            }
        }
        if (choice == 2) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new last name");
                    contactItems.lastName = sc.next();
                }
            }
        }
        if (choice == 3) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new address");
                    contactItems.address = sc.next();
                }
            }
        }
        if (choice == 4) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new city");
                    contactItems.city = sc.next();
                }
            }
        }
        if (choice == 5) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new state");
                    contactItems.state = sc.next();
                }
            }
        }
        if (choice == 6) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new zip code");
                    contactItems.zip = sc.nextInt();
                }
            }
        }
        if (choice == 7) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new phone number");
                    contactItems.phoneNumber = sc.nextLong();
                }
            }
        }
        if (choice == 8) {
            for (Contact contactItems : contactList) {
                if (contactItems.firstName.equals(edit)) {
                    System.out.println("Enter new email");
                    contactItems.email = sc.next();
                }
            }
        }
    }
    
    /** 
     * Asks the user to delete existing details using the name of the person 
     */
    
    public void deletingContact(ArrayList<Contact> contactList) 
    {
        System.out.println("Enter the first name of the contact you wish to delete");
        String delete = sc.next();
        contactList.removeIf(contact -> contact.firstName.equals(delete));   
    }

 	
    /**
     * Method to choose an option
     */
    public void addingContactList() {
        while (true) {
            System.out.println("Press 0 - Display all contacts");
            System.out.println("Press 1 - Add contact");
            System.out.println("Press 2 - Edit contact");
            System.out.println("Press 3 - Delete contact");
            System.out.println("Press 4 - Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0 -> display(contactList);
                case 1 -> addContact(null, contactList);
                case 2 -> editContact();
                case 3 -> deletingContact(contactList);
            }
            if (option == 4) {
                break;
            }
        }
    }
}
