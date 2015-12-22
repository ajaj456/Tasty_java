package com.tasty.qna.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.qna.model.Qna;

public abstract class QnaDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public abstract void write(Qna qna);
	public abstract List<Qna> list();

	public Qna view(int no) {	// 질문보기 처리
		// 필요한 객체 선언
		Qna qna = new Qna();
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "select no, title, question, answer, wdate, writer, hit from qna where no = ?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qna.setNo(rs.getInt("no"));
				qna.setTitle(rs.getString("title"));
				qna.setQuestion(rs.getString("question"));
				qna.setAnswer(rs.getString("answer"));
				qna.setWdate(rs.getString("wdate"));
				qna.setWriter(rs.getString("writer"));
				qna.setHit(rs.getInt("hit"));
				return qna;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 닫기
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void update(Qna qna) {	// 질문수정 처리
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "update qna set title = ?, question = ?, writer = ? where no = ?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getQuestion());
			pstmt.setString(3, qna.getWriter());
			pstmt.setInt(4, qna.getNo());
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("질문수정 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 닫기
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void reply(Qna qna) {	// 답변하기|수정 처리
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "update qna set answer = ?, where no = ?)";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getAnswer());
			pstmt.setInt(2, qna.getNo());
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("답변하기|수정 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 닫기
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int no) {	// 질문삭제 처리
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "delete from qna where no = ?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("질문삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 닫기
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void increase(int no) {	// 조회수 증가 처리
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "update qna set hit = hit + 1 where no = ?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("조회수 증가 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 닫기
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
