package com.tasty.member.dao;

import java.sql.DriverManager;
import java.util.ArrayList;

import com.tasty.common.CommonDao;
import com.tasty.member.model.Member;

public class OracleMemberDao extends MemberDao {
	// 리스트 메소드
	public ArrayList<Member> list() {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 리스트 sql문 작석
			String sql = "select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, tel, email, grade from member where not grade=9";
			// 상태 - 데이터세팅
			pstmt = conn.prepareStatement(sql);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터를 담기위한 객체 생성
			ArrayList<Member> list = new ArrayList<Member>();
			// 반복문을 통하여 여러개의 데이터를 저장
			while(rs.next()) {
				list.add(new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("birth"), rs.getString("tel"), rs.getString("email"), rs.getInt("grade")));
			}
			// 데이터가 저장된 리스트를 리턴
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 닫기
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// 회원가입 메소드
	public void write(Member member) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "insert into member(id, pw, name, birth, tel, email) values(?, ?, ?, ?, ?, ?)";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getEmail());
			// 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 닫기
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
