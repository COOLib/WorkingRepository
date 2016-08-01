package com.chisw.model.dao.daoImpl;

import com.chisw.model.dao.UserDao;
import com.chisw.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class HUserDao implements UserDao {

    private SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HUserDao.class);

    @Override
    @Transactional
    public List<User> getAllByCriteria() {

        LOGGER.info("Connecting to database. Running method is: getAllByCriteria()");

        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();

        return users;
    }

    @Override
    @Transactional
    public User getBySQL(Integer id) {

        LOGGER.info("Connecting to database. Running method is: getBySQL()");

        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM employee WHERE id= :id";
        Query query = session.createSQLQuery(sql);
        query.setParameter("id", id);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    @Transactional
    public User getByHQL(Integer id) {

        LOGGER.info("Connecting to database. Running method is: getByHQL()");


        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from User u where u.id=:id");
        query.setParameter("id", id);

        User user = (User) query.uniqueResult();
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    @Transactional
    public void add(User user) {

        LOGGER.info("Connecting to database. Running method is: add()");
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public String delete(Integer id) {

        LOGGER.info("Connecting to database. Running method is: delete()");


        return "User with id " + id + " has been deleted";
    }

    @Override
    @Transactional
    public void change(User user) {

        LOGGER.info("Connecting to database. Running method is: change()");

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
