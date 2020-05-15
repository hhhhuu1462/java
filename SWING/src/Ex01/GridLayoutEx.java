package Ex01;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx extends JFrame {

	public GridLayoutEx() {
		
		super("GridLayout 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		// 1x10의 GridLayout 배치관리자
		
		contentPane.setLayout(new GridLayout(6, 5));
		
		for(int i=97; i<123; i++) { // 10개의 버튼 부착
			String text = Character.toString((char)i); // i를 문자열로 변환
			JButton button = new JButton(text);
			contentPane.add(button); // 컨텐트팬에 버튼 부착
		}
		
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {		
		new GridLayoutEx();
	}

}
