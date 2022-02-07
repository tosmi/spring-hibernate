package at.stderr.springdemo.controller;

import at.stderr.springdemo.entity.Customer;
import at.stderr.springdemo.service.CustomerService;
import at.stderr.springdemo.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String ListCustomers(@RequestParam(required = false) String sort, Model theModel) {
        List<Customer> theCustomers;

        if (sort != null) {
            int sortField = Integer.parseInt(sort);
            theCustomers = customerService.getCustomers(sortField);
        }
        else {
            theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
        }

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

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        var customer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int theId,
                                 Model theModel) {
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("search")
    public String searchCustomers(@RequestParam("searchString") String searchString,
                                  Model theModel) {
        var customers = customerService.searchCustomers(searchString);
        System.out.println(customers);
        theModel.addAttribute("customers", customers);
        return "list-customers";
    }

}
