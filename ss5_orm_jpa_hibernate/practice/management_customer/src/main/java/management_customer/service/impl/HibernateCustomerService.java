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

//    static {
//        System.out.println("hellofdsfdsfdssssssssssssssssssssssssssssssss");
//        try {
//            sessionFactory = new Configuration()
//                    .configure("hibernate.conf.xml")
//                    .buildSessionFactory();
//            entityManager = sessionFactory.createEntityManager();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public List<Customer> findAll() {
//        String queryStr = "SELECT c FROM Customer AS c";
//        TypedQuery<Customer> query = ConnectionUtil.entityManager.createQuery(queryStr, Customer.class);
//        return query.getResultList();
        return null;
    }
}
