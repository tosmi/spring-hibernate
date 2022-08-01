package at.stderr.thymeleafdemo.controller;

import at.stderr.thymeleafdemo.model.Employee;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        Employee emp1 = new Employee(1,"Leslie", "Andrews", "leslie@stderr.at");
        Employee emp2 = new Employee(2,"Emma", "Baumgarten", "emma@stderr.at");
        Employee emp3 = new Employee(3,"Avani", "Gupta", "avani@stderr.at");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        System.out.println(theEmployees);
        System.out.println(Conventions.getVariableName(theEmployees));

        // if addAttribute(theEmployees) is use spring generates a variable "employeeList"
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
