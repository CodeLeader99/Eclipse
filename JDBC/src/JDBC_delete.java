import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_delete {
	public static void main(String[] args)
	{
		String value, ename; int eid; double esal;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","system","data");
			
			Statement smt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Emp id: ");
			value = br.readLine();
			eid = Integer.parseInt(value);
			
			System.out.print("Etner Emp name: ");
			ename = br.readLine();
			
			System.out.print("Enter emp sal: ");
			value = br.readLine();
			esal = Double.parseDouble(value);
			
			int count = smt.executeUpdate("delete from emp where eno ="+eid);
			if (count>0)
				System.out.print("1 row deleted");
			else
				System.out.print("no row found");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
