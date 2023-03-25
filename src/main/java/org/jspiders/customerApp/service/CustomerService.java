package org.jspiders.customerApp.service;

import org.jspiders.customerApp.model.Customer;
import org.jspiders.customerApp.repository.CustomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomeRepository repository;

    // display all Customer
    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    public Customer addCustomer(Customer c){
        return repository.save(c);
    }
    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Customer> getCustomerByName(String name){
        return repository.findByCustomerName(name);
    }
    public Customer getCustomerByEmail(String email){
        return repository.findByCustomerEmail(email);
    }
    public List<Customer> getCustomerByAge(int age){
        return repository.findByCustomerAgeGreaterThan(age);
    }
    public List<Customer> getCustomerByAmt(double amt){
        return repository.findByTotalPurchaseLessThan(amt);
    }
}
