package com.tasty.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tasty.board.model.Board;
import com.tasty.common.CommonDao;

public abstract class BoardDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<Board> list = null;

	public abstract List<Board> list();
	public abstract void write(Board board);
	
	public Board view(int no) {
		Board board = new Board();
		try {
			//드라이버연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			//sql문장
			String sql = "select no,title,content,writer,to_char(wdate,'yyyy-mm-dd') as wdate,hit from board "
					+ " where no = ?";
			//상태실행
			pstmt = conn.prepareStatement(sql);
			//상태 실행 및 데이터입력
			pstmt.setInt(1, no);
			//sql문장 실행한 결과를 rs변수에 담는다
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWdate(rs.getString("wdate"));
				board.setHit(rs.getInt("hit"));
			}
			return board;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//닫기
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}

	public void update(Board board) {
		try {
			//드라이버연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			//sql문장
			String sql = " update board set title = ?, content = ?, writer = ? where no = ? ";
			//상태 실행 및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setInt(4, board.getNo());
			//실행
			pstmt.executeUpdate();
			//표시
			System.out.println("수정이 되었습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//닫기
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	} // end of update()

	public void delete(int no) {
		try {
			//드라이버연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			//sql문장
			String sql = "delete from board where no =?";
			//상태 실행 및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			//실행
			pstmt.executeUpdate();
			//표시
			System.out.println("삭제 성공");
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
