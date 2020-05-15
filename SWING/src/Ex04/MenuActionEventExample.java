package Ex04;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuActionEventExample extends JFrame {

	JLabel imgLabel = new JLabel(); // 빈 레이블

	MenuActionEventExample() {
		setTitle("Menu에 Action 리스너 만들기 예제");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(250,200); setVisible(true);
	}

	void createMenu() {
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");

		MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(listener); // 메뉴 아이템에 리스너 연결
			screenMenu.add(menuItem[i]); // 스크린메뉴에 메뉴아이템 붙이기
		}

		mb.add(screenMenu);
		setJMenuBar(mb); // 메뉴바를 프레임에 부착
	}

	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Load" :
				if(imgLabel.getIcon() != null) {
					return;
				}
				imgLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\image\\img.jpg"));
				break;
			case "Hide" :
				imgLabel.setVisible(false);
				break;
			case "ReShow" :
				imgLabel.setVisible(true);
				break;
			case "Exit" :
				System.exit(0);
				break;
			}
		}

	}

	public static void main(String [] args) {
		new MenuActionEventExample();
	}
}