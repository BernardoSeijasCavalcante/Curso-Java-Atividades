package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import services.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
			
			st.setInt(1, 5);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		//----------------ATUALIZAR DADOS------------------
		/*Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET baseSalary = baseSalary + ?"
					+ "WHERE "
					+ "departmentId = ?"
					);
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}*/
		//----------------ATUALIZAR DADOS------------------
		//--------------------INSERIR DADOS-----------------------
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller" 
					+"(name,email,birthDate,baseSalary,departmentId)"
					+ "VALUES"
					+ "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);//Opcional
					
			st.setString(1, "Carl Purple");
			st.setString(2, "purple@gmail.com");
			st.setDate(3,new java.sql.Date(sdf.parse("03/06/2025").getTime()));
			st.setDouble(4, 2500.00);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Done! Rows affected: " + rowsAffected);
				
				ResultSet rs = st.getGeneratedKeys();
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));	
				}	
			}else {
				System.out.println("Falhou. Nenhuma linha alterada!");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ParseException e){
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.getConnection();
		}*/
		//--------------------INSERIR DADOS-----------------------
		//----------------Recuperar Dados----------------
		/*Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			
			st= conn.createStatement();
			
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("nome"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}*/
		//----------------Recuperar Dados----------------
	}

}
