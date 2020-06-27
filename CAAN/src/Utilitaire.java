
import java.sql.*;

import javax.swing.JOptionPane;


  
public class Utilitaire {
	private static Connection conn;
	static {
				
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=figi2020;databaseName=Bib-CAAN");
			//System.out.println("connected to server successfully");
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "can\'t connect to database");
			
		}
		}
	public static Connection getConnection() {
		return conn;
	}
}
