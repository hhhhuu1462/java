package Cafe_Main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sales extends JFrame {
	
	String [] ColName = {"MenuCode", "메뉴", "가격", "날짜"};
	String [][] Data ;	
	int count =1;	
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable menuTable = new JTable(model);
	JScrollPane menuScroll = new JScrollPane();

	public Sales() {
		super("매출목록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1020, 120, 600, 390);
		getContentPane().setLayout(null);
		
		menuTable.setRowHeight(38);
		menuScroll.setBounds(5, 5, 571, 338);
		menuScroll.setViewportView(menuTable);
		getContentPane().add(menuScroll);
		
		setResizable(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Sales frame = new Sales();		
	}
}