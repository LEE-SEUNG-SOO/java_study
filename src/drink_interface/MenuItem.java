package drink_interface;
/*
 * 메뉴 표시에 필요한 정보
 */
public class MenuItem implements Menu{
	// Field
	int no;
	int price;
	String name;
	
	// Constructor
	public MenuItem() {
		this(0,"",0);
	}
	public MenuItem(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	// Method
	@Override
	public int getNo() {
		return no;
	}
	
	@Override
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
}
