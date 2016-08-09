package com.chisw.model.dao.daoImpl;

import com.chisw.model.AuthUser;
import com.chisw.model.dao.AuthUserDao;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HAuthUserDao implements AuthUserDao {

    private static EntityManager manager = Persistence.createEntityManagerFactory("MyUnit").createEntityManager();

    @Override
    public AuthUser getAuthUser(String login) {

        Session session = manager.unwrap(Session.class);
        Query query = session.createQuery("select au from AuthUser au where au.login=:login");
        query.setParameter("login", login);

        AuthUser authUser = (AuthUser) query.uniqueResult();
        if (authUser == null) {
            return null;
        } else {
            return authUser;
        }
    }
}
