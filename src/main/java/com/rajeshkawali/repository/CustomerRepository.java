package com.rajeshkawali.repository;

import com.rajeshkawali.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Rajesh_Kawali
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
