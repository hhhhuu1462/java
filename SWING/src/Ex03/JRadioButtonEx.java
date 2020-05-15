package Ex03;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonEx extends JFrame {

	public JRadioButtonEx() {
		setTitle("라디오버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성
		
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배");
		JRadioButton cherry = new JRadioButton("체리");
		
		// 버튼 그룹에 3개의 라디오버튼 삽입
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		JButton b = new JButton("종료");
		
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		};
		b.addActionListener(actionListener);
		
		// 컨텐트팬에 3개의 라디오버튼 삽입
		c.add(apple); c.add(pear); c.add(cherry); c.add(b);
		setSize(250,150);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new JRadioButtonEx();
	}

}
