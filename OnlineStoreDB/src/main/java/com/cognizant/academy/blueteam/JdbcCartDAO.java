package com.cognizant.academy.blueteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcCartDAO implements CartDAO {
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

	
public void insert(Cart C) {
	String sql="Insert into CART (CART_ID,BROWSER_ID) values (?,?)";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, C.getCartId());
			ps.setString(2, C.getBrowserInfo());
		}
	});	
}
public void update(Cart C) {
	String sql="UPDATE CART SET CART_ID=?, BROWSER_ID=? WHERE CART_ID=?";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, C.getCartId());
			ps.setString(2, C.getBrowserInfo());
			ps.setInt(3, C.getCartId());
		}
	});	
}
public void delete(Cart C) {
	String sql="DELETE from CART WHERE CART_ID=?";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, C.getCartId());
		}
	});
}
	
	
}
