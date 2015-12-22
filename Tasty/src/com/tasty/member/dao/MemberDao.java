package com.tasty.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tasty.common.CommonDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;

public abstract class MemberDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 오라클Dao를 위한 추상메소드 정의
	public abstract ArrayList<Member> list();
	public abstract void write(Member member);
	// 로그인 메소드
	public Login login(String loginId, String loginPw) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 아이디와 패스워드에 정확하게 해당하는 회원의 정보를 불러오는 sql문 작성
			String sql = "select * from member where id=? and pw=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			// 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Login(rs.getString("id"), rs.getString("name"), rs.getInt("grade"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//닫기
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
	// 아이디 찾기 메소드
	public String findId(String email) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 이메일을 넣었을 때 해당하는 아이디를 불러오는 sql문 작성
			String sql = "select id from member where email=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터가 존재하면 아이디 리턴
			if(rs.next())
				return rs.getString("id");
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
	// 비밀번호 찾기 메소드
	public String findPw(String userId, String email) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 아이디와 이메일을 넣었을 때 해당하는 비밀번호를 불러오는 sql문 작성
			String sql = "select pw from member where id=? and email=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터가 존재하면 비밀번호 리턴
			if(rs.next())
				return rs.getString("pw");
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
	// 회원정보보기 메소드
	public Member view(String userId) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 필요한 회원의 정보를 불러오는 sql문 작성
			String sql = "select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, tel, email, grade from member where id=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터가 존재하면 회원의 정보를 리턴
			if(rs.next())
				return new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("birth"), rs.getString("tel"), rs.getString("email"), rs.getInt("grade"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				// 닫기
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
	// 회원 정보를 수정하는 메소드
	public void update(Member member) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 회원의 정보를 바꾸는 sql문 작성
			String sql = "update member set name=?, birth=?, tel=?, email=? where id=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			// 실행
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 닫기
			try {
				if(conn != null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 회원의 비밀번호는 수정하는 메소드
	public void updatePw(String userId, String userPw) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// 회원의 비밀번호를 바꾸는 sql문 작성
			String sql = "update member set pw=? where id=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
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
	// 회원탈퇴를 하기전에 입력한 비밀번호가 일치하는지 확인하기 위한 sql문 작성
	public String deleteCheck(String userId) {
		try {
			// DB접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "select pw from member where id=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터가 존재하면 비밀번호 리턴
			if(rs.next()) {
				return rs.getString("pw");
			}
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
	// 회원탈퇴 메소드
	public int delete(String userId) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "delete from member where id=?";
			// 상태 - 데이터세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// 실행
			return pstmt.executeUpdate();
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
		return 0;
	}
	// 비밀번호 변경 하기전에 입력한 비밀번호가 일치하는지 확인하는 메소드
	public String updatePwCheck(String userId) {
		try {
			// DB 접속
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문 작성
			String sql = "select pw from member where id=?";
			// 상태 - 데이터 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// 실행
			rs = pstmt.executeQuery();
			// 데이터가 존재하면 비밀번호 리턴
			if(rs.next()) {
				return rs.getString("pw");
			}
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
}
