package Ex03;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldEx extends JFrame {

	public JTextFieldEx() {

		setTitle("텍스트필드 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton button = new JButton("종료");
		
		ActionListener actionListener = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		};
		
		button.addActionListener(actionListener);

		c.add(new JLabel("이름 "));
		c.add(new JTextField(20));
		c.add(new JLabel("학과 "));
		c.add(new JTextField("컴퓨터공학과", 20));
		c.add(new JLabel("주소 "));
		c.add(new JTextField("서울시 ...", 20));
		c.add(button);

		setSize(300,150);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		
		new JTextFieldEx();
		
	}

}
