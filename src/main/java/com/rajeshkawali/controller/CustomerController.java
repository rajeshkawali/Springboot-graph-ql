package com.rajeshkawali.controller;


import com.rajeshkawali.model.Customer;
import com.rajeshkawali.model.SmoothiePreference;
import com.rajeshkawali.service.CustomerService;
import com.rajeshkawali.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
public class CustomerController {

    public static final String CLASS_NAME = CustomerController.class.getName();
    private final CustomerService customerService;

    @QueryMapping
    public List<Customer> getAllCustomer() {
        String methodName = ".getAllCustomer";
        log.info(CLASS_NAME + methodName + "::ENTER");
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = customerService.getAllCustomer();
        } catch (Exception e) {
            log.error(CLASS_NAME + methodName + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + methodName + "::EXIT");
        return customerList;
    }

    @MutationMapping
    public Customer addCustomer(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument SmoothiePreference smoothiePreference, @Argument Long mobileNumber) {
        String methodName = ".addCustomer";
        log.info(CLASS_NAME + methodName + "::ENTER");
        Customer customerSaved = null;
        try {
            Customer customer = new Customer(id, firstName, lastName, smoothiePreference, mobileNumber);
            customerSaved = customerService.addCustomer(customer);
        } catch (Exception e) {
            log.error(CLASS_NAME + methodName + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + methodName + "::EXIT");
        return customerSaved;
    }

    @QueryMapping
    public Customer getCustomerById(@Argument Integer id) {
        String methodName = ".getCustomerById";
        log.info(CLASS_NAME + methodName + "::ENTER");
        Customer customer = null;
        try {
            customer = customerService.getCustomerById(id);
        } catch (Exception e) {
            log.error(CLASS_NAME + methodName + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + methodName + "::EXIT");
        return customer;
    }

    @MutationMapping
    public String deleteCustomer(@Argument Integer id) {
        String methodName = ".deleteCustomer";
        log.info(CLASS_NAME + methodName + "::ENTER");
        String result = null;
        try {
            result = customerService.deleteCustomer(id);
        } catch (Exception e) {
            log.error(CLASS_NAME + methodName + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + methodName + "::EXIT");
        return result;
    }

    @MutationMapping
    public Customer updateCustomer(@Argument Integer id, @Argument String firstName, @Argument String lastName, @Argument SmoothiePreference smoothiePreference, @Argument Long mobileNumber) {
        String methodName = ".updateCustomer";
        log.info(CLASS_NAME + methodName + "::ENTER");
        Customer updatedCustomer = null;
        try {
            Customer customer = new Customer(id, firstName, lastName, smoothiePreference, mobileNumber);
            updatedCustomer = customerService.updateCustomer(id, customer);
        } catch (Exception e) {
            log.error(CLASS_NAME + methodName + "::Exception occurred:" + e.getMessage());
        }
        log.info(CLASS_NAME + methodName + "::EXIT");
        return updatedCustomer;
    }
}
