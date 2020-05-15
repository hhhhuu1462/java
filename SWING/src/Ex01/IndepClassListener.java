package Ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame {

	public IndepClassListener() {
		setTitle("Action이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action"); // 버튼 컴포넌트 만들기
		//		btn.addActionListener(new ActionListener() {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				JButton b = (JButton)e.getSource();
		//				if(b.getText().equals("Action")) {
		//					b.setText("액션");
		//				}
		//				else {
		//					b.setText("Action");
		//				}
		//				// AnonymousClassListener나
		//				// JFrame의 멤버를 호출 가능
		//				setTitle(b.getText());
		//			}
		//		});

		btn.addActionListener(new MyActionListener()); 
		c.add(btn);

		setSize(250, 120);
		setVisible(true);

	}
	private class MyActionListener  implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			// InnerClassListener나 JFrame의 멤버 호출 가능
			setTitle(b.getText()); // 프레임 타이틀에 버튼문자열 출력
		}
	}

	public static void main(String[] args) {
		new IndepClassListener();
	}

}

// 이벤트의 리스너 작성
