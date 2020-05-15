package Ex01;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx extends JFrame {

	public GridLayoutEx() {
		
		super("GridLayout ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		// 1x10�� GridLayout ��ġ������
		
		contentPane.setLayout(new GridLayout(6, 5));
		
		for(int i=97; i<123; i++) { // 10���� ��ư ����
			String text = Character.toString((char)i); // i�� ���ڿ��� ��ȯ
			JButton button = new JButton(text);
			contentPane.add(button); // ����Ʈ�ҿ� ��ư ����
		}
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {		
		new GridLayoutEx();
	}

}
