package org.jspiders.customerApp.controller;

import org.jspiders.customerApp.model.Customer;
import org.jspiders.customerApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    //1.display all Customer
    @GetMapping("/")
    public String getCustomer(Model model){
        Object customers=service.getAllCustomer();
        model.addAttribute("records",customers);
        return "customer";
    }
    @GetMapping("/addcustomer")
    public String displayCustomerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "addcustomer";
    }
    @PostMapping("/insertcustomer")
    public String addProductDetails(Customer c){
        service.addCustomer(c);
        return "redirect:/";
    }
    //===============================================================
    @GetMapping("/customerfetchform")
    public String customerfetchForm(){
        return "customerfetchform";
    }
    //============================================================
    @PostMapping("/getcustomerbyid")
    public String getCustomerById(@RequestParam int id, Model model){
        Customer cos=service.getCustomerById(id);
        model.addAttribute("customer2",cos);
        return "customername";
    }

    @PostMapping("/getcustomerbyname")
    public String getCustomerByName(@RequestParam String name, Model model){
        List<Customer> customerList=service.getCustomerByName(name);
        model.addAttribute("customer2",customerList);
        return "customername";
    }
    @PostMapping("/getcustomerbyemail")
    public String getCustomerByEmail(String email,Model model){
        Customer cos1=service.getCustomerByEmail(email);
        model.addAttribute("customer2",cos1);
        return "customername";
    }
    @PostMapping("/getcustomerbyage")
    public String getCustomerByAge(int age,Model model){
        List<Customer> cosList=service.getCustomerByAge(age);
        model.addAttribute("customer2",cosList);
        return "customername";
    }
    public String getTotalPurchase(double amt,Model model){
        List<Customer>customerByAmt=service.getCustomerByAmt(amt);
        model.addAttribute("customer2",customerByAmt);
        return "customername";
    }
}
