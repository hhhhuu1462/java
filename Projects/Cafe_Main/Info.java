package Cafe_Main;

public class Info extends Object {

	String id;
	String pw;

	String menuCode;
	String menu;
	int price;
	String date;
	
	public String getMenuCode() {	return menuCode;}
	public void setMenuCode(String menuCode) {this.menuCode = menuCode;}
	public String getMenu() {return menu;	}
	public void setMenu(String menu) {	this.menu = menu;	}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}	
	
	public String toString() {
		return "Coffee [menuCode=" + menuCode + ", menu=" + menu + ", price=" + price + ", date =" + date +"]";
	}
	
}