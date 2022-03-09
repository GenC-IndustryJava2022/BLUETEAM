package com.cognizant.academy.blueteam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.academy.blueteam.models.Category;
import com.cognizant.academy.blueteam.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public String toString() {
		return "CategoryService [categoryRepository=" + categoryRepository
				+ "]";
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category add(Category category) {
		return categoryRepository.save(category);
	}

//	@Override
//	public void insert(Category C) {
//		// TODO Auto-generated method stub
//		String sql = "Insert into CATEGORY (CATEGORY_ID,NAME,HEADER_IMAGE) values (?,?,?)";
//		jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, C.getCategoryId());
//				ps.setString(2, C.getName());
//				ps.setString(3, C.getHeaderImage());
//			}
//		});
//	}
//
////UPDATE Customers
//	// SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//	// WHERE CustomerID = 1;
//	@Override
//	public void update(Category C) {
//		String sql = "UPDATE CATEGORY SET CATEGORY_ID=?, NAME=?, HEADER_IMAGE=? WHERE CATEGORY_ID=?";
//		jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, C.getCategoryId());
//				ps.setString(2, C.getName());
//				ps.setString(3, C.getHeaderImage());
//				ps.setInt(4, C.getCategoryId());
//			}
//		});
//
//	}
//
//	@Override
//	public void delete(Category C) {
//		// TODO Auto-generated method stub
//		String sql = "DELETE from CATEGORY WHERE CATEGORY_ID=?";
//		jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, C.getCategoryId());
//			}
//		});
//	}
//
//	public List<Category> findAll() {
//		try {
//			ArrayList<Category> list = new ArrayList<>();
//			Statement stmt = jdbcTemplate.getDataSource().getConnection()
//					.createStatement();
//			String select = "SELECT * FROM CATEGORY";
//			ResultSet rs = stmt.executeQuery(select);
//			while (rs.next()) {
//				int ID = rs.getInt("CATEGORY_ID");
//				String name = rs.getString("NAME");
//				String Himage = rs.getString("HEADER_IMAGE");
//				list.add(new Category(ID, name, Himage));
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
