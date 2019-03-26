package customerpublisher;

public interface CustomerPublish {
	
	public boolean addCustomer(int id,String fname,String lname , String nic , String username , String password, String contact);
	public boolean updateCustomer(int id,String fname,String lname , String nic , String username , String password, String contact);
	public boolean deleteCustomer(int id);
	public void searchCustomerById(int id);
	public void searchCustomerByAny(String field,String value);
	
	// Want to call the service from room management 
	public void checkAvailability();
	public void DisplayRoomDetails();

}
