package at.stderr.springdemo.dao;

import at.stderr.springdemo.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        var currentSession = sessionFactory.getCurrentSession();
        var theQuery =
                currentSession.createQuery("from Customer order by lastName",
                        Customer.class);
        var customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        var currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theCustomer);
    }
}
