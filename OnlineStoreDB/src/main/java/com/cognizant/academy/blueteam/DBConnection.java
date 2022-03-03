package com.cognizant.academy.blueteam;
import java.sql.*;
public class DBConnection {
private static final String JDBC_URL="jdbc:derby:C:\\dev\\BLUETEAM\\OnlineStoreDB;create=true";

Connection conn;

public DBConnection() {
	try {
		this.conn=DriverManager.getConnection(JDBC_URL);
		if(this.conn!=null) {
			System.out.println("connection Successful");
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
}


}
