package com.rajeshkawali.service;

import com.rajeshkawali.model.Customer;

import java.util.List;



/**
 * @author Rajesh_Kawali
 */
public interface CustomerService {

    public List<Customer> getAllCustomer();

    public Customer addCustomer(Customer customer);

    public Customer getCustomerById(Integer id);

    public String deleteCustomer(Integer id);

    public Customer updateCustomer(Integer id, Customer customer);

}
