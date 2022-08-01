package at.stderr.thymeleafdemo.controller;

import at.stderr.thymeleafdemo.entity.Employee;
import at.stderr.thymeleafdemo.service.EmployeeService;
import at.stderr.thymeleafdemo.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee employee = new Employee();
        theModel.addAttribute(employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        Employee e = employeeService.findById(id);
        model.addAttribute("employee", e);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
