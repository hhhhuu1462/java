package Chapter7;

class Robot {}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("���� ��ϴ�."); 
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�뷡�� �մϴ�."); 
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("�׸��� �׸��ϴ�."); 
	}
}

public class Ex18 {

	public static void action(Robot r) {
		if (r instanceof DanceRobot) {
			DanceRobot dr = (DanceRobot) r;
			dr.dance();
		} else if (r instanceof SingRobot) {
			SingRobot singRobot = (SingRobot) r;
			singRobot.sing();
		} else if(r instanceof DrawRobot) {
			DrawRobot drawRobot = (DrawRobot) r;
			drawRobot.draw();
		}
	}
	
	public static void main(String[] args) {

		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
		for(int i=0; i< arr.length;i++)
			action(arr[i]);

	} // main


}
