package com.tasty.notice.dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.tasty.common.CommonDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Print;

public class NoticeDao extends CommonDao {

	public List<Notice> list(Object obj) {
		// TODO Auto-generated method stub
		List<Notice> list = null;
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select no, title, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ " to_char(enddate,'yyyy-mm-dd')enddate from notice ";
			switch ((String) obj){
			case "now": // 현재공지
				Print.printTitle("오늘의 맛집리스트", "*");
				sql += " where startdate <= sysdate and enddate >= sysdate-1 ";
				break;
			case "old": // 과거공지
				Print.printTitle("과거의 맛집리스트", "*");
				sql += " where enddate < sysdate-1 ";
				break;
			case "new": // 새로운공지
				Print.printTitle("미래의 맛집리스트", "*");
				sql += " where startdate > sysdate ";
				break;
			case "all": // 모든공지
				Print.printTitle("모든 맛집리스트", "*");
				sql += " ";
				break;
			}

			sql += " order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Notice>();
			while (rs.next()) {
				list.add(new Notice(rs.getInt("no"), rs.getString("title"), rs.getString("wdate"),
						rs.getString("startDate"), rs.getString("endDate")));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return list;
	}

	public Object view(int no) {
		// TODO Auto-generated method stub
		Notice notice = new Notice();
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select no, title, content, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ "to_char(enddate,'yyyy-mm-dd')enddate from notice where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				notice.setNo(rs.getInt("no"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setWdate(rs.getString("Wdate"));
				notice.setStartDate(rs.getString("Startdate"));
				notice.setEndDate(rs.getString("enddate"));
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return notice;	
		}

	public void write(Notice notice) {
		// TODO Auto-generated method stub

	}

}
