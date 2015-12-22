package com.tasty.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tasty.board.model.Board;
import com.tasty.common.CommonDao;
import com.tasty.util.Print;

public class OracleBoardDao extends BoardDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Board> list = null;

	public List<Board> list() {
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = "select no,title,writer,to_char(wdate,'yyyy-mm-dd') as wdate,hit from board "
					+ " order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Board>();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public void write(Board board) {
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);

			String sql = "insert into board( " + " no,title,content,writer) " + " values(board_seq.nextval,"
					+ " ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.executeUpdate();
			Print.printTitle("글쓰기 성공", "=");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
