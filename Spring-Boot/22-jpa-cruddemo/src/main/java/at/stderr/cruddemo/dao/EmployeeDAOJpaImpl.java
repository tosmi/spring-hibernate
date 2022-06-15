package at.stderr.cruddemo.dao;

import at.stderr.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager em;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Employee> findAll() {
        Query q = em.createQuery("from Employee");
        var employees = q.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        var employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        var dbEmployee = em.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        var q = em.createQuery("delete from Employee where id = :employeeId");
        q.setParameter("employeeId", id);
        q.executeUpdate();
    }
}
