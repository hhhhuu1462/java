package Ex03;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListEx extends JFrame {

	String [] fruits= {"apple", "banana", "kiwi", "mango", "pear", "peach",
			"berry", "strawberry", "blackberry"};
			ImageIcon [] images = { new ImageIcon("C:\\Users\\user\\Desktop\\image\\icon1.png"),
			new ImageIcon("C:\\Users\\user\\Desktop\\image\\icon2.png"),
			new ImageIcon("C:\\Users\\user\\Desktop\\image\\icon3.png"),
			new ImageIcon("C:\\Users\\user\\Desktop\\image\\icon4.png") };
	
	public ListEx() {
	
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JList strList = new JList(fruits);
		c.add(strList);
		
		JList imageList = new JList();
		imageList.setListData(images);
		c.add(imageList);
		
		JList scrollList = new JList(fruits);
		c.add(new JScrollPane(scrollList));
		
		setSize(300,300); 
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new ListEx();
	}
	
}
