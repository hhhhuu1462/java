package Ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 오라클 연동, 쿼리문 전달
public class MemberDAO {
	// 사용할 db는 오라클
	String driver = "oracle.jdbc.driver.OracleDriver";

	// ip나 로컬호스트로 연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // thin -> oracle의 버전 @localhost:포트번호:sid

	// 계정의 아이디와 비밀번호
	String userid = "scott";
	String password = "tiger";

	public MemberDAO() {
		// 드라이버 로딩 
		try {
			// 로딩 시 에러발생 대비 예외처리 실행
			Class.forName(driver); // Class.forName()메소드에 driver클래스 위치를 넘김
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	// 회원정보 보기
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		// Connection 연결
		Connection conn = null;
		PreparedStatement pstmt = null; // SQL구문을 실행시키는 기능을 갖는 객체
		ResultSet rs = null;

		try {
			// 연결 에러발생 대비 예외처리 실행
			conn = DriverManager.getConnection(url, userid, password); // 연결 얻기
			String query = "select * from member";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); // 명령 실행

			while (rs.next()) { // db속성을 자바 클래스 멤버로 넣기
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name")); // db상의 칼럼명 name을 뜻함
				dto.setAge(rs.getInt("age")); // db상의 칼럼명 age를 뜻함
				dto.setHeight(rs.getDouble("height")); // db상의 칼럼명 height를 뜻함
				dto.setWeight(rs.getDouble("weight")); // db상의 칼럼명 weight를 뜻함
				dto.setSex(rs.getString("sex").charAt(0)); // db상의 칼럼명 sex를 뜻함 : 남자로 입력했을 시 첫글자만 반영
				list.add(dto); // list에 반영
			}
		} catch (SQLException e) {	e.printStackTrace();} 
		finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }

			} catch (SQLException e) { e.printStackTrace(); } 
		}
		return list;
	} // end select() 회원정보 보기

	// 회원정보 저장
	public int insert(String name, String age, String height, String weight, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String sql = "insert into member(name, age, height, weight, sex)" + "values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql); // 쿼리문 연결
			pstmt.setString(1, name); // 첫번째 물음표에 들어갈 변수
			pstmt.setInt(2,  Integer.parseInt(age)); // 두번째 물음표에 들어갈 변수
			pstmt.setDouble(3, Double.parseDouble(weight)); // 세번째 물음표에 들어갈 변수
			pstmt.setDouble(4, Double.parseDouble(height)); // 네번째 물음표에 들어갈 변수
			pstmt.setString(5, sex); // 다섯번째 물음표에 들어갈 변수

			n = pstmt.executeUpdate(); // oracle 실행버튼과 같은 역할
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();	} 
				if(conn != null) { conn.close(); }
			}catch (SQLException e) {e.printStackTrace();}
		}
		return n;
	} // end insert() 회원정보 저장

	// 회원정보 삭제
	public int delete(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String sql = "delete from member where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(conn != null) { conn.close(); }
			} catch (Exception e) {e.printStackTrace();}
		}
		return n;
	} // end delete() 회원정보 삭제

	public int update(String name, String age, String height, String weight, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String sql = "update member set age = ?, height = ?, weight = ?, sex = ? where name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  Integer.parseInt(age));
			pstmt.setDouble(2,  Double.parseDouble(weight));
			pstmt.setDouble(3,  Double.parseDouble(height));
			pstmt.setString(4,  sex);
			pstmt.setString(5,  name);

			n = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(conn != null) { conn.close(); }
				if(pstmt != null) { pstmt.close();}
			} catch (Exception e) {e.printStackTrace();}
		}
		return n;
	}

	// 회원정보 조회에 사용할 name 존재 여부 체크
	public boolean isExist(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, userid, password);
			String sql = "select * from member where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) {rs.close();}
				if(conn != null) { conn.close();}
				if(pstmt != null) { pstmt.close();}
			} catch (Exception e) {e.printStackTrace();}
		}
		return result;
	} // end isExist name존재 체크

	// 회원정보 조회
	public MemberDTO search(String name) throws Exception {
		if(!isExist(name)) {
			throw new Exception("\"" + name + "\"는 없습니다.");
		}
		MemberDTO dto = new MemberDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DriverManager.getConnection(url, userid, password);
			String sql = "select * from member where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getDouble("height"));
				dto.setWeight(rs.getDouble("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
			}
		} catch (Exception e) { e.printStackTrace();}
		finally {
			if(rs != null) rs.close();
		    if(pstmt != null) pstmt.close();
		    if(con != null) con.close();
		}
		return dto;
	} // end search 회원정보 조회

}
