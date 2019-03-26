package customerpublisher;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import lk.sliit.sa.osgi.persistence.CustomerFactoryImpl;
import lk.sliit.sa.osgi.persistence.PersistenceServiceImpl;
import lk.sliit.sa.osgi.persistence.service.Customer;
import lk.sliit.sa.osgi.persistence.service.Factory;

public class CustomerPublisherImpl implements CustomerPublish{

	@Override
	public boolean addCustomer(int id, String fname, String lname, String nic, String username, String password,String contact) {
		boolean Success = false;
		Customer cusotmer = new Customer();
		cusotmer.setId(id);
		cusotmer.setFname(fname);
		cusotmer.setLname(lname);
		cusotmer.setNic(nic);
		cusotmer.setUsername(username);
		cusotmer.setPassword(password);
		cusotmer.setContact(contact);
		try {
			
			System.out.println("Adding Cusotmer");
			PersistenceServiceImpl impl = new PersistenceServiceImpl();
			CustomerFactoryImpl fc = (CustomerFactoryImpl) impl.getFactory(Factory.CUSTOMERS);
			fc.add(cusotmer);
			Success = true;
			
		} catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		return Success;
	}

	@Override
	public boolean updateCustomer(int id, String fname, String lname, String nic, String username, String password,
			String contact) {
		boolean Success = false;
		Customer cusotmer = new Customer();
		cusotmer.setId(id);
		cusotmer.setFname(fname);
		cusotmer.setLname(lname);
		cusotmer.setNic(nic);
		cusotmer.setUsername(username);
		cusotmer.setPassword(password);
		cusotmer.setContact(contact);
		try {
			
			System.out.println("Adding Cusotmer");
			PersistenceServiceImpl impl = new PersistenceServiceImpl();
			CustomerFactoryImpl fc = (CustomerFactoryImpl) impl.getFactory(Factory.CUSTOMERS);
			fc.add(cusotmer);
			Success = true;
			
		} catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		return Success;
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean success = false;
		try {
			System.out.println("Updating Cusotmer Details");
			PersistenceServiceImpl imp = new PersistenceServiceImpl();
			CustomerFactoryImpl customer = (CustomerFactoryImpl) imp.getFactory(Factory.CUSTOMERS);
			customer.deleteById(id);
			success = true;
			
		} catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void searchCustomerById(int id) {
		try {
			PersistenceServiceImpl imp = new PersistenceServiceImpl();
			CustomerFactoryImpl customer = (CustomerFactoryImpl) imp.getFactory(Factory.CUSTOMERS);
			Optional<Customer> customerOptional = customer.findById(id);
			
			if(customerOptional.isPresent()){
				Customer cus = customerOptional.get();
				System.out.println("**** Details of Cusotmer Id "+ id +" ****");
			    System.out.println("Cusotmer ID:     "+cus.getId());
				System.out.println("Customer First Name:   "+cus.getFname());
			    System.out.println("Cusotmer Last Name : "+cus.getLname());
			    System.out.println("Customer Nic:     "+cus.getNic());
				System.out.println("Cusotmer Username:   "+cus.getUsername());
			    System.out.println("Cusotmer Password: "+cus.getPassword());
			    System.out.println("Customer Contact: "+cus.getContact());
			    System.out.println("******************************************");
			}
			else {
			    System.out.println("No Customer Details were found to the entered Customer ID");
			}
		} catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}	
		
		
	}

	@Override
	public void searchCustomerByAny(String field, String value) {
		try {
			PersistenceServiceImpl imp = new PersistenceServiceImpl();
			CustomerFactoryImpl customer = (CustomerFactoryImpl) imp.getFactory(Factory.CUSTOMERS);
			Optional<List<Customer>> customerOptional = customer.findAll();
			
			if(customerOptional.isPresent()) {
				System.out.println("******************Customer Details***************");
				List<Customer> cus = customerOptional.get();
				Iterator<Customer> cusIterator = cus.iterator();
				while(cusIterator.hasNext()) {
					Customer cust = cusIterator.next();
				    System.out.println("Cusotmer ID:     "+cust.getId());
					System.out.println("Customer First Name:   "+cust.getFname());
				    System.out.println("Cusotmer Last Name : "+cust.getLname());
				    System.out.println("Customer Nic:     "+cust.getNic());
					System.out.println("Cusotmer Username:   "+cust.getUsername());
				    System.out.println("Cusotmer Password: "+cust.getPassword());
				    System.out.println("Customer Contact: "+cust.getContact());
				    System.out.println("******************************************");
				}
			}
			else {
			    System.out.println("No data found");
			}
			
		} catch (Exception e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		
	}

	@Override
	public void checkAvailability() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayRoomDetails() {
		// TODO Auto-generated method stub
		
	}

}
