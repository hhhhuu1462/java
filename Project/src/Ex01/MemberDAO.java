package Ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// ����Ŭ ����, ������ ����
public class MemberDAO {
	// ����� db�� ����Ŭ
	String driver = "oracle.jdbc.driver.OracleDriver";

	// ip�� ����ȣ��Ʈ�� ����
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // thin -> oracle�� ���� @localhost:��Ʈ��ȣ:sid

	// ������ ���̵�� ��й�ȣ
	String userid = "scott";
	String password = "tiger";

	public MemberDAO() {
		// ����̹� �ε� 
		try {
			// �ε� �� �����߻� ��� ����ó�� ����
			Class.forName(driver); // Class.forName()�޼ҵ忡 driverŬ���� ��ġ�� �ѱ�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	// ȸ������ ����
	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		// Connection ����
		Connection conn = null;
		PreparedStatement pstmt = null; // SQL������ �����Ű�� ����� ���� ��ü
		ResultSet rs = null;

		try {
			// ���� �����߻� ��� ����ó�� ����
			conn = DriverManager.getConnection(url, userid, password); // ���� ���
			String query = "select * from member";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(); // ��� ����

			while (rs.next()) { // db�Ӽ��� �ڹ� Ŭ���� ����� �ֱ�
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name")); // db���� Į���� name�� ����
				dto.setAge(rs.getInt("age")); // db���� Į���� age�� ����
				dto.setHeight(rs.getDouble("height")); // db���� Į���� height�� ����
				dto.setWeight(rs.getDouble("weight")); // db���� Į���� weight�� ����
				dto.setSex(rs.getString("sex").charAt(0)); // db���� Į���� sex�� ���� : ���ڷ� �Է����� �� ù���ڸ� �ݿ�
				list.add(dto); // list�� �ݿ�
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
	} // end select() ȸ������ ����

	// ȸ������ ����
	public int insert(String name, String age, String height, String weight, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			conn = DriverManager.getConnection(url, userid, password);
			String sql = "insert into member(name, age, height, weight, sex)" + "values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql); // ������ ����
			pstmt.setString(1, name); // ù��° ����ǥ�� �� ����
			pstmt.setInt(2,  Integer.parseInt(age)); // �ι�° ����ǥ�� �� ����
			pstmt.setDouble(3, Double.parseDouble(weight)); // ����° ����ǥ�� �� ����
			pstmt.setDouble(4, Double.parseDouble(height)); // �׹�° ����ǥ�� �� ����
			pstmt.setString(5, sex); // �ټ���° ����ǥ�� �� ����

			n = pstmt.executeUpdate(); // oracle �����ư�� ���� ����
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();	} 
				if(conn != null) { conn.close(); }
			}catch (SQLException e) {e.printStackTrace();}
		}
		return n;
	} // end insert() ȸ������ ����

	// ȸ������ ����
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
	} // end delete() ȸ������ ����

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

	// ȸ������ ��ȸ�� ����� name ���� ���� üũ
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
	} // end isExist name���� üũ

	// ȸ������ ��ȸ
	public MemberDTO search(String name) throws Exception {
		if(!isExist(name)) {
			throw new Exception("\"" + name + "\"�� �����ϴ�.");
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
	} // end search ȸ������ ��ȸ

}
