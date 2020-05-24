package Cafe_Main;

import javax.swing.*;
import java.awt.*;

public class Sales extends JFrame {
	
	String[] title = { "No", "상품명", "수량", "단가", "금액" };


	public Sales() {
		super("매출목록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 340);
		getContentPane().setLayout(null);

		List list = new List();
		list.setBounds(0, 0, 584, 302);
		getContentPane().add(list);

		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		Sales frame = new Sales();		
	}
}
