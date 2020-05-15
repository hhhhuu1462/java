package Ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxIconEventEx extends JFrame {

	JCheckBox[] fruits = new JCheckBox[3];
	
	String[] names = {"���", "��", "ü��"};
	
	JLabel sumLabel;
	
	public CheckBoxIconEventEx() {
		setTitle("üũ�ڽ��� ItemEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("��� 100��, �� 500��, ü�� 20000��"));
		
		MyItemListener listener = new MyItemListener();
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("                                 ���� 0�� �Դϴ�.                                     ");
		
		JButton b = new JButton("close");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		c.add(sumLabel); c.add(b);
		setSize(250, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		int sum = 0;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0]) {
					sum += 100;
				} else if(e.getItem() == fruits[1]) {
					sum += 500;
				} else {
					sum += 20000;
				}
			} else {
				if(e.getItem() == fruits[0]) {
					sum -= 100;
				} else if(e.getItem() == fruits[1]) {
					sum -= 500;
				} else {
					sum -= 20000;
				}
			}
			sumLabel.setText("���� " + sum + "�� �Դϴ�.");			
		}
	}
	
	public static void main(String[] args) {
		new CheckBoxIconEventEx();
	}
	
}
