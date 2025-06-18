package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import exception.DbException;

public class DB {

	//-------------Conexão com o Banco - Primeiro Passo--------------
	
	private static Connection conn = null;

	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("url");
			conn = DriverManager.getConnection(url, props); //Estabelece a conexão com o banco de dados
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();//Fecha a conexão
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs); // método do load que faz a leitura do arquivo fs e salva as propriedades dentro
			return props;				// do objeto props
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	 
	//-------------Conexão com o Banco - Primeiro Passo--------------
	//-------------Fechando atributos de Consulta--------------------
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	//-------------Fechando atributos de Consulta--------------------
}
