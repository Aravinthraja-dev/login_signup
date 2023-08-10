package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcode {
	private Connection con;
	public DBcode() {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}

	public int newuser(User uobject)//insert
	{
		int n=0;
		try
		{
			String q="insert into users values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, uobject.getName());
			pst.setString(2, uobject.getUsername());
			pst.setString(3, uobject.getEmail());
			pst.setLong(4, uobject.getMobile());
			pst.setString(5, uobject.getPassword());
			n = pst.executeUpdate();			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int deactivate(String username,String password) //account delete
	{
		int n=0;
		try
		{
			String q="delete from users where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, username);
			pst.setString(2, password);	
			n = pst.executeUpdate();			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return n;
	}
	public int changepassword(String oldp, String newp, String username)//update
	{
		int n=0;
		try
		{
			String q="update users set password=? where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, newp);
			pst.setString(2, username);
			pst.setString(3, oldp);			
			n = pst.executeUpdate();			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	public int login(String username,String password)
	{
		try
		{
			String q="select * from users where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, username);
			pst.setString(2, password);			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public User getcurrentuserdata(String username)
	{
		User u = new User();
		try
		{
			String q="select * from users where username=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, username);	
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				u.setName(rs.getString("name"));
				u.setUsername(rs.getString("username"));
				u.setMobile(rs.getLong("mobile"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
