package Ex01;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame {

	static JLabel la = new JLabel("Hello"); // "Hello" 출력용 레이블

	public MouseListenerEx() {
		setTitle("Mouse리스sj 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
//		c.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//				la.setLocation(x, y);				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});

		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);

		setSize(200, 200);
		setVisible(true);
	}

	//	class MyMouseListener implements MouseListener {
	//
	//		@Override
	//		public void mouseClicked(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mousePressed(MouseEvent e) {
	//			int x = e.getX();
	//			int y = e.getY();
	//			la.setLocation(x, y);
	//		}
	//
	//		@Override
	//		public void mouseReleased(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseEntered(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//
	//		@Override
	//		public void mouseExited(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//			
	//		}
	//		
	//	}




	public static void main(String[] args) {
		new MouseListenerEx();
	}

}

class MyMouseAdapter extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		MouseListenerEx.la.setLocation(x, y);	
	}
}