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

	public ArrayList<Member> list() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, tel, email, grade from member where not grade=9";
			
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

	public void write(Member member) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "insert into member(id, pw, name, birth, tel, email) values(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getEmail());
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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

	public Member view(String userId) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, tel, email, grade from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("birth"), rs.getString("tel"), rs.getString("email"), rs.getInt("grade"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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

	public void update(Member member) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "update member set name=?, birth=?, tel=?, email=? where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			
			pstmt.executeUpdate();
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
	}

	public void updatePw(String userId, String userPw) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "update member set pw=? where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
	
	public String deleteCheck(String userId) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select pw from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("pw");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
	
	public int delete(String userId) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "delete from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			return pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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

	public String updatePwCheck(String userId) {
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select pw from member where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("pw");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
