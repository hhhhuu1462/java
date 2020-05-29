package Cafe_Main;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;

	private String id = null;
	private String pw = null;

	Connection conn; //데이터베이스에 접근하게 해주는 객체
	PreparedStatement pstmt;
	ResultSet rs; //정보를 담을 수 있는 객체

	/**
	 * @param userID
	 * @param userPassword
	 * @return
	 */
	public int login(String id, String pw) {
		try {
			String sql = "select * from login where id = ?";
			//실제 SQL에서 작동하게 할 명령문 입력

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//인젝션해킹등을 방지하기 위한 기법 ?에 ID값을 받은 후 사용.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // 로그인 성공
				} else 
					return 0; // 비밀번호 불일치
			}
			return -1; //아이디가 없음
		}catch(Exception e) {
			e.printStackTrace();    // 예외처리
		}
		return -2; // 데이터베이스 오류
	}



	public Login() {
		//자동으로 데이터베이스 커넥션이 이루어질 수 있도록 접속하게해주는 소스
		try {
			String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
			//데이터베이스 주소
			String dbID = "scott";    //데이터베이스 아이디
			String dbPassword = "tiger";    //데이터베이스 비밀번호
			Class.forName("oracle.jdbc.driver.OracleDriver");    // db에 접속하는 매개체역할 
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace(); //오류발생시 오류내용 출력하게 해주는 소스
		}

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 214);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 125, 106);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(96, 10, 29, 29);
		panel.add(lblNewLabel);

		JLabel lblPaword = new JLabel("PASSWORD :");
		lblPaword.setBounds(40, 49, 85, 29);
		panel.add(lblPaword);

		Panel panel_1 = new Panel();
		panel_1.setBounds(131, 0, 243, 106);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(0, 10, 181, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(0, 51, 181, 28);
		panel_1.add(passwordField);

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 112, 374, 64);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(137, 10, 111, 34);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = "";
				char[] secret_pw  = passwordField.getPassword();
				for (char cha : secret_pw ) {
					Character.toString(cha);
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				if (login(id, pw)==1) {
					new Main();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "id 또는 password가 틀립니다");
					System.exit(0);
				}
			}
		});
		panel_2.add(btnNewButton);
		
		setVisible(true);	
		setResizable(false);
	}

	public static void main(String[] args) {		
		Login frame = new Login();
	}
}
