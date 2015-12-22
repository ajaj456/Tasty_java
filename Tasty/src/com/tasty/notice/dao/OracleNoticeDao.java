package com.tasty.notice.dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Print;

public class OracleNoticeDao extends NoticeDao {
	public List<Notice> list(Object obj) {
		List<Notice> list = null;
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = "select no, title, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ " to_char(enddate,'yyyy-mm-dd')enddate from notice ";
			switch ((String) obj) {
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

		return null;
	}

	public void write(Notice notice) {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = " insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getStartDate());
			pstmt.setString(4, notice.getEndDate());
			pstmt.executeUpdate();
			System.out.println("글이 성공적으로 작성되었습니다.\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	} // end of write()
}
