package com.bigdata2019.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigdata2019.mysite.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;


	public UserVo find(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}

	public UserVo find(Long no) {
		return sqlSession.selectOne("user.findByNo", no);
	}

	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return (count == 1);
	}

//	@SuppressWarnings("finally")
//	public Boolean update(UserVo vo) {
//
//		Boolean result = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = dataSource.getConnection();
//
//			String sql = "update user set name =?, password=?, gender= ? where no =? ";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getPassword());
//			pstmt.setString(3, vo.getGender());
//			pstmt.setLong(4, vo.getNo());
//
//			int count = pstmt.executeUpdate();
//			result = (count == 1);
//
//		} catch (SQLException e) {
//			System.out.println("Error: " + e);
//		} finally {
//			// remove resources
//			try {
//				if (conn != null)
//					conn.close();
//				if (pstmt != null)
//					pstmt.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return result;
//		}
//
//	}

}
