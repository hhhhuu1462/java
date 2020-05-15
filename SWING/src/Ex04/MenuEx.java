package Ex04;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEx extends JFrame{

	public MenuEx() {
		setTitle("메뉴만들기");
		//1단계 메뉴바만들기
		JMenuBar mb = new JMenuBar();
		//2단계 메뉴만들기
		JMenu screenMenu = new JMenu("Screen");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu projectMenu = new JMenu("Project");
		JMenu runMenu = new JMenu("Run");
		//3단계 메뉴를 메뉴바에 붙이기
		mb.add(screenMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(projectMenu);
		mb.add(runMenu);

		//5단계 메뉴아이템 만들기 (제일 마지막 명령) 하위 메뉴가 없는 것
		JMenu  loadMenu = new JMenu("Load");
		JMenu   cMenu = new JMenu("c:");
		JMenuItem dMenu = new JMenuItem("d:");
		JMenuItem useMenu = new JMenuItem("usb");
		JMenuItem textMenuItem1 = new JMenuItem("text");
		JMenuItem movieMenu = new JMenuItem("동영상");


		JMenuItem  hideMenuItem = new JMenuItem("Hide");
		JMenuItem  reshowMenuItem = new JMenuItem("ReShow");
		JMenuItem  exitMenuItem = new JMenuItem("Exit");

		JMenu      copyMenu = new JMenu("Copy");//text img
		JMenuItem  textMenuItem = new JMenuItem("Text");
		JMenuItem  imageMenuItem = new JMenuItem("image");

		JMenuItem  pasteMenuItem = new JMenuItem("Paste");
		JMenuItem  moveMenuItem = new JMenuItem("Move");
		JMenuItem  undoMenuItem = new JMenuItem("Undo");

		screenMenu.add(loadMenu);
		loadMenu.add(cMenu);
		loadMenu.add(dMenu);
		loadMenu.add(useMenu);
		cMenu.add(textMenuItem1);
		cMenu.add(movieMenu);

		screenMenu.add(hideMenuItem);
		screenMenu.add(reshowMenuItem);
		screenMenu.add(exitMenuItem);

		editMenu.add(copyMenu);
		copyMenu.add(textMenuItem);
		copyMenu.add(imageMenuItem);

		editMenu.add(pasteMenuItem);
		editMenu.add(moveMenuItem);
		editMenu.add(undoMenuItem);

		//4단계 메뉴바를 프레임에 부착
		setJMenuBar(mb);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}

}