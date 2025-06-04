package application;

import java.util.Date;
import java.util.List;

import model.Department;
import model.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("SellerDao");
		System.out.println("Inserindo Dados");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Department dep = new Department(1,"Computers");
		
		Seller sel = new Seller("Bob Brown", "bob@gmail.com", new java.sql.Date(new Date().getTime()),4000.0,dep);
		sellerDao.insert(sel);
		System.out.println("Vendedor inserido com sucesso!");
		
		System.out.println("Atualizando Dados");
		sel.setName("Alice Angel");
		sellerDao.update(sel);
		System.out.println("Dados atualizados com sucesso!");
		
		System.out.println("Resgatando Dados");
		System.out.println(sellerDao.findById(sel.getId()));
		System.out.println("Dados resgatados com sucesso!");
		
		System.out.println("Deletando Dados");
		sellerDao.deleteById(sel.getId());
		System.out.println("Dados deletados com sucesso!");
		
		System.out.println("Resgatando Tudo");
		List<Seller> list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		System.out.println("Dados resgatados com sucesso!");
		
		System.out.println("Resgatando por Departamento");
		List<Seller> list2 = sellerDao.findByDepartment(dep);
		for(Seller s : list2) {
			System.out.println(s);
		}
		System.out.println("Dados resgatados com sucesso!");
		
		//----------------------------------------------------------------
		
		System.out.println("DepartmentDao");
		System.out.println("Inserindo Dados");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department depP = new Department(1,"Food");
		
		departmentDao.insert(depP);
		System.out.println("Departamento inserido com sucesso!");
		
		System.out.println("Atualizando Dados");
		depP.setName("Tables");
		departmentDao.update(depP);
		System.out.println("Dados atualizados com sucesso!");
		
		System.out.println("Resgatando Dados");
		System.out.println(departmentDao.findById(depP.getId()));
		System.out.println("Dados resgatados com sucesso!");
		
		System.out.println("Deletando Dados");
		departmentDao.deleteById(depP.getId());
		System.out.println("Dados deletados com sucesso!");
		
		System.out.println("Resgatando Tudo");
		List<Department> listD = departmentDao.findAll();
		for(Department s : listD) {
			System.out.println(s);
		}
		System.out.println("Dados resgatados com sucesso!");
		
		//-------------TRANSAÇÕES-------------
		/*Connection conn = null;
		Statement st = null;
	
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET baseSalary = 2090.0 WHERE departmentId = 1");
			
			int x = 1;
			
			if(x < 2) {
				throw new SQLException("Fake Error");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET baseSalary = 2090.0 WHERE departmentId = 1");
			
			conn.commit();
			
			System.out.println(rows1);
			System.out.println(rows2);
		}catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
				
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage()); 
				
			}
		}*/
		//-------------TRANSAÇÕES-------------
		//-----------------DELETAR DADOS-------------------
		/*Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
			
			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}*/
		//-----------------DELETAR DADOS-------------------
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
