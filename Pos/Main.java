package aa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(392, 10, 480, 492);
		contentPane.add(tabbedPane);
		tabbedPane.add("HotCoffee", new JTextArea());
		tabbedPane.add("IceCoffee", new JTextArea());
		tabbedPane.add("tea", new JTextArea());
		tabbedPane.add("Shake", new JTextArea());
		tabbedPane.add("Bubble", new JTextArea());
		tabbedPane.add("Add", new JTextArea());
		
		JTextArea textArea = new JTextArea();
				
		JList list = new JList();
		list.setBounds(12, 10, 368, 384);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(12, 404, 368, 98);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
