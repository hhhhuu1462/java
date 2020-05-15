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
		setTitle("������ư ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup(); // ��ư �׷� ��ü ����
		
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��");
		JRadioButton cherry = new JRadioButton("ü��");
		
		// ��ư �׷쿡 3���� ������ư ����
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		JButton b = new JButton("����");
		
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		};
		b.addActionListener(actionListener);
		
		// ����Ʈ�ҿ� 3���� ������ư ����
		c.add(apple); c.add(pear); c.add(cherry); c.add(b);
		setSize(250,150);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new JRadioButtonEx();
	}

}
