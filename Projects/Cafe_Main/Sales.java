package Cafe_Main;

import javax.swing.*;
import java.awt.*;

public class Sales extends JFrame {
	
	public Sales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 340);
		getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(0, 0, 584, 302);
		getContentPane().add(list);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Sales frame = new Sales();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
