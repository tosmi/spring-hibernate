package at.stderr.springdemo.dao;

import at.stderr.springdemo.entity.Customer;
import at.stderr.springdemo.util.SortUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers(int sortField) {
        var currentSession = sessionFactory.getCurrentSession();

        String fieldName;

        switch(sortField) {
            case SortUtils.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                fieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                fieldName = "email";
                break;
            default:
                fieldName = "lastName";
        }

        var theQuery =
                currentSession.createQuery("from Customer order by " + fieldName,
                        Customer.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        var currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        var currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        var currentSession = sessionFactory.getCurrentSession();
        var query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String searchString) {
        var currentSession = sessionFactory.getCurrentSession();

        TypedQuery<Customer> query;
        if (searchString != null && searchString.trim().length() > 0) {
            query = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + searchString.toLowerCase() + "%");
        }
        else {
            query = currentSession.createQuery("from Customer ", Customer.class);
        }

        var customers = query.getResultList();
        System.out.println("Searched for " + searchString + " and found customers: " + customers);
        return customers;
    }
}
