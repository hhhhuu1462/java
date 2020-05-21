package Cafe_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sales extends JFrame {

	public Sales() {
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
