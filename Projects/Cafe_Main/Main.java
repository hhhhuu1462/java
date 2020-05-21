package Cafe_Main;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

	JTabbedPane t = new JTabbedPane();  //JTabbedPane생성

	public Main() {
		super("Ezen Cafeteria");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 563);
		getContentPane().setLayout(null);

		List list = new List();
		list.setBounds(10, 21, 378, 374);
		getContentPane().add(list);

		t.setBounds(394, 24, 476, 371);
		getContentPane().add(t);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);				
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		t.add("HotCoffee", panel);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 4, 10, 10));	
		JButton btnNewButton11 = new JButton("New button");
		panel2.add(btnNewButton11);		
		JButton btnNewButton_12 = new JButton("New button");
		panel2.add(btnNewButton_12);		
		JButton btnNewButton_13 = new JButton("New button");
		panel2.add(btnNewButton_13);		
		JButton btnNewButton_14 = new JButton("New button");
		panel2.add(btnNewButton_14);		
		JButton btnNewButton_15 = new JButton("New button");
		panel2.add(btnNewButton_15);		
		JButton btnNewButton_16 = new JButton("New button");
		panel2.add(btnNewButton_16);		
		JButton btnNewButton_17 = new JButton("New button");
		panel2.add(btnNewButton_17);
		JButton btnNewButton_18 = new JButton("New button");
		panel2.add(btnNewButton_18);		
		JButton btnNewButton_19 = new JButton("New button");
		panel2.add(btnNewButton_19);		
		JButton btnNewButton_20 = new JButton("New button");
		panel2.add(btnNewButton_20);				
		JButton btnNewButton_21 = new JButton("New button");
		panel2.add(btnNewButton_21);
		t.add("IceCoffee", panel2);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4, 4, 10, 10));	
		JButton btnNewButton22 = new JButton("New button");
		panel3.add(btnNewButton22);		
		JButton btnNewButton_23 = new JButton("New button");
		panel3.add(btnNewButton_23);		
		JButton btnNewButton_24 = new JButton("New button");
		panel3.add(btnNewButton_24);		
		JButton btnNewButton_25 = new JButton("New button");
		panel3.add(btnNewButton_25);		
		JButton btnNewButton_26 = new JButton("New button");
		panel3.add(btnNewButton_26);		
		JButton btnNewButton_27 = new JButton("New button");
		panel3.add(btnNewButton_27);		
		JButton btnNewButton_28 = new JButton("New button");
		panel3.add(btnNewButton_28);
		JButton btnNewButton_29 = new JButton("New button");
		panel3.add(btnNewButton_29);		
		JButton btnNewButton_30 = new JButton("New button");
		panel3.add(btnNewButton_30);		
		JButton btnNewButton_31 = new JButton("New button");
		panel3.add(btnNewButton_31);				
		JButton btnNewButton_32 = new JButton("New button");
		panel3.add(btnNewButton_32);
		t.add("쉐이크/플랫치노", panel3);

		Panel panel4 = new Panel();
		panel4.setBounds(10, 410, 860, 85);
		getContentPane().add(panel4);
		panel4.setLayout(new GridLayout(1, 6, 10, 10));		
		JButton inventoryManagement = new JButton("재고관리");
		panel4.add(inventoryManagement);
		JButton sales = new JButton("매출");
		sales.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sales();
			}
		});
		panel4.add(sales);		
		JButton orderDetails = new JButton("주문내역");
		panel4.add(orderDetails);		
		JButton coupon = new JButton("쿠폰");
		panel4.add(coupon);		
		JButton payment = new JButton("결제");
		panel4.add(payment);		
		payment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "결제하시겠습니까");				
			}
		});
		JButton initialization = new JButton("초기화");
		panel4.add(initialization);

	}

	public static void main(String[] args) {
		Main frame = new Main();
		ImageIcon img = new ImageIcon("C:/lhs/Pos/src/Pos/짱구.jpg");
		frame.setIconImage(img.getImage());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
