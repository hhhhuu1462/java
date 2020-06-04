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

	public int login(String id, String passwd) throws Exception{

		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql="";
		String password="";
		int result = -1;

		try{
			conn =getConnection();
			sql ="select password from login where id = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			
			rs=pstmt.executeQuery();

			if(rs.next()){
				password =rs.getString("password");
				if(password.equals(passwd)) {
					result=1; //��������
				} else {
					result=0; //��й�ȣ Ʋ��
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}try {
			if(rs != null) {rs.close(); }
			if(pstmt != null) {pstmt.close(); }
			closeConnection() ;
		} catch (Exception e2) {
			e2.printStackTrace(); 
		}
		return result;
	}
	
	public int menuAdd(String menuCode, String menuName, int menuPrice){//�ܼ�â���� �����͸� �Է¹޾� ��ü ����
		int result =-1;
		PreparedStatement pstmt =null;
		ResultSet rs = null;		

		try {
			conn = getConnection();
			String sql = "insert into coffeemenu (menucode, menu, price) values (?, ?, ?)";
			pstmt= conn.prepareStatement(sql);

			pstmt.setString(1, menuCode);
			pstmt.setString(2, menuName);
			pstmt.setInt(3, menuPrice);
			
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
	}//menuAdd

	public int coffeeadd(String payway, String menucode, String menu, int price, String ordertime){//�ܼ�â���� �����͸� �Է¹޾� ��ü ����
		int result =-1;
		PreparedStatement pstmt =null;
		ResultSet rs = null;		

		try {
			conn = getConnection();
			String sql = "insert into coffee (payway, menucode, menu, price, ordertime) values (?, (select menucode from coffeemenu where menu=?), ?, ?, ?)";
			pstmt= conn.prepareStatement(sql);

			pstmt.setString(1,  payway);
			pstmt.setString(2, menu);
			pstmt.setString(3, menu);
			pstmt.setInt(4, price);
			pstmt.setString(5, ordertime);

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
	
	public Vector<Info> GetTotalCash() {//db���� �����͸� �޾Ƽ� ���ͷ� ��ȯ�ϴ� �޼ҵ�
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select sum(price) from coffee where payway like '����'";
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info totalCash = new Info() ;
				totalCash.setTotalCash(rs.getInt("sum(price)"));					
				lists.add( totalCash ) ;
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
	}//GetIceCoffee

	public Vector<Info> GetTotalCard() {//db���� �����͸� �޾Ƽ� ���ͷ� ��ȯ�ϴ� �޼ҵ�
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select sum(price) from coffee where payway like 'ī��'";
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info totalCard = new Info() ;
				totalCard.setTotalCard(rs.getInt("sum(price)"));					
				lists.add( totalCard ) ;
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
	}//GetIceCoffee
	
	public Vector<Info> GetHotCoffee() { // hot coffee
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select menu, price from coffeemenu where menucode like 'H%'";
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info hot = new Info() ;
				hot.setMenu(rs.getString("menu"));	
				hot.setPrice(rs.getInt("price"));
				lists.add( hot ) ;
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
	}//GetHotCoffee

	public Vector<Info> GetIceCoffee() {//db���� �����͸� �޾Ƽ� ���ͷ� ��ȯ�ϴ� �޼ҵ�
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select menu, price from coffeemenu where menucode like 'I%'";
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info ice = new Info() ;
				ice.setMenu(rs.getString("menu"));	
				ice.setPrice(rs.getInt("price"));
				lists.add( ice ) ;
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
	}//GetIceCoffee

	public Vector<Info> GetBeverageCoffee() {//db���� �����͸� �޾Ƽ� ���ͷ� ��ȯ�ϴ� �޼ҵ�
		//��� ��ǰ ��ϵ��� �����Ѵ�.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select menu, price from coffeemenu where menucode like 'B%'";
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info beverage = new Info() ;
				beverage.setMenu(rs.getString("menu"));		
				beverage.setPrice(rs.getInt("price"));
				lists.add( beverage ) ;
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
	}//GetBeverageCoffee

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
	
	public  Vector<Info> GetDate(){// ���� �Ǹŵ� �����
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		
		String sql = "select payway, menu, price, ordertime from coffee where ordertime like '"+year+"�� "+month+"�� "+day+"��%'" ;
		Vector<Info> lists = new Vector<Info>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 

			rs = pstmt.executeQuery() ;

			while(rs.next()){
				Info coffee = new Info() ;
				coffee.setPayway(rs.getString("payway"));
				coffee.setMenu(rs.getString("menu"));
				coffee.setPrice( rs.getInt("price") ); 
				coffee.setDate(rs.getString("ordertime"));

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
				info.setPayway(rs.getString("payway"));
				info.setMenuCode(rs.getString("menucode"));
				info.setMenu(rs.getString("menu"));
				info.setPrice( rs.getInt("price") ); 
				info.setDate(rs.getString("ordertime"));

				lists.add( info ) ;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
	
	public Object[][] makeDate(Vector<Info> lists){//���͸� �޾Ƽ� ��ü�� 2���� �迭�� ������ִ� �޼ҵ�

		Object [][] coffeearr = new Object [lists.size()][4]; 			

		for(int i=0; i<lists.size();i++){
			coffeearr[i][0]=lists.get(i).getPayway();
			coffeearr[i][1]=lists.get(i).getMenu();
			coffeearr[i][2]=lists.get(i).getPrice();
			coffeearr[i][3]=lists.get(i).getDate();
		}			

		return coffeearr;

	}//makeArr


	public Object[][] makeArr(Vector<Info> lists){//���͸� �޾Ƽ� ��ü�� 2���� �迭�� ������ִ� �޼ҵ�

		Object [][] coffeearr = new Object [lists.size()][5]; 			

		for(int i=0; i<lists.size();i++){
			coffeearr[i][0]=lists.get(i).getPayway();
			coffeearr[i][1]=lists.get(i).getMenuCode();
			coffeearr[i][2]=lists.get(i).getMenu();
			coffeearr[i][3]=lists.get(i).getPrice();
			coffeearr[i][4]=lists.get(i).getDate();
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