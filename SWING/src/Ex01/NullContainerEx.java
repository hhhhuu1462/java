package Ex01;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {

	NullContainerEx() {

		setTitle("��ġ������ ���� ���� ��ġ�� ��ġ�ϴ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();

		contentPane.setLayout(null); // ����Ʈ���� ��ġ������ ����

		JLabel la = new JLabel("Hello, Press Buttons!");
//		la.setLocation(130, 50); // la�� (130,50) ��ġ�� ����
//		la.setSize(200, 20); // la�� 200x20 ũ��� ����
		la.setBounds(130,  50,  200,  20);
		contentPane.add(la); // la�� ����Ʈ�ҿ� ����
		
		JButton c = new JButton("OK"); // ��ư ����
		c.setLocation(200, 200); // ��ư�� ��ġ ����
		c.setSize(100, 100); // ��ư�� ũ��� �����ϰ� 50x20
		contentPane.add(c); // ��ư�� ����Ʈ�ҿ� ����

		// 9���� ��ư ������Ʈ�� �����ϰ� ������ ũ��� �����Ѵ�.
		// ��ġ�� ���� ��ġ�� �����Ѵ�.
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i)); // ��ư ����
			b.setLocation(i*20, i*20); // ��ư�� ��ġ ����
			b.setSize(50, 20); // ��ư�� ũ��� �����ϰ� 50x20
			contentPane.add(b); // ��ư�� ����Ʈ�ҿ� ����
		}

		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new NullContainerEx();
	}
}
