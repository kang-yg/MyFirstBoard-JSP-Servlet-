package com.mydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mydto.*;

public class FirstBoardDAO {
	DataSource dataSource;

	public FirstBoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/MyMariaDB");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<FirstBoardDTO> selectAll() {
		ArrayList<FirstBoardDTO> result = new ArrayList<FirstBoardDTO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM board";
			resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String date = resultSet.getString("date");
				String writer = resultSet.getString("writer");

				result.add(new FirstBoardDTO(no, title, content, date, writer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT COUNT(*) FROM board";
			
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public void insertWrite(FirstBoardDTO boardDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board (title, content, date, writer) VALUES (?, ?, ?, ?)";
		int result = 0;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setString(3, boardDTO.getDate());
			pstmt.setString(4, boardDTO.getWriter());
			
			result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println("INSERT COMPLETE");
			} else {
				System.out.println("INSERT FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
