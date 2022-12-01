package management_customer.service.impl;

import management_customer.model.Customer;
import management_customer.service.ICustomerService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
@Service
public class HibernateCustomerService implements ICustomerService {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
