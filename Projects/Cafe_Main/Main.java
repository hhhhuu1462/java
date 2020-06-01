package Cafe_Main;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.stream.IntStream;

public class Main extends JFrame { 
	private static final long serialVersionUID = -2979632338990090898L;

	static JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
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
	
	String[] HotCoffee = {"아메리카노", "카페라떼", "카페모카", "바닐라라떼", "카푸치노", "", "", "", "", "", ""};
	String[] ICECoffee = {"ICE 아메리카노", "ICE 카페라떼", "ICE 카페모카", "ICE 바닐라라떼", "ICE 카푸치노", "", "", "", "", "", ""};
	String[] ShakeFlatchino = {"오리진 쉐이크", "딸기 쉐이크", "초코쿠키 쉐이크", "초코묻고더블 쉐이크", "치즈가쿠키했대 쉐이크", 
			"요거트 플랫치노", "딸기 플랫치노", "블루베리요거트 플랫치노", "꿀복숭아 플랫치노", "", ""};

	int  hotCoffeePrice[] = {3200, 3700, 3700, 3700, 3700, 0, 0, 0, 0, 0, 0};
	int  iceCoffeePrice[] = {3200, 3700, 3700, 3700, 3700, 0, 0, 0, 0, 0, 0};
	int  shakeFlatchinoPrice[] = {3900, 4300, 4300, 4800, 4800, 3900, 4300, 4300, 3700, 0, 0};

	public Main() {
		super("Ezen Cafeteria");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 563);
		
		launched();
		createMenu();		

		ImageIcon img = new ImageIcon("C:\\git!\\java\\Projects\\Cafe_Main\\짱구.jpg");
		setIconImage(img.getImage());
		setResizable(false);
		setVisible(true);
	}

	public void createMenu() {
		JMenuBar mb = new JMenuBar(); 
		JMenuItem [] menuItem = new JMenuItem [1];
		String[] itemTitle = {"Exit"};
		JMenu fileMenu = new JMenu("File");		

		FileMenuActionListener fileMenuActionListener = new FileMenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(fileMenuActionListener); 
			fileMenu.add(menuItem[i]);
		}		
		mb.add(fileMenu);
		setJMenuBar(mb);		

		JMenu editMenu = new JMenu("Edit");
		JMenu tabMenu = new JMenu("Tab");
		editMenu.add(tabMenu);
		JMenu hotCoffeeMenu = new JMenu("HotCoffee");
		JMenu iceCoffeeMenu = new JMenu("IceCoffee");
		JMenu shakeFlatchinoMenu = new JMenu("ShakeFlatchino");
		tabMenu.add(hotCoffeeMenu);
		tabMenu.add(iceCoffeeMenu);
		tabMenu.add(shakeFlatchinoMenu);

		JMenuItem [] editItem = new JMenuItem[3];
		String[] hotCoffeeEdit = {"추가", "수정", "삭제"};
		String[] iceCoffeeEdit = {"추가", "수정", "삭제"};
		String[] shakeFlatchinoEdit = {"추가", "수정", "삭제"};
		EditMenuActionListener editMenuActionListener = new EditMenuActionListener();
		for (int i = 0; i < editItem.length; i++) {
			editItem[i] = new JMenuItem(hotCoffeeEdit[i]); 
			editItem[i].addActionListener(editMenuActionListener); 
			hotCoffeeMenu.add(editItem[i]);
		}		
		for (int i = 0; i < editItem.length; i++) {
			editItem[i] = new JMenuItem(iceCoffeeEdit[i]); 
			editItem[i].addActionListener(editMenuActionListener); 
			iceCoffeeMenu.add(editItem[i]);
		}		
		for (int i = 0; i < editItem.length; i++) {
			editItem[i] = new JMenuItem(shakeFlatchinoEdit[i]); 
			editItem[i].addActionListener(editMenuActionListener); 
			shakeFlatchinoMenu.add(editItem[i]);
		}		

		mb.add(editMenu);
	}

	// file 메뉴바
	class FileMenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Exit" :
				System.exit(0);
				break;
			}
		}
	}

	// edit 메뉴바
	class EditMenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "추가" :
				for (int i = 0; i < HotCoffeeBtn.length; i++) {
					if(HotCoffeeBtn[i].equals("")) {

					}
				}
				break;
			case "수정" :
			case "삭제" :
				String delete = (String) JOptionPane.showInputDialog("삭제할 메뉴를 적어주세요");
				CoffeeDAO coffeeDAO = new CoffeeDAO();
				Info info = new Info();
				String menu = delete;
				try {
					int n = coffeeDAO.delete(menu);
					for (int i = 0; i < HotCoffeeBtn.length; i++) {
						if(HotCoffeeBtn[i].getText().equals(delete)) {
							HotCoffeeBtn[i].setText("");
							hotCoffeePrice[i]=0;
							HotCoffee[i] = "";											
						}
					}
					for (int i = 0; i < ICECoffeeBtn.length; i++) {
						if(ICECoffeeBtn[i].getText().equals(delete)) {
							ICECoffeeBtn[i].setText("");
							iceCoffeePrice[i]=0;
							ICECoffee[i] = "";											
						}
					}
					for (int i = 0; i < ShakeFlatchinoBtn.length; i++) {
						if(ShakeFlatchinoBtn[i].getText().equals(delete)) {
							ShakeFlatchinoBtn[i].setText("");
							shakeFlatchinoPrice[i]=0;
							ShakeFlatchino[i] = "";											
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public void launched() {
		getContentPane().setLayout(null);
		menuTab.setBounds(394, 24, 476, 371);
		getContentPane().add(menuTab);

		// HotCoffeeBtn
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 4, 10, 10));		
		HotCoffeeBtn = new JButton[11];
		for (int i = 0; i < HotCoffeeBtn.length; i++) {
			HotCoffeeBtn[i] = new JButton(HotCoffee[i]);
			panel1.add(HotCoffeeBtn[i]);		
		}
		menuTab.add("HotCoffee", panel1);

		// ICECoffeeBtn
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 4, 10, 10));	
		ICECoffeeBtn = new JButton[11];
		
		for (int i = 0; i < ICECoffeeBtn.length; i++) {
			ICECoffeeBtn[i] = new JButton(ICECoffee[i]);
			panel2.add(ICECoffeeBtn[i]);
		}		
		menuTab.add("IceCoffee", panel2);

		// ShakeFlatchinoBtn
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4, 4, 10, 10));	
		ShakeFlatchinoBtn = new JButton[11];
		
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
										SimpleDateFormat format2 = new SimpleDateFormat ("yyyy년 MM월dd일 HH시mm분ss초");
										String format_time2 = format2.format (System.currentTimeMillis());
										
										String menucode = (String) menuTable.getValueAt(i, 0);	
										String menu = (String) menuTable.getValueAt(i, 0);		
										int price = (int) menuTable.getValueAt(i, 2);
										String ordertime = format_time2;

										int n = coffeeDAO.coffeeadd(menucode, menu, price, ordertime);
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
		menuTable.getColumn(ColName[0]).setPreferredWidth(140);
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
					if(menu.equals("")) {
						m.removeRow(m.getRowCount()-1);				
					}
				}
			});
			ICECoffeeBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					String menu = ICECoffee[index];
					m.addRow(new Object[]{menu,count, iceCoffeePrice[index]});
					if(menu.equals("")) {
						m.removeRow(m.getRowCount()-1);				
					}
				}
			});
			ShakeFlatchinoBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)menuTable.getModel();
					String menu = ShakeFlatchino[index];
					m.addRow(new Object[]{menu,count, shakeFlatchinoPrice[index]});
					if(menu.equals("")) {
						m.removeRow(m.getRowCount()-1);				
					}
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