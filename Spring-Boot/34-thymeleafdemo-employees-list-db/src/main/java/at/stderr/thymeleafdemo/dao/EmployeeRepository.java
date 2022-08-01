package at.stderr.thymeleafdemo.dao;

import at.stderr.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
