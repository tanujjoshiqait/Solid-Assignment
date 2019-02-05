package DBConnect;
import java.sql.*;
public class DBConnection 
{
    private Connection connection;
	public Connection getConnection()
		{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Shipment","root","shivamagarwal");  
			}catch(Exception e){ System.out.println(e);} 
		return this.connection;
	   }

	public void closeConnection(){	
		try {
			this.connection.close();
		} catch (SQLException e) {
		System.out.println(e);
		}
	}
	public void retrieveCategory() {
		Connection con = getConnection();
		int i = 1;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select DISTINCT Pcategory from product");
			while(rs.next()) {
				System.out.println(i + " " + rs.getString(1));
				i++;}
		} catch (SQLException e) {
			System.out.println(e);
	    }  		
	}
	public void retrieveFruit(String type) {
		Connection con = getConnection();
		int i = 1;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select Pname, Pprice,Pquantity from product where Pcategory='"+type+"'");
			while(rs.next()) {
				if(rs.getInt(3)>0)
				   System.out.println(i + " " + rs.getString(1) + " " + rs.getInt(2));
				i++;}
		} catch (SQLException e) {
			System.out.println(e);
		}  
	}
	public int retrieveQuantity(String f1) {
		Connection con = getConnection();
		int a;
		try {
			Statement stmt = con.createStatement();
			String query = "select Pquantity from product where Pname='"+f1+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {    
				a = rs.getInt(1);
				return a;
			}
		} catch (SQLException e) {
		System.out.println(e);
		}  
		  return 0;
   }
	public int updatedb(int q, String f) {
		Connection con = getConnection();
		int a;
		try {
			Statement stmt = con.createStatement();
			String query = "Update product set Pquantity = "+q+" where Pname='"+f+"'";
			stmt.executeUpdate(query);
			String query2 = "select Pprice from product where Pname='"+f+"'";
			ResultSet rs = stmt.executeQuery(query2);
			while(rs.next()) {    
				a = rs.getInt(1);
				return a;
				}
			} catch (SQLException e) {
			System.out.println(e);
			}  
			return 0;			
		}
	public void billingUpdate(String u, int s) {
		Connection con = getConnection();	
		try {
			Statement stmt = con.createStatement();
			String query = "insert into billing values (?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, u);
			preparedStatement.setInt(2, s);
			preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
		System.out.println(e);
	}  
	}
}		
