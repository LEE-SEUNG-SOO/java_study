package vendingMachin_Ver2;

public class RestArea {
	// Field
	String name;
	User user;
	VendingMachine machine;
	
	// Constructor
	public RestArea() {
	}
	
	// Method
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public void setVendingMachine(VendingMachine machine) {
		this.machine = machine;
	}
	public VendingMachine getVendingMachine() {
		return machine;
	}
	
	public void welcome() {
		System.out.println("================================================");
		System.out.println("\t" + name + " 휴게소에 오신것을 환영합니다.");
		System.out.println("================================================");
	}
	
	public void machineStart() {
		machine.setUser(user);
		machine.viewMenu(machine.menuList);
		machine.acceptCoin();
		machine.orderMenu();
	}
}
