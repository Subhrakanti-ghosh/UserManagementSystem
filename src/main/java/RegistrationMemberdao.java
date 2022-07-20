import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;







public class RegistrationMemberdao {
	private String dburl="jdbc:mysql://localhost:3308/demo?useSSL=false";
	private String dbuname="root";
	private String dbpassword="";
	private String dbdriver="com.mysql.jdbc.Driver";
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
	
	public String insert(Member member)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result = "data inserted successfully";
		String sql = "insert into demo.registrationdb Values(?,?,?,?)";
		System.out.println(member);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getYname());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getRpassword());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "data not entered";
		}
		
		return result;
		
	}
	public void getMembers()
	{
	
		try
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from demo.registrationdb");
				
				while(rs.next()) {
					Member m = new Member();
					m.setYname(rs.getString("Name"));
					m.setEmail(rs.getString("Email"));
					m.setPassword(rs.getString("Password"));
					m.setPassword(rs.getString("RePassword"));
				
				
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 
	}
	

