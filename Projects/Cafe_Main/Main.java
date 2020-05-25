package Cafe_Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

public class Main extends JFrame {

	JPanel panel1, panel2, panel3, panel4, panel5;
	static JButton[] HotCoffeeBtn, ICECoffeeBtn, ShakeFlatchinoBtn;

	static JTabbedPane menuTab = new JTabbedPane();  //JTabbedPane����

	String [] ColName = {"�޴�","����","����"};
	String [][] Data ;	
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable menuTable = new JTable(model);
	JScrollPane menuScroll = new JScrollPane();

	public Main() {
		super("Ezen Cafeteria");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 563);

		launched();

		ImageIcon img = new ImageIcon("C:/lhs/Project/src/Cafe_Main/¯��.jpg");
		setIconImage(img.getImage());
		setResizable(false);
		setVisible(true);
	}

	public void launched() {
		getContentPane().setLayout(null);

		menuTab.setBounds(394, 24, 476, 371);
		getContentPane().add(menuTab);

		// HotCoffeeBtn
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 4, 10, 10));		
		HotCoffeeBtn = new JButton[11];
		String[] HotCoffee = {"�Ƹ޸�ī��", "ī���", "ī���ī", "�ٴҶ��", "īǪġ��", "", "", "", "", "", ""};
		for (int i = 0; i < HotCoffeeBtn.length; i++) {
			HotCoffeeBtn[i] = new JButton(HotCoffee[i]);
			panel1.add(HotCoffeeBtn[i]);
			if(HotCoffee[i].equals("")) {
				HotCoffeeBtn[i].setEnabled(false);
			}			
		}
		menuTab.add("HotCoffee", panel1);

		// ICECoffeeBtn
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 4, 10, 10));	
		ICECoffeeBtn = new JButton[11];
		String[] ICECoffee = {"ICE�Ƹ޸�ī��", "ICEī���", "ICEī���ī", "ICE�ٴҶ��", "ICEīǪġ��", "", "", "", "", "", ""};
		for (int i = 0; i < ICECoffeeBtn.length; i++) {
			ICECoffeeBtn[i] = new JButton(ICECoffee[i]);
			panel2.add(ICECoffeeBtn[i]);
			if(ICECoffee[i].equals("")) {
				ICECoffeeBtn[i].setEnabled(false);
			}
		}
		menuTab.add("IceCoffee", panel2);

		// ShakeFlatchinoBtn
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4, 4, 10, 10));	
		ShakeFlatchinoBtn = new JButton[11];
		String[] ShakeFlatchino = {"����������ũ", "���⽦��ũ", "������Ű����ũ", "<html>���ڹ������<br>����ũ</html>", "<html>ġ���Ű�ߴ�<br>����ũ</html>", 
				"��ĿƮ�÷�ġ��", "�����÷�ġ��", "<html>��纣�����Ʈ<br>�÷�ġ��</html>", "�ܺ������÷�ġ��", "", ""};
		for (int i = 0; i < ShakeFlatchinoBtn.length; i++) {
			ShakeFlatchinoBtn[i] = new JButton("<html> <center> " + ShakeFlatchino[i] + "</center> </html>");
			panel3.add(ShakeFlatchinoBtn[i]);
			if(ShakeFlatchino[i].equals("")) {
				ShakeFlatchinoBtn[i].setEnabled(false);
			}
		}
		menuTab.add("Beverage", panel3);

		// ���ư
		panel4 = new JPanel();
		panel4.setBounds(394, 410, 476, 85);
		getContentPane().add(panel4);
		panel4.setLayout(new GridLayout(1, 6, 10, 10));		
		String[] operation = {"", "", ""};
		JButton[] inventoryManagement = new JButton[3];
		for (int i = 0; i < inventoryManagement.length; i++) {
			inventoryManagement[i] = new JButton(operation[i]);
			panel4.add(inventoryManagement[i]);
		}

		// �ֹ�����Ʈ
		menuTable.setRowHeight(38);
		menuScroll.setViewportView(menuTable);
		menuScroll.setBounds(26, 24, 353, 238);
		getContentPane().add(menuScroll);
		for(int i=0;i<HotCoffeeBtn.length;i++) {
			final int index =i;
			HotCoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					m.addRow(new Object[]{HotCoffee[index],count});
				}
			});
			ICECoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					m.addRow(new Object[]{ICECoffee[index],count});
				}
			});
			ShakeFlatchinoBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					m.addRow(new Object[]{ShakeFlatchino[index],count});
				}
			});
		}

	}

	public static void main(String[] args) {
		Main frame = new Main();
		PopupMenu pMenu = new PopupMenu();
		MenuItem miCut = new MenuItem("����");
		MenuItem miCopy = new MenuItem("����");
		MenuItem miPaste = new MenuItem("����");
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);
		frame.add(pMenu);
		menuTab.add(pMenu);
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getModifiers()==MouseEvent.BUTTON3_MASK){
					pMenu.show(frame, e.getX(), e.getY());		
				}}
			});
		

	}
}