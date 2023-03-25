package org.jspiders.customerApp.repository;

import org.jspiders.customerApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomeRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerName(String name);
    Customer findByCustomerEmail(String email);
    List<Customer> findByCustomerAgeGreaterThan(int age);

    List<Customer> findByTotalPurchaseLessThan(double amt);
}
