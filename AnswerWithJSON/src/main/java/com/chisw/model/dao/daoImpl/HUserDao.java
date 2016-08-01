package com.chisw.model.dao.daoImpl;

import com.chisw.model.dao.UserDao;
import com.chisw.model.User;
import org.hibernate.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class HUserDao implements UserDao {

    private static EntityManager manager = Persistence.createEntityManagerFactory("MyUnit").createEntityManager();

    @Override
    public List<User> getAll() {

        Session session = manager.unwrap(Session.class);
        return session.createCriteria(User.class).list();
    }

    @Override
    public User getSQL(Integer id) {

        Session session = manager.unwrap(Session.class);
        String sql = "SELECT * FROM employee WHERE id= :id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("id", id);
        query.addEntity(User.class);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public User getHQL(Integer id) {

        Session session = manager.unwrap(Session.class);
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
    public void add(User user) {

        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }

    @Override
    public String delete(Integer id) {

        manager.getTransaction().begin();
        User user = manager.merge(getHQL(id));
        manager.remove(user);
        manager.getTransaction().commit();
        return "User with id " + id + " has been deleted";
    }

    @Override
    public void change(User user) {

        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }
}
