package com.tasty.notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.notice.model.Notice;

public abstract class NoticeDao { //  이 클래스는 OracleNoticeDao에 상속해준다. 
	// 필요한 객체 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// NoticeDao는 부모 클래스이다. 일단 다른 것이 받을 수 있도록 추상메소드를 만듦
	public abstract List<Notice> list(Object obj);

	public abstract void write(Notice notice);

	public Notice view(int no) { // view()
		// TODO Auto-generated method stub
		Notice notice = new Notice();
		try {
			// 드라이버 연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문장
			String sql = "select no, title, content, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ "to_char(enddate,'yyyy-mm-dd')enddate from notice where no = ?";
			// 상태 실행및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 실행
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
				// 닫기
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
	} // end of view()

	public void update(Notice notice, int no) { // update()
		// TODO Auto-generated method stub
		try {
			// 드라이버 연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문장
			String sql = " update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ? ";
			// 상태 실행및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getStartDate());
			pstmt.setString(4, notice.getEndDate());
			pstmt.setInt(5, no);
			// 실행
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
			// 드라이버 연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문장
			String sql = "delete from notice where no =?";
			// 상태 실행및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 실행
			pstmt.executeUpdate();
			// 표시
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
