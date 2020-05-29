package Cafe_Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CoffeeDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "scott" ;
	private String password = "tiger" ;
	private Connection conn = null ;
	
	
	public CoffeeDAO() {
		try {
			Class.forName(driver) ;			
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ �߰ߵ��� �ʽ��ϴ�(jar ���� ����)"); 
			e.printStackTrace();		
		}
	}
	
	private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password) ;
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ���� ����");
			e.printStackTrace();
		}
		return conn ;
	}
	
	private void closeConnection() {
		try {
			if(conn != null) {conn.close(); }
		} catch (Exception e2) {
			e2.printStackTrace(); 
		}		
	}
	
	public int coffeeadd(Info info){//�ܼ�â���� �����͸� �Է¹޾� ��ü ����
		int result =-1;
		
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "insert into coffee (menucode, menu, PRICE, orderTime) values ((select menucode from coffeemenu where menu=?), ?, ?, ?)";
				
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, info.getMenu());
			pstmt.setString(2, info.getMenu());
			pstmt.setInt(3, info.getPrice());
			pstmt.setString(4, info.getDate());

			result = pstmt.executeUpdate();
			conn.commit();	
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();  
			}
		}finally{
			try {
				if(rs != null) {rs.close(); }
				if(pstmt != null) {pstmt.close(); }
				closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return result;
	}//coffeeadd
	
	public Vector<Info> GetAllSellList() {//db���� �����͸� �޾Ƽ� ���ͷ� ��ȯ�ϴ� �޼ҵ�
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select * from coffee" ;
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()){
				Info info = new Info() ;
				info.setMenuCode(rs.getString("menucode"));
				info.setMenu(rs.getString("menu"));
				info.setPrice( rs.getInt("PRICE") ); 
				info.setDate(rs.getString("orderTime"));
				
				lists.add( info ) ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(rs != null) {rs.close(); }
				if(pstmt != null) {pstmt.close(); }
				closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return lists ;
	}//GetAllSellList
	
public Object[][] makeArr(Vector<Info> lists){//���͸� �޾Ƽ� ��ü�� 2���� �迭�� ������ִ� �޼ҵ�
		
		Object [][] coffeearr = new Object [lists.size()][5]; 			
				
			for(int i=0; i<lists.size();i++){
				coffeearr[i][0]=lists.get(i).getMenuCode();
				coffeearr[i][1]=lists.get(i).getMenu();
				coffeearr[i][2]=lists.get(i).getPrice();
				coffeearr[i][3]=lists.get(i).getDate();
			}			
			
		return coffeearr;
		
	}//makeArr
	
}
