package com.bigdata2019.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bigdata2019.mysite.vo.UserVo;

@Repository
public class UserRepository {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=utf8";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");

		return conn;
	}

	public UserVo find(String email, String password) {
		UserVo result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, name from user where email=? and password=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new UserVo();
				result.setNo(rs.getLong(1));
				result.setName(rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver: " + e);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public UserVo find(Long no) {
		UserVo result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, name, email, gender from user where no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);


			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new UserVo();
				result.setNo(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setGender(rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver: " + e);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@SuppressWarnings("finally")
	public Boolean insert(UserVo vo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into user values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// Execute SQL Statment
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver: " + e);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} finally {
			// remove resources
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	}
	
	
	@SuppressWarnings("finally")
	public Boolean update(UserVo vo) {
		
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			conn = getConnection();

			String sql = "update user set name =?, password=?, gender= ? where no =? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setLong(4, vo.getNo());

			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver: " + e);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} finally {
			// remove resources
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
	}

}
