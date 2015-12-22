package com.tasty.notice.dao;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.tasty.common.CommonDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Print;

public class OracleNoticeDao extends NoticeDao {// 공통적으로 사용되는 것을 NoticeDao를 통해서 상속
	public List<Notice> list(Object obj) { // 리스트 출력을 위한 메소드 
		List<Notice> list = null;
		try {
			// 드라이버 연결
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문장
			String sql = "select no, title, to_char(wdate,'yyyy-mm-dd')wdate, to_char(startdate,'yyyy-mm-dd')startdate, "
					+ " to_char(enddate,'yyyy-mm-dd')enddate from notice ";
			// 파라메터값에 따른 처리를 위한 switch문
			switch ((String) obj) {
			case "now": // 현재공지
				Print.printTitle("오늘의 맛집리스트", "*");
				sql += " where startdate <= sysdate and enddate >= sysdate-1 "; // 현재공지를 위한 sql조건
				break;
			case "old": // 과거공지
				Print.printTitle("과거의 맛집리스트", "*");
				sql += " where enddate < sysdate-1 "; // 과거공지를 위한 sql조건
				break;
			case "new": // 새로운공지
				Print.printTitle("미래의 맛집리스트", "*");
				sql += " where startdate > sysdate ";// 새로운 공지를 위한 sql조건
				break;
			case "all": // 모든공지
				Print.printTitle("모든 맛집리스트", "*");// 모든공지를 위한 sql조건
				sql += " ";
				break;
			}

			sql += " order by no desc"; // 나머지 sql문장
			// 상태 실행 
			pstmt = conn.prepareStatement(sql);
			// sql문장 실행한 결과를 rs변수에 담는다.
			rs = pstmt.executeQuery();
			// 그 담은 내용을 다시 list변수에 담는다.
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
	}

	public void write(Notice notice) { // 글쓰기를 위한 메소드 
		// TODO Auto-generated method stub
		try {
			// 드라이버 연결 
			conn = DriverManager.getConnection(CommonDao.url, CommonDao.id, CommonDao.pw);
			// sql문장 
			String sql = " insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,?,?,?,?) ";
			// 상태실행및 데이터 입력
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getStartDate());
			pstmt.setString(4, notice.getEndDate());
			// 실행
			pstmt.executeUpdate();
			// 표시
			System.out.println("글이 성공적으로 작성되었습니다.\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// 닫기
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
