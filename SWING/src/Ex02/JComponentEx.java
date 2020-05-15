package Ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame {

	public JComponentEx() {
		super("JComponent의 공통 메소드 예제");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Disable Button");
		JButton b3 = new JButton("getX(), getY()");
		JButton b4 = new JButton("close");
		 
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.magenta);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false);
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				setTitle(b.getX() + ", " + b.getY());
			}
		});
		
		b4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		c.add(b1); c.add(b2); c.add(b3); c.add(b4);
		setSize(260, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComponentEx();
	}
	
}


