package Ex02;

import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame {
	
	LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("���ӽ� ���� �Դϴ�!");
		ImageIcon img = new ImageIcon("C:\\Temp\\a.jpg");
		JLabel imageLabel = new JLabel(img);
		ImageIcon icon = new ImageIcon("C:\\\\Temp\\\\a.jpg");
		JLabel label = new JLabel("Ŀ������ �ϽǷ���, ��ȭ���̼�",
				icon, SwingConstants.CENTER);
		
		c.add(textLabel); c.add(imageLabel); c.add(label);
		setSize(300,500);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new LabelEx();
	}
	
}