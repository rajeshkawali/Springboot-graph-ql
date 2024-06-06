package com.rajeshkawali.service;

import com.rajeshkawali.model.Customer;
import com.rajeshkawali.model.SmoothiePreference;
import com.rajeshkawali.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Rajesh_Kawali
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public static final String CLASS_NAME = CustomerServiceImpl.class.getName();

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        String _function = ".getAllCustomer";
        log.info(CLASS_NAME + _function + "::ENTER");
        List<Customer> customerList = new ArrayList<>();
        try {
            customerRepository.findAll().forEach(customer -> customerList.add(customer));
            log.debug(CLASS_NAME + _function + "::Response size is: {}", customerList.size());
        } catch (Exception e) {
            log.error(CLASS_NAME + _function + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + _function + "::EXIT");
        return customerList;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        String _function = ".addCustomer";
        log.info(CLASS_NAME + _function + "::ENTER");
        Customer customerSaved = null;
        try {
            customerSaved = customerRepository.save(customer);
            log.debug(CLASS_NAME + _function + "::Customer SuccessFully added to the DB : {}", customerSaved);
        } catch (Exception e) {
            log.error(CLASS_NAME + _function + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + _function + "::EXIT");
        return customerSaved;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String _function = ".getCustomerById";
        log.info(CLASS_NAME + _function + "::ENTER");
        Customer customer = null;
        try {
            Optional<Customer> customerOptional = customerRepository.findById(id);
            if (customerOptional.isPresent()) {
                customer = customerOptional.get();
                log.debug(CLASS_NAME + _function + "::Response is: {}", customer);
            }
        } catch (Exception e) {
            log.error(CLASS_NAME + _function + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + _function + "::EXIT");
        return customer;
    }

    @Override
    public String deleteCustomer(Integer id) {
        String _function = ".deleteCustomer";
        log.info(CLASS_NAME + _function + "::ENTER");
        String result = null;
        try {
            Customer customerDetails = getCustomerById(id);
            if (customerDetails != null) {
                customerRepository.deleteById(id);
                result = "Customer SuccessFully Deleted";
                log.debug(CLASS_NAME + _function + "::Deleted status response is: {}", result);
            }
        } catch (Exception e) {
            log.error(CLASS_NAME + _function + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + _function + "::EXIT");
        return result;
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customerToUpdate) {
        String _function = ".updateCustomer";
        log.info(CLASS_NAME + _function + "::ENTER");
        Customer updatedCustomer = null;
        try {
            Customer customerDetails = getCustomerById(id);
            if (customerDetails != null) {
                updatedCustomer = customerRepository.save(customerToUpdate);
                log.debug(CLASS_NAME + _function + "::Response is: {}", updatedCustomer);
            }
        } catch (Exception e) {
            log.error(CLASS_NAME + _function + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + _function + "::EXIT");
        return updatedCustomer;
    }

    @PostConstruct
    private void init() {
        List<Customer> customers = List.of(
                new Customer(1, "John", "Doe", SmoothiePreference.STRAWBERRY_BANANA, 1234567890L),
                new Customer(2, "Rajesh", "Kawali", SmoothiePreference.MANGO_PINEAPPLE, 2345678901L),
                new Customer(3, "Keshav", "Koli", SmoothiePreference.BLUEBERRY_SPINACH, 3456789012L),
                new Customer(4, "Bob", "Brown", SmoothiePreference.CHOCOLATE_PEANUT_BUTTER, 4567890123L),
                new Customer(5, "Kiran", "Kamble", SmoothiePreference.GREEN_DETOX, 5678901234L),
                new Customer(6, "Dave", "Miller", SmoothiePreference.AVOCADO_CUCUMBER, 6789012345L),
                new Customer(7, "Eve", "Wilson", SmoothiePreference.PEACH_GINGER, 7890123456L),
                new Customer(8, "Mahesh", "Suryavamshi", SmoothiePreference.MIXED_BERRY, 8901234567L),
                new Customer(9, "Grace", "Taylor", SmoothiePreference.TROPICAL_TWIST, 9012345678L),
                new Customer(10, "Hank", "Anderson", SmoothiePreference.CARAMEL_LATTE, 1230984567L)
        );
        customerRepository.saveAll(customers);
    }

}
