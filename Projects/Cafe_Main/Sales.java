package Cafe_Main;

import javax.swing.*;
import java.awt.*;

public class Sales extends JFrame {
	
	String[] title = { "No", "��ǰ��", "����", "�ܰ�", "�ݾ�" };


	public Sales() {
		super("������");
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
