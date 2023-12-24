import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_update {

	public static void main(String[] args) {
		String value, ename; int eid; double esal;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","system","data");
			
			Statement smt = conn.createStatement();
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(in);
		
			System.out.print("Enter emp Id: ");
			value = br.readLine();
			eid = Integer.parseInt(value);
			
			System.out.print("Enter emp name: ");
			ename = br.readLine();
			
			System.out.print("Enter emp salary: ");
			value = br.readLine();
			esal = Double.parseDouble(value);
			
			int count = smt.executeUpdate("update emp set sal= " + esal+ " Where eno="+eid);
			if (count>0)
				System.out.println("1 row updataed");
			else 
				System.out.println("no record found");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
