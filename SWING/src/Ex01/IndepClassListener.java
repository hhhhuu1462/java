package Ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame {

	public IndepClassListener() {
		setTitle("Action�̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action"); // ��ư ������Ʈ �����
		//		btn.addActionListener(new ActionListener() {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				JButton b = (JButton)e.getSource();
		//				if(b.getText().equals("Action")) {
		//					b.setText("�׼�");
		//				}
		//				else {
		//					b.setText("Action");
		//				}
		//				// AnonymousClassListener��
		//				// JFrame�� ����� ȣ�� ����
		//				setTitle(b.getText());
		//			}
		//		});

		btn.addActionListener(new MyActionListener()); 
		c.add(btn);

		setSize(250, 120);
		setVisible(true);

	}
	private class MyActionListener  implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("�׼�");
			else
				b.setText("Action");
			// InnerClassListener�� JFrame�� ��� ȣ�� ����
			setTitle(b.getText()); // ������ Ÿ��Ʋ�� ��ư���ڿ� ���
		}
	}

	public static void main(String[] args) {
		new IndepClassListener();
	}

}

// �̺�Ʈ�� ������ �ۼ�
