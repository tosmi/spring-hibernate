package at.stderr.thymeleafdemo.controller;

import at.stderr.thymeleafdemo.entity.Employee;
import at.stderr.thymeleafdemo.service.EmployeeService;
import at.stderr.thymeleafdemo.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List <Employee> theEmployees = employeeService.findAll();
        // if addAttribute(theEmployees) is use spring generates a variable "employeeList"
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
