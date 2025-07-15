package drink_interface;

public class Order {
	// Field
	Menu orderMenu;
	//int sum;
	
	// Constructor
	public Order() {
		
	}
	
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	// Method
	public void getInfo() {
		System.out.println("주문 메뉴     : " + getName());
		System.out.println("결제 예정 금액 : " + String.format("%,d", getTotal()) + "원");
	}
	
	// 메뉴의 이름을 반환
	public String getName() {
		return orderMenu.getName();
	}
	
	// 메뉴의 가격을 반환
	public int getTotal() {
		return orderMenu.getPrice();
	}
}
