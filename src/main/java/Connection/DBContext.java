package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

	
	
	public Connection getConnection() throws Exception{
		String url="jdbc:sqlserver://localhost:1433;"
	            + "databaseName=XoSoDB;"
	            + "encrypt=false;TrustServerCertificate=True";

			
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	
	private final String userID="sa";
	private final String password="123456";

}
