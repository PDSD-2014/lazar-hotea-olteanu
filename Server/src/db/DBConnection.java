package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import gameplay.*;

public class DBConnection {
	private Connection conn;
	
	public DBConnection (String url, String user, String password) {
		conn = openConnection(url, user, password);
		if (conn == null) {
			System.err.println("Couldn't estabilish the connection");
			System.exit(1);
		}
	}
	
	private Connection openConnection(String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<CountryInformation> getCountriesInformation() {
		if (conn == null)
			return null;
		
		List <CountryInformation> list = new ArrayList<CountryInformation>();
		
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * from countries");
		
			while (res.next()) {
				CountryInformation country = new CountryInformation(res.getInt("idCountry"),
																	res.getString("countryName"),
																	res.getString("currencyCode"),
																	res.getString("population"),
																	res.getString("capital"),
																	res.getString("continentName"),
																	res.getString("areaInSqKm"));
				list.add(country);
			}
			
			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return list;
	}
}
