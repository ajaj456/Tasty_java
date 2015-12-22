package com.tasty.qna.dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.qna.model.Qna;

public class OracleQnaDao extends QnaDao {

	public void write(Qna qna) {	// 질문하기 처리
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "insert into qna(no, title, question, writer) values(qna_seq.nextval, ?, ?, ?)";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getQuestion());
			pstmt.setString(3, qna.getWriter());
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("질문하기 성공");
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

	public List<Qna> list() {	// 글리스트 처리
		// 필요한 객체 선언
		List<Qna> list = null;
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "select no, title, question, answer, to_char(wdate, 'yyyy-mm-dd') wdate, writer, hit from qna order by no desc";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			// 실행
			rs = pstmt.executeQuery();
			list = new ArrayList<Qna>();
			while(rs.next()) {
				list.add(new Qna(rs.getInt("no"), rs.getString("title"), rs.getString("question"), rs.getString("answer"), rs.getString("wdate"), rs.getString("writer"), rs.getInt("hit")));
			}
			return list;
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
}
