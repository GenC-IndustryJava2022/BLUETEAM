package com.cognizant.academy.blueteam.repository;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.cognizant.academy.blueteam.models.Product;

public class JdbcProductDAO implements ProductDAO {
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
	public void insert(Product P) {
		// TODO Auto-generated method stub
		String sql="Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, P.getProductId());
				ps.setString(2, P.getName());
				ps.setDouble(3, P.getPrice());
				ps.setString(4, P.getImage());
				ps.setString(5, P.getDescription());
				ps.setInt(6, P.getCategoryId());
			}
		});
	}

	@Override
	public void update(Product P) {
		// TODO Auto-generated method stub
		String sql="Update PRODUCT SET PRODUCT_ID=?,NAME=?,PRICE=?,IMAGE=?,DESCRIPTION=?, CATEGORY_ID=? WHERE PRODUCT_ID=?";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				
				ps.setInt(1, P.getProductId());
				ps.setString(2, P.getName());
				ps.setDouble(3, P.getPrice());
				ps.setString(4, P.getImage());
				ps.setString(5, P.getDescription());
				ps.setInt(6, P.getCategoryId());
				ps.setInt(7, P.getProductId());
			}
		});	
	}

	@Override
	public void delete(Product P) {
		// TODO Auto-generated method stub
		String sql="DELETE from PRODUCT WHERE PRODUCT_ID=?";
		jdbcTemplate.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, P.getProductId());
			}
		});
	}
	
	public List<Product> findAll(){
		try {
			ArrayList<Product> list=new ArrayList<>();
			Statement stmt=jdbcTemplate.getDataSource().getConnection().createStatement();
			String select="SELECT * FROM PRODUCT";
			ResultSet rs= stmt.executeQuery(select);
			while(rs.next()) {
				int ID= rs.getInt("PRODUCT_ID");
				String name=rs.getString("NAME");
				double price=rs.getDouble("PRICE");
				String image=rs.getString("IMAGE");
				String desc=rs.getString("DESCRIPTION");
				int catID=rs.getInt("CATEGORY_ID");
				list.add(new Product(ID,name,price,image,desc,catID));
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Product find(int Id) {
		try {
			ArrayList<Product> list=new ArrayList<>();
			Statement stmt=jdbcTemplate.getDataSource().getConnection().createStatement();
			String select="SELECT * FROM PRODUCT";
			ResultSet rs= stmt.executeQuery(select);
			while(rs.next()) {
				int ID= rs.getInt("PRODUCT_ID");
				String name=rs.getString("NAME");
				double price=rs.getDouble("PRICE");
				String image=rs.getString("IMAGE");
				String desc=rs.getString("DESCRIPTION");
				int catID=rs.getInt("CATEGORY_ID");
				list.add(new Product(ID,name,price,image,desc,catID));
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
