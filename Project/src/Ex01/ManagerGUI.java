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
	// 회원관리, 이름, 키, 몸무게, 성별, 나이, 상태표시
	Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
	// 이름, 키, 몸무게, 나이
	TextField tfName, tfHeight, tfWeight, tfAge;
	// 저장, 검색, 삭제, 수정, 지우기
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
	// 화면 리스트
	List list;
	Checkbox chMale, chFemale;
	CheckboxGroup chGroup;

	// 기본 생성자에 화면 구현
	public ManagerGUI() {
		frame = new JFrame("회원관리");
		panel = new Panel[13]; // 판넬의 주소를 담을 1차원 배열
		for (int i = 0; i < panel.length; i++) {
			// 13개의 판넬 생성
			panel[i] = new Panel();
		}

		// 라벨 생성
		// 타이틀 라벨 생성
		lblTitle = new Label("회원관리", Label.CENTER);
		Font font = new Font("dialog", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(new Color(123, 54, 32));
		lblName = new Label("이 름"); // 이름 라벨 생성
		lblAge = new Label("나 이"); // 나이 라벨 생성
		lblHeight = new Label("신 장"); // 신장 라벨 생성
		lblWeight = new Label("체 중"); // 체중 라벨 생성
		lblSex = new Label("성 별"); // 성별 라벨 생성
		// 상태 라벨 생성
		lblStatus = new Label(""); 
		lblStatus.setBackground(Color.LIGHT_GRAY);

		// 텍스트필드 생성
		tfName = new TextField(""); // 이름 텍스트필드 생성
		tfHeight = new TextField(""); // 키 텍스트필드 생성
		tfWeight = new TextField(""); // 몸무게 텍스트필드 생성
		tfAge = new TextField(""); // 나이 텍스트필드 생성

		// 버튼 생성
		btnSave = new Button("저 장"); // 저장 버튼 생성
		btnSearch = new Button("검 색"); // 검색 버튼 생성
		btnDelete = new Button("삭 제"); // 삭제 버튼 생성
		btnUpdate = new Button("수 정"); // 수정 버튼 생성
		btnReset = new Button("지우기"); // 지우기 버튼 생성

		// 체크박스 생성
		chGroup = new CheckboxGroup(); // 그룹화
		chMale = new Checkbox("Male", chGroup, true); // 남자
		chFemale = new Checkbox("Female", chGroup, false); // 여자

		list = new List(7, false); // java.awt.list

		// 프레임 종료버튼
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});

		// list 아이템 클릭하면 회원정보 입력 필드값 채우기
		list.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem(); // 리스트 한 줄 얻기
				StringTokenizer st = new StringTokenizer(str); // 곻백을 기준으로 나눔 = (str, " ")
				// GUI 설정 순서대로 작성
				tfName.setText(st.nextToken());
				tfAge.setText(st.nextToken());
				tfWeight.setText(st.nextToken());	
				tfHeight.setText(st.nextToken());							

				String sex = st.nextToken();
				if(sex.equals("남")) { //성별이 남자이면
					chMale.setState(true); // 남자 체크
				} else { // 아니면
					chFemale.setState(true); // 여자체크
				}
			}
		});

		// 회원정보 저장하기
		btnSave.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "여";
				if(chMale.getState()) { sex = "남"; }
				MemberDAO dao = new MemberDAO();
				int n = dao.insert(name, age, weight, height, sex);
				lblStatus.setText(n + "개가 저장되었습니다.");
				displayAll();
			}
		});

		// 회원정보 데이터 삭제하기
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				MemberDAO dao = new MemberDAO();
				int n = dao.delete(name);
				lblStatus.setText(n + "개의 레코드가 삭제되었습니다.");

				displayAll();
			}
		});

		// 회원정보 데이터 수정 하기
		btnUpdate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "남";
				if(chFemale.getState()) {
					sex = "여";
				}

				MemberDAO dao = new MemberDAO();
				int n = dao.update(name, age, weight, height, sex);
				lblStatus.setText(n + "개의 레코드가 수정되었습니다");

				displayAll();
			}
		});		

		// 회원정보 데이터 조회 하기
		btnSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();

				MemberDAO dao = new MemberDAO();
				MemberDTO dto = null;

				try{
					dto = dao.search(name);
					lblStatus.setText("\"" + name + "\"이 검색됐습니다.");
				} catch(Exception ae){
					final Dialog dialog = new Dialog(frame, "경고");
					dialog.setLayout(new FlowLayout());
					dialog.setSize(250, 80);
					dialog.setTitle(ae.getMessage());
					Button btnOK = new Button("확 인");
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
				if(sex.equals("여")){
					chFemale.setState(true);
				}else{
					chMale.setState(true);
				}
			}
		});

		// 회원정보 입력 필드 지우기
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

	// 프레임 지정 메소드
	public void launchFrame(){
		panel[1].setLayout(new GridLayout(2, 1));
		panel[1].add(lblName);
		panel[1].add(lblHeight);

		panel[2].setLayout(new GridLayout(2, 1));
		panel[2].add(tfName);
		panel[2].add(tfHeight);

		// panel[1], [2]를 panel[3]에 넣기
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

		// panel[4], [5]를 panel[6]에 넣기
		panel[6].setLayout(new BorderLayout());
		panel[6].add(panel[4], "West");
		panel[6].add(panel[5], "Center");
		panel[6].add(new Label(""), "East");

		// panel[3], [6]을 panel[7]에 넣기
		panel[7].setLayout(new GridLayout(1,2));
		panel[7].add(panel[3]);
		panel[7].add(panel[6]);

		// 성별 체크박스 add
		panel[8].add(lblSex);
		panel[8].add(chMale);
		panel[8].add(chFemale);

		// 회원관리 title, panel[7], [8] 위치 선정해서 레이아웃에 넣기
		panel[9].setLayout(new BorderLayout());
		panel[9].add(lblTitle, "North");
		panel[9].add(panel[7], "Center");
		panel[9].add(panel[8], "South");

		// 이름, 나이, 체중, 키, 성별에 대한 라벨 지정 후 레이아웃에 넣기
		panel[10].setLayout(new GridLayout(1,5));
		panel[10].setBackground(Color.black);
		panel[10].setForeground(Color.white);
		panel[10].add(new Label("이 름   "));
		panel[10].add(new Label("나 이   "));
		panel[10].add(new Label("체 중  "));
		panel[10].add(new Label(" 키    "));
		panel[10].add(new Label("성 별   "));

		// panel[10]과 panel[10]에 대한 리스트의 위치 선정 후 레이아웃에 넣기
		panel[11].setLayout(new BorderLayout());
		panel[11].add(panel[10], "North");
		panel[11].add(list, "Center");

		// 저장, 검색, 삭제, 수정, 지우기 버튼 생성
		panel[0].add(btnSave);
		panel[0].add(new Label(" ")); // 버튼 사이의 공백 지정
		panel[0].add(btnSearch);
		panel[0].add(new Label(" "));
		panel[0].add(btnDelete);
		panel[0].add(new Label(" "));
		panel[0].add(btnUpdate);
		panel[0].add(new Label(" "));
		panel[0].add(btnReset);

		// 최종 판넬 레이아웃에 넣기
		panel[12].setLayout(new BorderLayout());
		panel[12].add(panel[9], "North"); // 회원관리, 이름~체중 입력, 성별 체크박스
		panel[12].add(panel[11], "Center"); // 이름~성별 리스트
		panel[12].add(panel[0], "South"); // 저장~지우기 버튼

		frame.add(panel[12], "Center");
		frame.add(lblStatus, "South"); // 상태메세지 라벨 밑단에 지정
		frame.pack();

		frame.setResizable(false); // 프레임 크기 조절 불가
		// 화면이 위도우 창에 시작되는 위치 지정 : 중간에 위치
		frame.setLocation(((frame.getToolkit().getScreenSize()).width-frame.getWidth())/2, ((frame.getToolkit().getScreenSize()).height-frame.getHeight())/2);
		frame.setVisible(true);

		displayAll();
	}

	// 회원정보 보기
	public void displayAll() {
		list.removeAll(); // 전체 지우기
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
		// 생성자로 프레임과 컴포넌트 생성
		ManagerGUI managerGUI = new ManagerGUI(); 
		managerGUI.launchFrame();
	}

}
