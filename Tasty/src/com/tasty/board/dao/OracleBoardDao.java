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

public class OracleBoardDao extends BoardDao {//공통적으로 사용되는 것을 BoardDao를 통해서 상속
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Board> list = null;

	public List<Board> list() {
		try {
			//드라이버연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			//sql문장
			String sql = "select no,title,writer,to_char(wdate,'yyyy-mm-dd') as wdate,hit from board "
					+ " order by no desc";
			//상태실행
			pstmt = conn.prepareStatement(sql);
			//sql문장 실행한 결과를 rs변수에 담는다
			rs = pstmt.executeQuery();
			//sql문장 실행한 결과를 다시 list변수에 담는다
			list = new ArrayList<Board>();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//닫기
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public void write(Board board) {
		try {
			//드라이버연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			//sql문장
			String sql = "insert into board( " + " no,title,content,writer) " + " values(board_seq.nextval,"
					+ " ?,?,?)";
			//상태 실행 및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			//실행
			pstmt.executeUpdate();
			//표시
			Print.printTitle("글쓰기 성공", "=");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//닫기
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
