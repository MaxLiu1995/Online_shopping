package onlineShop1.dao;

import onlineShop1.model.Customer;
//data access object
public interface CustomerDao {
 
 void addCustomer(Customer customer);
 Customer getCustomerByUserName(String userName);
}
