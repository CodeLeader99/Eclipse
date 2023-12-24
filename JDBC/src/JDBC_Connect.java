import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Connect {
	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","system","data"); 
			
			Statement smt = conn.createStatement();
			
			smt.executeUpdate("create table emp(eno number(2), ename varchar2(20), sal number(10))");
			System.out.println("Table create successfully!!");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
