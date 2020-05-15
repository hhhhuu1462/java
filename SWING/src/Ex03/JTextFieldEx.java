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

		setTitle("�ؽ�Ʈ�ʵ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton button = new JButton("����");
		
		ActionListener actionListener = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		};
		
		button.addActionListener(actionListener);

		c.add(new JLabel("�̸� "));
		c.add(new JTextField(20));
		c.add(new JLabel("�а� "));
		c.add(new JTextField("��ǻ�Ͱ��а�", 20));
		c.add(new JLabel("�ּ� "));
		c.add(new JTextField("����� ...", 20));
		c.add(button);

		setSize(300,150);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		
		new JTextFieldEx();
		
	}

}
