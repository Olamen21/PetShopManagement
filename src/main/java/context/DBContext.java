package context;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
	
	public Connection getConnection()throws Exception {
    String url = "jdbc:sqlserver://LAPTOP-40OFFHMU\\SQLEXPRESS:1433;"
			+ "user=sa;password=123;databaseName=PetShopDb;encrypt=false";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    return DriverManager.getConnection(url);
    
    
}   
	
	
}