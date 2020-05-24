package Cafe_Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

	JPanel panel1, panel2, panel3, panel4;
	JButton[] HotCoffeeBtn, ICECoffeeBtn, ShakeFlatchinoBtn;

	JTabbedPane menuTab = new JTabbedPane();  //JTabbedPane����
	
	String [] ColName = {"�޴�","����","����"};
	String [][] Data ;
	
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);

	class Screen extends JPanel{
		Screen(){
			setBackground(Color.WHITE);
			setBounds(10, 15, 378, 371);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(25);
			table.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}


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
		}
		menuTab.add("IceCoffee", panel2);

		// ShakeFlatchinoBtn
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4, 4, 10, 10));	
		ShakeFlatchinoBtn = new JButton[11];
		String[] ShakeFlatchino = {"����������ũ", "���⽦��ũ", "������Ű����ũ", "���ڹ������<br>����ũ", "ġ���Ű�ߴ�<br>����ũ", 
				"��ĿƮ�÷�ġ��", "�����÷�ġ��", "��纣�����Ʈ<br>�÷�ġ��", "�ܺ������÷�ġ��", "", ""};
		for (int i = 0; i < ShakeFlatchinoBtn.length; i++) {
			ShakeFlatchinoBtn[i] = new JButton("<html> <center> " + ShakeFlatchino[i] + "</center> </html>");
			panel3.add(ShakeFlatchinoBtn[i]);
		}
		menuTab.add("Beverage", panel3);

		// ���ư
		panel4 = new JPanel();
		panel4.setBounds(10, 410, 860, 85);
		getContentPane().add(panel4);
		panel4.setLayout(new GridLayout(1, 6, 10, 10));		
		String[] operation = {"������", "����", "�ֹ�����", "����", "����", "�ʱ�ȭ"};
		JButton[] inventoryManagement = new JButton[6];
		for (int i = 0; i < inventoryManagement.length; i++) {
			inventoryManagement[i] = new JButton(operation[i]);
			panel4.add(inventoryManagement[i]);
		}
		
		// �޴��߰� ���̺�
		Screen sc = new Screen();
		add(sc);		
		
		for(int i=0;i<HotCoffeeBtn.length;i++) {
			final int index =i;
			HotCoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{HotCoffee[index]});
				}
			});
		}

	}

	public static void main(String[] args) {
		Main frame = new Main();
	}
}