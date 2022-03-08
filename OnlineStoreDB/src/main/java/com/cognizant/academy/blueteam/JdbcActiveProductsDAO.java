package com.cognizant.academy.blueteam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcActiveProductsDAO {

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

public void insert(ActiveProducts A) {
	String sql="Insert into ACTIVE_PRODUCTS (ACTIVE_PRODUCTS_ID,CART_ID,PRODUCT_ID,QUANTITY) values (?,?,?,?)";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, A.getActiveProductsId());
			ps.setInt(2, A.getCartId());
			ps.setInt(3, A.getProductId());
			ps.setInt(4, A.getQuantity());
		}
	});	
}
public void update(ActiveProducts A) {
	String sql="UPDATE ACTIVE_PRODUCTS SET ACTIVE_PRODUCTS_ID=?, CART_ID=?,PRODUCT_ID=?, QUANTITY=? WHERE ACTIVE_PRODUCTS_ID=?";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, A.getActiveProductsId());
			ps.setInt(2, A.getCartId());
			ps.setInt(3, A.getProductId());
			ps.setInt(4, A.getQuantity());
			ps.setInt(5, A.getActiveProductsId());
		}
	});	
}
public void delete(ActiveProducts A) {
	String sql="DELETE from ACTIVE_PRODUCTS WHERE ACTIVE_PRODUCTS_ID=?";
	jdbcTemplate.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, A.getActiveProductsId());
		}
	});
}
public List<ActiveProducts> findAll(){
	try {
		ArrayList<ActiveProducts> list=new ArrayList<>();
		Statement stmt=jdbcTemplate.getDataSource().getConnection().createStatement();
		String select="SELECT * FROM ACTIVE_PRODUCTS";
		ResultSet rs= stmt.executeQuery(select);
		while(rs.next()) {
			int ID= rs.getInt("ACTIVE_PRODUCTS_ID");
			int CID=rs.getInt("CART_ID");
			int PID=rs.getInt("PRODUCT_ID");
			int quantity=rs.getInt("QUANTITY");
		
			list.add(new ActiveProducts(ID,CID,PID,quantity));
		}
		return list;
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}
}
