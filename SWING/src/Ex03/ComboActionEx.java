package Ex03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame {

	String [] fruits = {"apple", "banana", "mango"};
	
	ImageIcon [] images = { new ImageIcon("C:\\Users\\user\\Desktop\\image\\apple.jpg"),
			new ImageIcon("C:\\Users\\user\\Desktop\\image\\banana.jpg"),
			new ImageIcon("C:\\Users\\user\\Desktop\\image\\mango.jpg") };
	
	JLabel imgLabel = new JLabel(images[0]);
	
	ComboActionEx() {
		
		setTitle("콤보박스 활용 예제");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox combo = new JComboBox(fruits);
		
		c.add(combo); c.add(imgLabel);
		
		// 콤보박스에 Action 리스너 등록. 선택된 아이템의 이미지 출력
		combo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
				
			}
			
		});
		
		JButton b = new JButton("종료");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		c.add(b);
		
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ComboActionEx();
	}

}
