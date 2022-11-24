package management_product.repository.impl;

import management_product.model.Product;
import management_product.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    public static List<String> manufactureList = Arrays.asList("Asus", "HP", "Lenovo", "Acer", "Dell", "Apple");

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Product product = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            product = session.load(Product.class, id);
            session.delete(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like :name").setParameter("name", "%" + name + "%").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
