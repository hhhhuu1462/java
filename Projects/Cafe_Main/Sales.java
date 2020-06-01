package Cafe_Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

public class Sales extends JFrame {

	private static final long serialVersionUID = -6764304939888109722L;

	Vector<Info> rowData = null;
	CoffeeDAO coffeeDAO = null;

	Object [] ColName = {"MenuCode", "�޴�", "����", "��¥"};
	Object[] sellName = {"�޴�", "�Ǹ��ܼ�"};
	private JTable table;
	private JTable table2;
	JLabel salesLabel;

	public Sales() {		
		super("������");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1020, 120, 600, 500);

		coffeeDAO = new CoffeeDAO();
		rowData = coffeeDAO.GetAllSellList();

		Panel tablePanel = new Panel();
		tablePanel.setBounds(10, 10, 562, 285);
		getContentPane().add(tablePanel);
		tablePanel.setLayout(null);	

		table = new JTable(coffeeDAO.makeArr(coffeeDAO.GetAllSellList()),ColName);
		// �� ���� ����
		table.getColumn(ColName[3]).setPreferredWidth(170);
		table.setRowHeight(38);
		table.setBounds(10, 10, 562, 285);
		tablePanel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 562, 285);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		tablePanel.add(scrollPane);

		Panel buttonPanel = new Panel();
		buttonPanel.setBounds(10, 357, 562, 86);
		getContentPane().add(buttonPanel);

		JButton posBtn = new JButton("POS");
		posBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//â�ݱ�
				setVisible(false);
			}
		});
		buttonPanel.setLayout(null);
		posBtn.setBounds(0, 12, 167, 62);
		buttonPanel.add(posBtn);

		JButton salesBtn = new JButton("����");
		salesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//���̺� ��ü ���� ����Ʈ ���
				rowData =coffeeDAO.GetAllSellList();
				int sum=0;
				for(int i=0; i<rowData.size();i++){					
					sum += rowData.get(i).getPrice();
				}				
				salesLabel.setText("������ ������ "+Integer.toString(sum)+" �Դϴ�.");				
			}
		});
		salesBtn.setBounds(196, 12, 167, 62);
		buttonPanel.add(salesBtn);

		JButton menuBtn = new JButton("�޴����Ǹ�");
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//���̺� �޴��� �ǸŸ���Ʈ
				rowData =coffeeDAO.GetAllSellList();
				scrollPane.setVisible(false);
				table2 = new JTable(coffeeDAO.makelistArr(coffeeDAO.Getsellcount()),sellName);
				table2.setRowHeight(38);
				table2.setBounds(1, 27, 450, 288);
				tablePanel.add(table2);

				JScrollPane scrollPane = new JScrollPane(table2);
				scrollPane.setBounds(0, 0, 562, 285);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				tablePanel.add(scrollPane);				
			}
		});
		menuBtn.setBounds(393, 12, 167, 62);
		buttonPanel.add(menuBtn);	

		Panel salesPanel = new Panel();
		salesPanel.setBounds(10, 309, 562, 39);
		getContentPane().add(salesPanel);
		salesPanel.setLayout(null);

		salesLabel = new JLabel("");
		salesLabel.setBounds(0, 12, 562, 35);
		salesPanel.add(salesLabel);

		setResizable(true);
		getContentPane().setLayout(null);

		setVisible(true);
	}
}