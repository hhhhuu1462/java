package Cafe_Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Sales extends JFrame {
	
	String[] title = { "No", "��ǰ��", "����", "�ܰ�", "�ݾ�" };
	String [] ColName = {"No", "�޴�","����","����"};
	String [][] Data ;	
	int count =1;
	
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable menuTable = new JTable(model);
	JScrollPane menuScroll = new JScrollPane();
	
	public Sales() {
		super("������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1020, 120, 580, 340);
		getContentPane().setLayout(null);
		
		menuTable.setRowHeight(38);
		menuScroll.setBounds(12, 10, 549, 291);
		menuScroll.setViewportView(menuTable);
		getContentPane().add(menuScroll);

		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		Sales frame = new Sales();		
	}
}
