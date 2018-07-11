package br.com.MobilityApp.MobilityApp.CONEXAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
	
	private static final String serverName = "";
	private static final String myDatabBase = "";
	private static final String url = "jdbc:mysql://" + serverName + "/" + myDatabBase;
	private static final String user = "";
	private static final String password = "";
	private static final String className = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			Class.forName(className);
			return DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			System.out.println("N�o foi possivel se conectar no banco de dados...");
			e.printStackTrace();
			return null;
		}
	}

}
