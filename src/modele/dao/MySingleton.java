package modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * this class to insure one only connection to the database if it so connect to it
 */
public class MySingleton {

	private static MySingleton instance = new MySingleton();
	private Connection  conn;
	
	private MySingleton() {
		String serveurBD = "jdbc:mysql://127.0.0.1:3306/dc_qcm?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT";
		String login = "root";
		String motPasse = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(serveurBD, login, motPasse);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static  MySingleton getInstance() {
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}

	public Connection getConn() {
		return conn;
	}
	
	
}
