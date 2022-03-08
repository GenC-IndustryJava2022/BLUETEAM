package com.cognizant.academy.blueteam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.cognizant.academy.blueteam.models.Category;
import com.cognizant.academy.blueteam.repository.CategoryRepository;

public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public void insert(Category C) {
		// TODO Auto-generated method stub
		String sql = "Insert into CATEGORY (CATEGORY_ID,NAME,HEADER_IMAGE) values (?,?,?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, C.getCategoryId());
				ps.setString(2, C.getName());
				ps.setString(3, C.getHeaderImage());
			}
		});
	}

//UPDATE Customers
	// SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
	// WHERE CustomerID = 1;
	@Override
	public void update(Category C) {
		String sql = "UPDATE CATEGORY SET CATEGORY_ID=?, NAME=?, HEADER_IMAGE=? WHERE CATEGORY_ID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
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
		String sql = "DELETE from CATEGORY WHERE CATEGORY_ID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, C.getCategoryId());
			}
		});
	}

	public List<Category> findAll() {
		try {
			ArrayList<Category> list = new ArrayList<>();
			Statement stmt = jdbcTemplate.getDataSource().getConnection()
					.createStatement();
			String select = "SELECT * FROM CATEGORY";
			ResultSet rs = stmt.executeQuery(select);
			while (rs.next()) {
				int ID = rs.getInt("CATEGORY_ID");
				String name = rs.getString("NAME");
				String Himage = rs.getString("HEADER_IMAGE");
				list.add(new Category(ID, name, Himage));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
