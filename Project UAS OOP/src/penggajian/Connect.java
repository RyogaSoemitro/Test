package penggajian;

import java.sql.*;

public class Connect {
	String url, user, pass, db;

	Connect() {
		db = "penggajian";
		url = "jdbc:mysql://localhost:3306/" + db;
		user = "root";
		pass = "";
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected !!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found \n" + e + "\n");
		} catch (SQLException e) {
			System.out.println("databases can't found");
			System.out.println(e);
		}
		return con;
	}

	public static void main(String[] args) {
		Connect c = new Connect();
		c.getConnection();
	}
}