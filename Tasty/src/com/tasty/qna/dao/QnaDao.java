package com.tasty.qna.dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.qna.model.Qna;

public class QnaDao extends CommonDao{

	public void write(Qna qna) {

		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "insert into qna(no, title, question, writer) values(qna_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getQuestion());
			pstmt.setString(3, qna.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Qna> list() {
		List<Qna> list = null;
		try {
			
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select no, title, question, wdate, writer, hit from qna order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Qna>();
			while(rs.next()) {
				list.add(new Qna(rs.getInt("no"), rs.getString("title"), rs.getString("question"), rs.getString("wdate"), rs.getString("writer"), rs.getInt("hit")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Qna view(int no) {
		Qna qna = new Qna();
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select no, title, question, answer, wdate, writer, hit from qna where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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
