package com.tasty.member.dao;

import java.sql.DriverManager;
import java.util.ArrayList;

import com.tasty.common.CommonDao;
import com.tasty.member.model.Member;

public class OracleMemberDao extends MemberDao {

	public ArrayList<Member> list() {
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			
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
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			
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
}
