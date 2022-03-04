package com.devdensify;
import java.sql.*;

public class DAO {
	public static Connection createConnection() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mysql://localhost:3306/person";
			String userName = "root";
			String password = "1598635784";
			con = DriverManager.getConnection(url, userName, password);
			
			System.out.println("Connection established");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to create a connection");
		}		
		return con;
	}
	
	public static boolean signUp(Person user) {
		try {
			Connection con = createConnection();
			
			String query = "INSERT INTO user(email, password) VALUE(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		
			System.out.println("Succesfully registered!");			
			con.close();
			System.out.println("Connection destroyed!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to register!");
			return false;
		}
		return true;	
	}
}
