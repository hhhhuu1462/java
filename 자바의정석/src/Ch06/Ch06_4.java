package Ch06;

public class Ch06_4 {

	public static void main(String args[]) {
		
		Student s = new Student();
		
		s.name = "ȫ�浿"; 
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("�̸� :"+s.name); 
		System.out.println("���� :"+s.getTotal()); 
		System.out.println("��� :"+s.getAverage()); 
		
		System.out.println();
		
		Student s1 = new Student("ȫ�浿",1,1,100,60,76); 
		System.out.println(s1.info());
		
	}

}
