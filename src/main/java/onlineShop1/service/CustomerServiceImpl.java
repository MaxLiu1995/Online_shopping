package onlineShop1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop1.dao.CustomerDao;
import onlineShop1.service.CustomerService;
import onlineShop1.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {   	
      	 customerDao.addCustomer(customer);
       }

    public Customer getCustomerByUserName(String userName) {
      	 return customerDao.getCustomerByUserName(userName);
     }
 }

    