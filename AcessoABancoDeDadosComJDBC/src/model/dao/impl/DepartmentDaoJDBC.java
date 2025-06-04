package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.DbException;
import model.Department;
import model.dao.DepartmentDao;
import services.DB;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(nome) "
					+ "VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			int rows = st.executeUpdate();
			
			if(rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				DB.closeResultSet(rs);
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+ "SET nome = ? "
					+ "WHERE id = ?"
					);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE FROM department WHERE id = ?"
					);
			st.setInt(1, id);
			
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department WHERE id = ?"
					);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				DB.closeResultSet(rs);
				return dep;
			}
			
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		Statement st = null;
		try {
			st = conn.createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT * FROM department");
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				list.add(dep);
			}
			DB.closeResultSet(rs);
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}
	
}
