package Ex04;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEx extends JFrame{

	public MenuEx() {
		setTitle("�޴������");
		//1�ܰ� �޴��ٸ����
		JMenuBar mb = new JMenuBar();
		//2�ܰ� �޴������
		JMenu screenMenu = new JMenu("Screen");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu projectMenu = new JMenu("Project");
		JMenu runMenu = new JMenu("Run");
		//3�ܰ� �޴��� �޴��ٿ� ���̱�
		mb.add(screenMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(projectMenu);
		mb.add(runMenu);

		//5�ܰ� �޴������� ����� (���� ������ ���) ���� �޴��� ���� ��
		JMenu  loadMenu = new JMenu("Load");
		JMenu   cMenu = new JMenu("c:");
		JMenuItem dMenu = new JMenuItem("d:");
		JMenuItem useMenu = new JMenuItem("usb");
		JMenuItem textMenuItem1 = new JMenuItem("text");
		JMenuItem movieMenu = new JMenuItem("������");


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

		//4�ܰ� �޴��ٸ� �����ӿ� ����
		setJMenuBar(mb);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}

}