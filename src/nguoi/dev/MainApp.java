package nguoi.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nguoi.dev.CategoryImpl;

public class MainApp {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		//insert(conn);
		//update(conn);
		delete(conn);
		select(conn);
//		/**
//		 * Category
//		 */
//		CategoryImpl.insert(con);
//		CategoryImpl.update(con);
//		CategoryImpl.delete(con);
//		CategoryImpl.readOne(con);
//		CategoryImpl.readAll(con);
//		
//		/**
//		 * User
//		 */
	}

	private static void select(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "SELECT *FROM CATEGORIES";
		try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String thumbnail = rs.getString("thumbnail");
			System.out.format("id:%d - name:%s - thumbnail:%s", id,name,thumbnail).println();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static void delete(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID=?";
		try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,120);
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	private static void update(Connection conn) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET (NAME=? THUMBNAIL) VALUES (?,?)";
		try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,"Ao Nu");
		stmt.setString(2,"https://image.com/2.jpg");
		stmt.setInt(3,120);
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	private static void insert(Connection conn) {
		String sql = "INSERT INTO CATEGORIES(NAME, THUMBNAIL) VALUES (?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,"Ao Nam");
			stmt.setString(2,"https://image.com/1.jpg");
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	private static Connection getConnection() {
		// TODO Auto-generated method stub
		 final String DB_URL="jdbc:mysql://localhost:3306/shop";
		 final String DB_USER  = "root";
		 final String DB_PASS  = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}