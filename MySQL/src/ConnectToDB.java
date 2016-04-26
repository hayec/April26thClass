import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ConnectToDB {

	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			String username = "root";
			String password = "student";
			String url = "jbdc:mysql.jdbc://localhost/test";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connection Successful");
			
			//Create Table
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("drop table if exists books");
			stmt.executeUpdate("create table books (isbn char(10), title char(50), author char(50), publisher char(50))");
			stmt.executeUpdate("insert into books(isbn, title, author, publisher) values('007130630', 'Java', 'John Doe', 'Pearson')('007130930', 'C#', 'Jane Doe', 'Cengage')");
			
		}
		catch(Exception e)
		{
			System.out.println("Cannot connect to database");
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
					System.out.println("Database connection closed");
				}
				catch(Exception e)
				{
					System.out.println("Database connection cannot close");
				}
			}
		}

	}

}
