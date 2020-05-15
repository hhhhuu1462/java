package Ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;

public class ManagerGUI {

	Frame frame;
	Panel panel[];
	// ȸ������, �̸�, Ű, ������, ����, ����, ����ǥ��
	Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
	// �̸�, Ű, ������, ����
	TextField tfName, tfHeight, tfWeight, tfAge;
	// ����, �˻�, ����, ����, �����
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
	// ȭ�� ����Ʈ
	List list;
	Checkbox chMale, chFemale;
	CheckboxGroup chGroup;

	// �⺻ �����ڿ� ȭ�� ����
	public ManagerGUI() {
		frame = new JFrame("ȸ������");
		panel = new Panel[13]; // �ǳ��� �ּҸ� ���� 1���� �迭
		for (int i = 0; i < panel.length; i++) {
			// 13���� �ǳ� ����
			panel[i] = new Panel();
		}

		// �� ����
		// Ÿ��Ʋ �� ����
		lblTitle = new Label("ȸ������", Label.CENTER);
		Font font = new Font("dialog", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(new Color(123, 54, 32));
		lblName = new Label("�� ��"); // �̸� �� ����
		lblAge = new Label("�� ��"); // ���� �� ����
		lblHeight = new Label("�� ��"); // ���� �� ����
		lblWeight = new Label("ü ��"); // ü�� �� ����
		lblSex = new Label("�� ��"); // ���� �� ����
		// ���� �� ����
		lblStatus = new Label(""); 
		lblStatus.setBackground(Color.LIGHT_GRAY);

		// �ؽ�Ʈ�ʵ� ����
		tfName = new TextField(""); // �̸� �ؽ�Ʈ�ʵ� ����
		tfHeight = new TextField(""); // Ű �ؽ�Ʈ�ʵ� ����
		tfWeight = new TextField(""); // ������ �ؽ�Ʈ�ʵ� ����
		tfAge = new TextField(""); // ���� �ؽ�Ʈ�ʵ� ����

		// ��ư ����
		btnSave = new Button("�� ��"); // ���� ��ư ����
		btnSearch = new Button("�� ��"); // �˻� ��ư ����
		btnDelete = new Button("�� ��"); // ���� ��ư ����
		btnUpdate = new Button("�� ��"); // ���� ��ư ����
		btnReset = new Button("�����"); // ����� ��ư ����

		// üũ�ڽ� ����
		chGroup = new CheckboxGroup(); // �׷�ȭ
		chMale = new Checkbox("Male", chGroup, true); // ����
		chFemale = new Checkbox("Female", chGroup, false); // ����

		list = new List(7, false); // java.awt.list

		// ������ �����ư
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});

		// list ������ Ŭ���ϸ� ȸ������ �Է� �ʵ尪 ä���
		list.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem(); // ����Ʈ �� �� ���
				StringTokenizer st = new StringTokenizer(str); // ����� �������� ���� = (str, " ")
				// GUI ���� ������� �ۼ�
				tfName.setText(st.nextToken());
				tfAge.setText(st.nextToken());
				tfWeight.setText(st.nextToken());	
				tfHeight.setText(st.nextToken());							

				String sex = st.nextToken();
				if(sex.equals("��")) { //������ �����̸�
					chMale.setState(true); // ���� üũ
				} else { // �ƴϸ�
					chFemale.setState(true); // ����üũ
				}
			}
		});

		// ȸ������ �����ϱ�
		btnSave.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "��";
				if(chMale.getState()) { sex = "��"; }
				MemberDAO dao = new MemberDAO();
				int n = dao.insert(name, age, weight, height, sex);
				lblStatus.setText(n + "���� ����Ǿ����ϴ�.");
				displayAll();
			}
		});

		// ȸ������ ������ �����ϱ�
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				MemberDAO dao = new MemberDAO();
				int n = dao.delete(name);
				lblStatus.setText(n + "���� ���ڵ尡 �����Ǿ����ϴ�.");

				displayAll();
			}
		});

		// ȸ������ ������ ���� �ϱ�
		btnUpdate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "��";
				if(chFemale.getState()) {
					sex = "��";
				}

				MemberDAO dao = new MemberDAO();
				int n = dao.update(name, age, weight, height, sex);
				lblStatus.setText(n + "���� ���ڵ尡 �����Ǿ����ϴ�");

				displayAll();
			}
		});		

		// ȸ������ ������ ��ȸ �ϱ�
		btnSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();

				MemberDAO dao = new MemberDAO();
				MemberDTO dto = null;

				try{
					dto = dao.search(name);
					lblStatus.setText("\"" + name + "\"�� �˻��ƽ��ϴ�.");
				} catch(Exception ae){
					final Dialog dialog = new Dialog(frame, "���");
					dialog.setLayout(new FlowLayout());
					dialog.setSize(250, 80);
					dialog.setTitle(ae.getMessage());
					Button btnOK = new Button("Ȯ ��");
					btnOK.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dialog.dispose();
						}
					});

					dialog.add(btnOK);
					dialog.setLocation(frame.getLocation().x + frame.getSize().width/2 - dialog.getSize().width/2,
							frame.getLocation().y + frame.getSize().height/2 - dialog.getSize().height/2);

					dialog.setVisible(true);
					lblStatus.setText("");
					return;
				}

				tfName.setText(dto.getName());
				tfAge.setText(Integer.toString(dto.getAge()));
				tfHeight.setText(Double.toString(dto.getHeight()));
				tfWeight.setText(Double.toString(dto.getWeight()));

				String sex = Character.toString(dto.getSex());
				if(sex.equals("��")){
					chFemale.setState(true);
				}else{
					chMale.setState(true);
				}
			}
		});

		// ȸ������ �Է� �ʵ� �����
		btnReset.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText(" ");
				tfAge.setText(" ");
				tfHeight.setText(" ");
				tfWeight.setText(" ");
				chGroup.setSelectedCheckbox(null);
			}
		});

	}

	// ������ ���� �޼ҵ�
	public void launchFrame(){
		panel[1].setLayout(new GridLayout(2, 1));
		panel[1].add(lblName);
		panel[1].add(lblHeight);

		panel[2].setLayout(new GridLayout(2, 1));
		panel[2].add(tfName);
		panel[2].add(tfHeight);

		// panel[1], [2]�� panel[3]�� �ֱ�
		panel[3].setLayout(new BorderLayout());
		panel[3].add(panel[1], "West");
		panel[3].add(panel[2], "Center");
		panel[3].add(new Label(""), "East");

		panel[4].setLayout(new GridLayout(2, 1));
		panel[4].add(lblAge);
		panel[4].add(lblWeight);

		panel[5].setLayout(new GridLayout(2, 1));
		panel[5].add(tfAge);
		panel[5].add(tfWeight);

		// panel[4], [5]�� panel[6]�� �ֱ�
		panel[6].setLayout(new BorderLayout());
		panel[6].add(panel[4], "West");
		panel[6].add(panel[5], "Center");
		panel[6].add(new Label(""), "East");

		// panel[3], [6]�� panel[7]�� �ֱ�
		panel[7].setLayout(new GridLayout(1,2));
		panel[7].add(panel[3]);
		panel[7].add(panel[6]);

		// ���� üũ�ڽ� add
		panel[8].add(lblSex);
		panel[8].add(chMale);
		panel[8].add(chFemale);

		// ȸ������ title, panel[7], [8] ��ġ �����ؼ� ���̾ƿ��� �ֱ�
		panel[9].setLayout(new BorderLayout());
		panel[9].add(lblTitle, "North");
		panel[9].add(panel[7], "Center");
		panel[9].add(panel[8], "South");

		// �̸�, ����, ü��, Ű, ������ ���� �� ���� �� ���̾ƿ��� �ֱ�
		panel[10].setLayout(new GridLayout(1,5));
		panel[10].setBackground(Color.black);
		panel[10].setForeground(Color.white);
		panel[10].add(new Label("�� ��   "));
		panel[10].add(new Label("�� ��   "));
		panel[10].add(new Label("ü ��  "));
		panel[10].add(new Label(" Ű    "));
		panel[10].add(new Label("�� ��   "));

		// panel[10]�� panel[10]�� ���� ����Ʈ�� ��ġ ���� �� ���̾ƿ��� �ֱ�
		panel[11].setLayout(new BorderLayout());
		panel[11].add(panel[10], "North");
		panel[11].add(list, "Center");

		// ����, �˻�, ����, ����, ����� ��ư ����
		panel[0].add(btnSave);
		panel[0].add(new Label(" ")); // ��ư ������ ���� ����
		panel[0].add(btnSearch);
		panel[0].add(new Label(" "));
		panel[0].add(btnDelete);
		panel[0].add(new Label(" "));
		panel[0].add(btnUpdate);
		panel[0].add(new Label(" "));
		panel[0].add(btnReset);

		// ���� �ǳ� ���̾ƿ��� �ֱ�
		panel[12].setLayout(new BorderLayout());
		panel[12].add(panel[9], "North"); // ȸ������, �̸�~ü�� �Է�, ���� üũ�ڽ�
		panel[12].add(panel[11], "Center"); // �̸�~���� ����Ʈ
		panel[12].add(panel[0], "South"); // ����~����� ��ư

		frame.add(panel[12], "Center");
		frame.add(lblStatus, "South"); // ���¸޼��� �� �شܿ� ����
		frame.pack();

		frame.setResizable(false); // ������ ũ�� ���� �Ұ�
		// ȭ���� ������ â�� ���۵Ǵ� ��ġ ���� : �߰��� ��ġ
		frame.setLocation(((frame.getToolkit().getScreenSize()).width-frame.getWidth())/2, ((frame.getToolkit().getScreenSize()).height-frame.getHeight())/2);
		frame.setVisible(true);

		displayAll();
	}

	// ȸ������ ����
	public void displayAll() {
		list.removeAll(); // ��ü �����
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> allData = dao.select();
		for (MemberDTO dto : allData) {
			String name = dto.getName();
			int age = dto.getAge();
			double height = dto.getHeight();
			double weight = dto.getWeight();
			char sex = dto.getSex();
			list.add(name + "            " + age + "                 " + weight + "             " + height + "                  " + sex);
		}
	}

	public static void main(String[] args) {
		// �����ڷ� �����Ӱ� ������Ʈ ����
		ManagerGUI managerGUI = new ManagerGUI(); 
		managerGUI.launchFrame();
	}

}
