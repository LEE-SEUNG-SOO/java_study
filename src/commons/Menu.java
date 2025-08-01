package commons;
/*
 * 메뉴 표시에 필요한 정보
 */
public class Menu {
	// Field
	int no;
	int price;
	String name;
	
	// Constructor
	public Menu() {
		this(0,"",0);
	}
	public Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	// Method
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
