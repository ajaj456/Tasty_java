package com.tasty.notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Print;

public class NoticeDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

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

	public Notice view(int no) {
		// TODO Auto-generated method stub
		Notice notice = new Notice();
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = "select no, title, content, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ "to_char(enddate,'yyyy-mm-dd')enddate from notice where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				notice.setNo(rs.getInt("no"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setWdate(rs.getString("Wdate"));
				notice.setStartDate(rs.getString("Startdate"));
				notice.setEndDate(rs.getString("enddate"));
				return notice;
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

	public void update(Notice notice, int no) {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = " update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getStartDate());
			pstmt.setString(4, notice.getEndDate());
			pstmt.setInt(5, no);
			pstmt.executeUpdate();
			System.out.println("수정이 되었습니다.\n");
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
	} // end of update()

	public void delete(int no) {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			String sql = "delete from notice where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			System.out.println("\n글이 삭제되었습니다." + "\n이전메뉴로 돌아갑니다.\n");
		} catch (Exception e) {
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
	} // end of delete()
}
