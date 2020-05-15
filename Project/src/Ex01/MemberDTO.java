package Ex01;

public class MemberDTO {
	// ÇÊµå 
	String name;
	int age;
	double height;
	double weight;
	char sex;
	
	// getter(), setter()
	public String getName() {return name;}
	public int getAge() {return age;}
	public double getHeight() {return height;}
	public double getWeight() {return weight;}
	public char getSex() {return sex;}
	
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setHeight(double height) {this.height = height;}
	public void setWeight(double weight) {this.weight = weight;}
	public void setSex(char sex) {this.sex = sex;}
}
