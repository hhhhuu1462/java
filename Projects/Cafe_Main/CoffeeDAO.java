package Cafe_Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CoffeeDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:TestDB" ;
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
	
	public int coffeeadd(String menucode, String menu, int price, String ordertime){//�ܼ�â���� �����͸� �Է¹޾� ��ü ����
		int result =-1;
		PreparedStatement pstmt =null;
		ResultSet rs = null;		
				
		try {
			conn = getConnection();
			String sql = "insert into coffee (menucode, menu, price, ordertime) values ((select menucode from coffeemenu where menu=?), ?, ?, ?)";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, menucode);
			pstmt.setString(2, menu);
			pstmt.setInt(3, price);
			pstmt.setString(4, ordertime);

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

	public  Vector<Info> Getsellcount(){// ���� �Ǹŵ� �����
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		// �޴� �̸��� �� �޴��� ������ ��ü �࿡�� �ľ�
		// group by : �޴��� �������� �׷�ȭ �� (by �ǸŰ���)
		// order by :���ı���
		String sql = "select menu , count(*)  from coffee group by menu order by count(*) desc" ;
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()){
				Info coffee = new Info() ;
				coffee.setMenu (rs.getString("menu"));
				coffee.setPrice( rs.getInt("count(*)") ); 
				
				lists.add( coffee ) ;
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
	}//Getsellcount
	
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
				info.setPrice( rs.getInt("price") ); 
				info.setDate(rs.getString("ordertime"));
				
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
		
		Object [][] coffeearr = new Object [lists.size()][4]; 			
				
			for(int i=0; i<lists.size();i++){
				coffeearr[i][0]=lists.get(i).getMenuCode();
				coffeearr[i][1]=lists.get(i).getMenu();
				coffeearr[i][2]=lists.get(i).getPrice();
				coffeearr[i][3]=lists.get(i).getDate();
			}			
			
		return coffeearr;
		
	}//makeArr

public Object[][] makelistArr(Vector<Info> lists){//���͸� �޾Ƽ� �Ǵ뷮�� 2���� �迭�� ������ִ� �޼ҵ�
	
	Object [][] coffeearr = new Object [lists.size()][2]; 
						
		for(int i=0; i<lists.size();i++){
			coffeearr[i][0]=lists.get(i).getMenu();
			coffeearr[i][1]=lists.get(i).getPrice();
		}		
		
	return coffeearr;
	
}//makeArr

public int delete (String menu) throws Exception {
	int result = -1;
    
    Connection conn = this.getConnection();// ���� ��ü
    PreparedStatement pstmt = null;// SQL �ؼ� ��ü
    String sql = "delete coffeemenu where menu = ?";

    try {
        pstmt = conn.prepareStatement(sql); // SQL �ؼ�
        pstmt.setString(1, menu);
        if(pstmt.executeUpdate()==1){
            JOptionPane.showMessageDialog(null, "���� �Ϸ�");
        }else{
        	 JOptionPane.showMessageDialog(null, "���� ����");
        }
        
    	result = pstmt.executeUpdate();
		conn.commit();	        
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
		try {
			if(pstmt != null) {pstmt.close(); }
			closeConnection() ;
		} catch (Exception e2) {
			e2.printStackTrace(); 
		}
	}
    return result;
}
	
}
