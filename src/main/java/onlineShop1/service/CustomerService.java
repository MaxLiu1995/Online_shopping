package onlineShop1.service;

import onlineShop1.model.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);

    Customer getCustomerByUserName(String userName);
}
