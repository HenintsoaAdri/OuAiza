package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilDB {
	public static Connection conn;

	public static Connection getConnPostgre()throws Exception{
		try{
			Class.forName("org.postgresql.Driver");
                  	conn = (Connection) DriverManager.getConnection("jdbc:postgres://dxvwhjqpfuojqr:46a48570f16439720a4e1b1b69c55a0b18be02732d2b2ef2e98ab2eab0b99222@ec2-184-73-222-194.compute-1.amazonaws.com:5432/ddqlblafilkm8s","dxvwhjqpfuojqr", "46a48570f16439720a4e1b1b69c55a0b18be02732d2b2ef2e98ab2eab0b99222");
//			conn = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/OuAiza","postgres","adri");
			conn.setAutoCommit(false);
			if(conn == null){
				throw new Exception("Aucune connexion \u00e9tablie avec la base");
			}
		}
		catch(Exception e){
			throw e;
		}
		return conn;
	}
}
