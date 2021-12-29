package at.stderr.springdemo.controller;

import at.stderr.springdemo.entity.Customer;
import at.stderr.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String ListCustomers(Model theModel) {
        var theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        var customer = new Customer();
        theModel.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
}
