package Ex02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlyingTextEx extends JFrame {

	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("<html> HELLO <br> 'q'키를 누르면 종료 </html>");
	
	public FlyingTextEx() {
		super("상, 하, 좌, 우 키를 이용하여 텍스트 움직이기");
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKeyListener());
		
		la.setLocation(30, 30);
		la.setSize(120, 60);
		contentPane.add(la);
		
		setSize(200, 200);
		setVisible(true);
		
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_UP :
				la.setLocation(la.getX(), la.getY() - 10);
				break;
			case KeyEvent.VK_DOWN :
				la.setLocation(la.getX(), la.getY() + 10);
				break;
			case KeyEvent.VK_LEFT :
				la.setLocation(la.getX() - 10, la.getY());
				break;
			case KeyEvent.VK_RIGHT :
				la.setLocation(la.getX() + 10, la.getY());
				break;
			case KeyEvent.VK_CLEAR :
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();
	}
	
}
