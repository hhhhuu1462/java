package Chapter6;

// Ex05

public class Student {
	// 실행결과 : 홍길동, 1, 1, 100, 60, 76, 236, 78.7
	// 클래스에 생성자와 info() 추가
	
	String name;
	int num1, num2, num3, num4, num5, num6;
	double num7;
	
	public Student(String name, int num1, int num2, int num3, int num4, int num5) {
		this.name = name;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
	}
	
	int getTotal() {
		return num3 + num4 + num5;
	}
	
	float getAverage() {
		return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
	}
	
	String info() {
		return name + ", " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + getTotal() + ", " + getAverage(); 
	}
	
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		
		System.out.println(s.info());
	}
	
}
