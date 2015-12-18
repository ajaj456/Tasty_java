package com.tasty.member.dao;

import java.sql.DriverManager;
import java.util.ArrayList;

import com.tasty.common.CommonDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;

public class MemberDao extends CommonDao {
	public Login login(String loginId, String loginPw) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select * from member where id=? and pw=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Login(rs.getString("id"), rs.getString("name"), rs.getInt("grade"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
		return null;
	}

	public String findId(String email) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select * from member where email=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getString("id");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
		return null;
	}
	
	public String findPw(String userId, String email) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select * from member where id=? and email=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getString("pw");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
		return null;
	}

	public ArrayList<Member> list() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select * from member";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			ArrayList<Member> list = new ArrayList<Member>();
			
			while(rs.next())
				list.add(new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("birth"), rs.getString("tel"), rs.getString("email"), rs.getInt("grade")));
			
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
