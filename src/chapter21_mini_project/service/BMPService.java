package chapter21_mini_project.service;

public interface BMPService {
	public boolean login(String name, String phone);
	public void menuGuestInfo();
	public void menuCartItemList();
	public void menuCartClear();
	public void menuCartAddItem();
	public void menuCartRemoveItemCount();
	public void menuCartRemoveItem();
	public void menuCartBill();
	public void menuExit();
}
