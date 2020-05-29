package Cafe_Main;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.IntStream;

public class Main extends JFrame { 
	private static final long serialVersionUID = -2979632338990090898L;

	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	static JTabbedPane menuTab = new JTabbedPane();  //JTabbedPane생성
	JTextField tf = new JTextField(); // 총 금액
	static JButton[] HotCoffeeBtn, ICECoffeeBtn, ShakeFlatchinoBtn; // 메뉴 버튼

	// 주문 테이블
	String [] ColName = {"메뉴","수량","가격"};
	String [][] Data ;	
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable menuTable = new JTable(model);
	JScrollPane menuScroll = new JScrollPane();

	int  hotCoffeePrice[] = {3200, 3700, 3700, 3700, 3700, 0, 0, 0, 0, 0, 0};
	int  iceCoffeePrice[] = {3200, 3700, 3700, 3700, 3700, 0, 0, 0, 0, 0, 0};
	int  shakeFlatchinoPrice[] = {3900, 4300, 4300, 4800, 4800, 3900, 4300, 4300, 3700, 0, 0};

	public Main() {
		super("Ezen Cafeteria");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 563);

		launched();

		ImageIcon img = new ImageIcon("C:\\git!\\java\\Projects\\Cafe_Main\\짱구.jpg");
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
		String[] HotCoffee = {"아메리카노", "카페라떼", "카페모카", "바닐라라떼", "카푸치노", "", "", "", "", "", ""};
		for (int i = 0; i < HotCoffeeBtn.length; i++) {
			HotCoffeeBtn[i] = new JButton(HotCoffee[i]);
			panel1.add(HotCoffeeBtn[i]);				
		}
		menuTab.add("HotCoffee", panel1);

		// ICECoffeeBtn
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 4, 10, 10));	
		ICECoffeeBtn = new JButton[11];
		String[] ICECoffee = {"ICE아메리카노", "ICE카페라떼", "ICE카페모카", "ICE바닐라라떼", "ICE카푸치노", "", "", "", "", "", ""};
		for (int i = 0; i < ICECoffeeBtn.length; i++) {
			ICECoffeeBtn[i] = new JButton(ICECoffee[i]);
			panel2.add(ICECoffeeBtn[i]);
		}		
		menuTab.add("IceCoffee", panel2);

		// ShakeFlatchinoBtn
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4, 4, 10, 10));	
		ShakeFlatchinoBtn = new JButton[11];
		String[] ShakeFlatchino = {"오리진쉐이크", "딸기쉐이크", "초코쿠키쉐이크", "<html>초코묻고더블<br>쉐이크</html>", "<html>치즈가쿠키했대<br>쉐이크</html>", 
				"요커트플랫치노", "딸기플랫치노", "<html>블루베리요거트<br>플랫치노</html>", "꿀복숭아플랫치노", "", ""};
		for (int i = 0; i < ShakeFlatchinoBtn.length; i++) {
			ShakeFlatchinoBtn[i] = new JButton("<html> <center> " + ShakeFlatchino[i] + "</center> </html>");
			panel3.add(ShakeFlatchinoBtn[i]);
		}
		menuTab.add("Beverage", panel3);

		// 운영버튼
		panel4 = new JPanel();
		panel4.setBounds(26, 410, 844, 85);
		getContentPane().add(panel4);
		panel4.setLayout(new GridLayout(1, 6, 10, 10));		
		String[] operation = {"매출", "영수증", "결제", "할인", "선택취소", "전체취소"};
		JButton[] inventoryManagement = new JButton[6];
		for (int i = 0; i < inventoryManagement.length; i++) {
			inventoryManagement[i] = new JButton(operation[i]);
			panel4.add(inventoryManagement[i]);
		}

		//매출목록
		inventoryManagement[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sales();						
			}
		});

		// 결제 방식
		panel7 = new JPanel();
		panel7.setBounds(26, 294, 353, 37);
		getContentPane().add(panel7);
		panel7.setLayout(null);

		JLabel payWay = new JLabel("결제 방식");
		payWay.setFont(new Font("고딕", Font.BOLD, 15));
		payWay.setBounds(8, 7, 109, 18);
		JRadioButton cash = new JRadioButton("현금");
		cash.setBounds(125, 5, 76, 23);
		JRadioButton card = new JRadioButton("카드");
		card.setBounds(212, 5, 76, 23);
		panel7.add(payWay);
		panel7.add(cash);
		panel7.add(card);	
		ButtonGroup  group = new ButtonGroup(); 
		group.add(card);
		group.add(cash);

		//결제		
		inventoryManagement[2].addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCont = menuTable.getRowCount();		
				int pay[] = new int[rowCont];
				for(int i=0;i<rowCont;i++) {
					pay[i] = (int)menuTable.getValueAt(i, 2);
				}
				int sum = IntStream.of(pay).sum();
				tf.setText(String.valueOf(" 총 금액 : " + sum + "원"));
				tf.setFont(new Font("고딕", Font.BOLD, 15));

				if(cash.isSelected()==true) {
					int exitOptionCash = JOptionPane.showConfirmDialog(null, "현금결제 하시겠습니까?", "결제창", JOptionPane.YES_OPTION);
					if (exitOptionCash == JOptionPane.YES_OPTION) {
						Payment payment = new Payment();
						payment.payBtn.addActionListener(new ActionListener() {							
							@Override
							public void actionPerformed(ActionEvent e) {
								String str = "";
								str = payment.payMoney.getText();
								str = str.trim();
								int paymoney = 0;
								paymoney = Integer.parseInt(str);	
								if(sum <= paymoney) {
									CoffeeDAO coffeeDAO = new CoffeeDAO();
									Info info = new Info();
									for (int i = 0; i < menuTable.getRowCount(); i++) {
										coffeeDAO.coffeeadd(info);
									}									
									JOptionPane.showMessageDialog(null, "결제되었습니다", "결제창", JOptionPane.PLAIN_MESSAGE);
									payment.dispose();
									DefaultTableModel model = (DefaultTableModel)menuTable.getModel();
									model.setNumRows(0);
									tf.setText("");
								} else {
									JOptionPane.showMessageDialog(null, "돈이 부족해요!", "결제창", JOptionPane.INFORMATION_MESSAGE);
									payment.dispose();
								}
							}
						});
					} else if(card.isSelected()==true) {
						JOptionPane.showConfirmDialog(null, "카드결제 하시겠습니까?", "결제창", JOptionPane.YES_OPTION);
					}
				}	
			}
		});

		// 할인
		inventoryManagement[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				Discount discount = new Discount();
				discount.btn10.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int result = (int) (menuTable.getValueAt(menuTable.getSelectedRow(), 2));
						menuTable.setValueAt((int)(result * 0.9), menuTable.getSelectedRow(), 2);
						discount.dispose();
					}
				});
				discount.btn20.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						int result = (int) (menuTable.getValueAt(menuTable.getSelectedRow(), 2));
						menuTable.setValueAt((int)(result * 0.8), menuTable.getSelectedRow(), 2);
						discount.dispose();
					}
				});
				discount.btnFree.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						menuTable.setValueAt(0, menuTable.getSelectedRow(), 2);
						discount.dispose();
					}
				});
			}
		});

		// 선택취소
		inventoryManagement[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
				m.removeRow(menuTable.getSelectedRow());
			}
		});

		// 전체취소
		inventoryManagement[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});

		// 주문리스트
		menuTable.setRowHeight(38);
		menuScroll.setBounds(26, 24, 353, 264);
		menuScroll.setViewportView(menuTable);
		getContentPane().add(menuScroll);
		for(int i=0;i<HotCoffeeBtn.length;i++) {
			final int index =i;
			HotCoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					String menu = HotCoffee[index];
					m.addRow(new Object[]{menu,count, hotCoffeePrice[index]});
				}
			});
			ICECoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					String menu = ICECoffee[index];
					m.addRow(new Object[]{menu,count, iceCoffeePrice[index]});
				}
			});
			ShakeFlatchinoBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					String menu = ShakeFlatchino[index];
					m.addRow(new Object[]{menu,count, shakeFlatchinoPrice[index]});
				}
			});
		}

		// 총 금액
		panel6 = new JPanel();
		panel6.setBounds(26, 337, 353, 58);
		getContentPane().add(panel6);
		panel6.setLayout(null);
		tf.setBounds(0, 0, 353, 58);
		panel6.add(tf);


	}

	public static void main(String[] args) {
		Main frame = new Main();
	}
}
