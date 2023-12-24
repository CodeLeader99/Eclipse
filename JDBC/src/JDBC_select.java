import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBC_select {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","system","data");
			
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from emp");
			
			while(rs.next())
			{
				int eid = rs.getInt(1);
				String enm = rs.getString(2);
				double esal = rs.getDouble(3);
				
				System.out.println("Emp id: "+ eid);
				System.out.println("Emp name: "+ enm);
				System.out.println("Emp salary: "+ esal);
				System.out.println("----------------");


			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
