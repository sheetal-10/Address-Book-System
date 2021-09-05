package com.AddressBook;

import java.util.*;
import java.util.stream.Collectors;


/**
 * This code takes input from console as name, address, phone number, email .
 * @author Sheetal
 * @since 2021-09-04
 */
public class ContactFunctions {
	private static Scanner scan = new Scanner(System.in);
	ArrayList<ContactItems> personList = new ArrayList<>();
	Map<String, ArrayList<ContactItems>> addressBook = new HashMap<String, ArrayList<ContactItems>>();

	// Asks the user for details of the person and storing in person List
	public void addDetails() {
		ContactItems person = new ContactItems();
		var wrapper = new Object() {
			boolean flag = true;
		};
		// boolean flag = true;
		System.out.print("\nEnter Existing Book name or New Book Name to add contact : ");
		String bookName = scan.next();

		if (addressBook.containsKey(bookName)) {
			System.out.println("Contact will be added to existing '" + bookName + "' Book");
		} else {
			System.out.println("New Address Book Created with the Name '" + bookName + "'");
		}

		System.out.print("\nEnter First name : ");
		String firstName = scan.next();
		person.setFirstName(firstName);

		System.out.print("Enter Last name : ");
		String lastName = scan.next();
		person.setLastName(lastName);

		// Ensuring there is no Duplicate Entry of the same Person in a Address Book
		try {
			personList.stream().filter(contactList -> contactList.getFirstName().equals(firstName)
					&& contactList.getLastName().equals(lastName)).forEach(contactList -> {
						System.out.println("Can not allow Duplicate Contact");
						addDetails();
						wrapper.flag = false;
					});
		} catch (Exception e) {
			System.out.println();
		}

		while (wrapper.flag) {

			System.out.print("Enter Address : ");
			person.setAddress(scan.next());

			System.out.print("Enter City name : ");
			person.setCity(scan.next());

			System.out.print("Enter State name : ");
			person.setState(scan.next());

			System.out.print("Enter ZIP Code : ");
			person.setZipCode(scan.next());

			System.out.print("Enter Phone Number : ");
			person.setPhoneNumber(scan.next());

			System.out.print("Enter E-Mail ID : ");
			person.setEmail(scan.next());

			// Adding the details into list
			personList.add(person);
			addressBook.put(bookName, personList);
			System.out.println("\nGiven Details are added into the Book");

			wrapper.flag = false;
		}

	}

	/**
	 * To search for the given name in the list
	 * @return Index of First name
	 */
	private int searchName() {
		System.out.println("\nEnter the First name of person: ");
		String searchName = scan.next();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(searchName)) {
				return i;
			} else if (i == personList.size() - 1) {
				System.out.println("Given name is not found in the Book");
			}
		}
		return personList.size();
	}

	// Asks the user to edit existing details using the name of the person
	public void editDetails() {
		int index = searchName();
		if (index != personList.size()) {
			ContactItems details = personList.get(index);
			System.out.println(details.toString());
			System.out.println("\nEnter slot number that to be edit from above");
			int slotnumber = scan.nextInt();
			while (slotnumber < 10) {
				switch (slotnumber) {
				case 0:
					slotnumber = 10;
					break;
				case 1:
					System.out.print("\nEnter First name : ");
					details.setFirstName(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 2:
					System.out.print("\nEnter Last name : ");
					details.setLastName(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 3:
					System.out.print("Enter Address : ");
					details.setAddress(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 4:
					System.out.print("Enter City name : ");
					details.setCity(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 5:
					System.out.println("Enter State name : ");
					details.setState(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 6:
					System.out.println("Enter ZIP Code : ");
					details.setZipCode(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 7:
					System.out.print("Enter Phone Number : ");
					details.setPhoneNumber(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				case 8:
					System.out.print("Enter E-Mail ID : ");
					details.setEmail(scan.next());
					System.out.println("\nEnter other slot number to Edit or Press'0' to Exit");
					slotnumber = scan.nextInt();
					break;
				default:
					System.out.println("Enter valid input");
				}
			}
			System.out.println("After Updating:" + details.toString());
		}
	}

	// Asks the user to delete existing details using the name of the person
	public void deleteDetails() {
		int index = searchName();
		if (index != personList.size()) {
			personList.remove(index);
			System.out.println("Given name details were deleted from the list");
		}
	}

	// To show existing details using the name of the person
	public void showDetails() {
		int index = searchName();
		if (index != personList.size()) {
			ContactItems person = personList.get(index);
			System.out.println(person.toString());
		}
	}

	// To show list of Persons Across the city or State
	public void contactBycity() {
		System.out.println("Enter Name of City or State to get Contact List : ");
		String nameCityState = scan.next();
		try {
			System.out.print("\nContact list of persons across '" + nameCityState + "' is");
			personList.stream().filter(contactList -> contactList.getCity().equals(nameCityState)
					|| contactList.getState().equals(nameCityState)).forEach(contactList -> {
						System.out.println(contactList.getFirstName() + " " + contactList.getLastName());
					});
		} catch (Exception e) {
			System.out.println("Exception occured while getting Contact List");
		}
	}

	// To display the names of persons that are added
	public void displayContacts() {
		try {
			System.out.println("\nContacts in AddessBook:");
			personList.stream().forEach(contactList -> {
				System.out.println(contactList.getFirstName() + " " + contactList.getLastName());
			});
		} catch (Exception e) {
			System.out.println("Exception occured while getting Contact List");
		}
	}

	// To get number of contact persons in Book
	public void contactsCount() {
		System.out.println("Enter Name of City or State to get count of Contacts across city or state");
		String nameCityState = scan.next();
		var wrapper = new Object() {
			int count = 0;
		};
		personList.stream().filter(contactList -> contactList.getCity().equals(nameCityState)
				|| contactList.getState().equals(nameCityState)).forEach(contactList -> {
					wrapper.count++;
				});
		System.out.println("Number of contact persons in " + nameCityState + " is : " + wrapper.count);
	}

	// To sort the entries in the address book alphabetically by Person's name
	public void sortByName() {
		addressBook.keySet().forEach((String name) -> {
			addressBook.get(name).stream().sorted(Comparator.comparing(ContactItems::getFirstName))
					.collect(Collectors.toList()).forEach(person -> System.out.println(person.toString()));
		});
	}

}
