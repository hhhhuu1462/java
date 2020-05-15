package Ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCharEx extends JFrame {

	JLabel la = new JLabel("<html> <Enter>키로 배경색이 바뀝니다 "
			+ "<br>"
			+ " q키를 누르면 종료합니다 </html>");
	
	public KeyCharEx() {
		super("KeyListener의 문자 키 입력 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		c.add(la);
		c.addKeyListener(new MyKeyListener());
		setSize(250, 150);
		setVisible(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int r = (int)(Math.random() * 256);
			int g = (int)(Math.random() * 256);
			int b = (int)(Math.random() * 256);
			
			switch(e.getKeyChar()) {
			case '\n' :
				la.setText("r = " + r + ", g = " + g + ", b = " + b);
				getContentPane().setBackground(new Color(r, g, b));
				break;
			case 'q' :
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new KeyCharEx();
	}
	
}
