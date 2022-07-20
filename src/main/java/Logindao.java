import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Logindao {
	private String dburl="jdbc:mysql://localhost:3308/demo?useSSL=false";
	private String dbuname="root";
	private String dbpassword="";
	private String dbdriver="com.mysql.jdbc.Driver";
	String sql = "SELECT * FROM demo.registrationdb where Email=? and Password=?";
	public void loadDriver(String dbdriver)
	{
		try {
			getClass();
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dburl,dbuname,dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public boolean check(String Email, String Password)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Email);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	
	}

}
