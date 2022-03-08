package com.cognizant.academy.blueteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcCategoryDAO implements CategoryDAO {
	private static final String JDBC_URL="jdbc:derby:C:\\Users\\955514\\OnlineStore\\Store;create=true";
	private Connection conn;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
public Connection getConn() {
	return conn;
}

public void setConn(Connection conn) {
	this.conn = conn;
}

public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}

public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

public static String getJdbcUrl() {
	return JDBC_URL;
}

	@Override
	public void insert(Category C) {
		// TODO Auto-generated method stub
		String sql="Insert into CATEGORY (CATEGORY_ID,NAME,HEADER_IMAGE) values (?,?,?)";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, C.getCategoryId());
				ps.setString(2, C.getName());
				ps.setString(3, C.getHeaderImage());
			}
		});
	}
//UPDATE Customers
	//SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
		//	WHERE CustomerID = 1;
	@Override
	public void update(Category C) {
		String sql="UPDATE CATEGORY SET CATEGORY_ID=?, NAME=?, HEADER_IMAGE=? WHERE CATEGORY_ID=?";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, C.getCategoryId());
				ps.setString(2, C.getName());
				ps.setString(3, C.getHeaderImage());
				ps.setInt(4, C.getCategoryId());
			}
		});	
		
	}

	@Override
	public void delete(Category C) {
		// TODO Auto-generated method stub
		String sql="DELETE from CATEGORY WHERE CATEGORY_ID=?";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, C.getCategoryId());
			}
		});
	}

	public List<Category> findAll(){
		try {
			ArrayList<Category> list=new ArrayList<>();
			Statement stmt=jdbcTemplate.getDataSource().getConnection().createStatement();
			String select="SELECT * FROM CATEGORY";
			ResultSet rs= stmt.executeQuery(select);
			while(rs.next()) {
				int ID= rs.getInt("CATEGORY_ID");
				String name=rs.getString("NAME");
				String Himage=rs.getString("HEADER_IMAGE");
				list.add(new Category(ID,name,Himage));
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
