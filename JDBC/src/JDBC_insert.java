import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_insert {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","system","data");
			//PreparedStatement psmt = conn.prepareStatement("insert into emp values(21,'ankit',2300)");
			//psmt.execute();
			PreparedStatement psmt = conn.prepareStatement("insert into emp values(?,?,?)");
			InputStreamReader in = new InputStreamReader(System.in);
			
			/*creating InputStreamReader object also you can do like this
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
				in which you can create both BufferedReader & InputStreamReader at one line */
			
			BufferedReader br = new BufferedReader(in);
			
			
			while(true)
			{
				System.out.print("Enter Emp no: ");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Enter Emp name: ");
				String enm = br.readLine();
				
				System.out.print("Enter Emp salary: ");
				double enpsal = Integer.parseInt(br.readLine());
				
				psmt.setInt(1, eno);
				psmt.setString(2, enm);
				psmt.setDouble(3,enpsal);
				
				int count = psmt.executeUpdate();
				if(count>0)
					System.out.println("Record inserted");
				else
					System.out.println("Record not inserted");
				
				System.out.println("Do you want to insert more record[yes/no]");
				
				String ch = br.readLine();
				if (ch.equalsIgnoreCase("no"))
				break;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
