package com.addressbook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This Program: 
 * Adds contact of AddressBook from AddressBookPojo.java 
 * Reads Data from readdata.csv and display in Console using method void read().
 * Writes data from console to writedata.csv using method void write().
 * @author sheetal
 * @since 2021-09-10
 */
public class AddressBookCSVMain {
	
	// Read data from data.csv 
	void readdata() throws Exception {
		
		//setting path of  CSV file
		String path = "D:\\Users\\sheet\\eclipse-workspace\\csvdemo\\src\\main\\java\\com\\addressbook\\readdata.csv";
		
		//parsing a CSV file into BufferedReader
		Reader reader = Files.newBufferedReader(Paths.get(path));
		
		//creating csvToBean object to import data from csv file to java application
		CsvToBean<AddressBookPojo> csvToBean = new CsvToBeanBuilder<AddressBookPojo>(reader)
				.withType(AddressBookPojo.class).withIgnoreLeadingWhiteSpace(true).build();

		// creating a List which contains String arrays (variables) of AddressBookPojo class
		List<AddressBookPojo> csvUsers = csvToBean.parse();
		for (AddressBookPojo csvUser : csvUsers) {
			System.out.println(
					"================================================================================================");
			System.out.println("fName :" + csvUser.getfName());
			System.out.println("lName :" + csvUser.getlName());
			System.out.println("addess :" + csvUser.getAddress());
			System.out.println("city :" + csvUser.getCity());
			System.out.println("state :" + csvUser.getState());
			System.out.println("Zip :" + csvUser.getZip());
			System.out.println("phoneNo :" + csvUser.getPhoneNo());
			System.out.println("email :" + csvUser.getEmail());
			System.out.println(
					"================================================================================================");
		}

	}
	
	// Write data from console to writedata.csv
	void WriteData() throws Exception {

		String path1 = "D:\\Users\\sheet\\eclipse-workspace\\csvdemo\\src\\main\\java\\com\\addressbook\\writedata.csv";

		//parsing a CSV file into BufferedWriter
		Writer writer = Files.newBufferedWriter(Paths.get(path1));
		
		//creating beanToCsv object to export data to csv file from java application
		StatefulBeanToCsv<AddressBookPojo> beanToCsv = new StatefulBeanToCsvBuilder<AddressBookPojo>(writer)
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
		
		// creating a List which contains String arrays (variables) of AddressBookPojo class
		List<AddressBookPojo> csvUsers = new ArrayList<AddressBookPojo>();
		
		// adding data to csv
		csvUsers.add(new AddressBookPojo("sital", "panda", "xyz", "bbsr", "odisha", "767008", "8564327654",
				"xyz@gmail.com"));
		
		// exporting data to csv file
		beanToCsv.write(csvUsers);
		
		// closing writer connection
		writer.close();
	}

	/**
	 * This is the main method that
	 * creates object csv of AddressBookCSVMain class and
	 * calls read and write method to main and 
	 * prints the output
	 * @param args unused
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AddressBookCSVMain csv = new AddressBookCSVMain();
		csv.readdata();
		csv.WriteData();
	}
}
