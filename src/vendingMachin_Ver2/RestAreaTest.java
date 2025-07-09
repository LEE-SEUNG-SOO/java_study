package vendingMachin_Ver2;

public class RestAreaTest {

	public static void main(String[] args) {
		User[] users = new User[3];
		users[0] = new User();
		users[1] = new User("이순신");
		users[2] = new User("김유신");
		
		RestArea restArea = new RestArea();
		
		restArea.setName("강남");
		restArea.setVendingMachine(new VendingMachine());
		restArea.welcome();
		
		for(int i = 0; i < users.length; i ++) {
			restArea.setUser(users[i]);
			restArea.machineStart();
		}
		
	}

}
