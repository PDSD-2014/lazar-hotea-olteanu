package core;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import db.*;
import gameplay.*;

public class Server {
	static ArrayList<CountryInformation> countryInfo;
	
	private static void populateCountryInformation(String url, String user, String password) {
		DBConnection db = new DBConnection(url, user, password);
		countryInfo = (ArrayList<CountryInformation>) db.getCountriesInformation();
	}
	
	private static void printCountryInformation() {
		for(Iterator<CountryInformation> it = countryInfo.iterator(); it.hasNext(); ) {
			System.out.println(it.next().toString());
		}
	}
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");
			 
			// load a properties file
			prop.load(input);
			
			populateCountryInformation(prop.getProperty("dburl"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			QuestionGenerator qGen = QuestionGenerator.getInstance();
			System.out.println(qGen.generateQuestion(countryInfo).toString());
		} catch (Exception e) {
			e.printStackTrace();
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	    } 
		
	}

}
