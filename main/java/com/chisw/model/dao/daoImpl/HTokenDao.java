package com.chisw.model.dao.daoImpl;

import com.chisw.model.MyToken;
import com.chisw.model.dao.TokenDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HTokenDao implements TokenDao {

    private static EntityManager manager = Persistence.createEntityManagerFactory("MyUnit").createEntityManager();

    @Override
    public String getToken(Integer id) {

        Session session = manager.unwrap(Session.class);
        String sql = "SELECT token_body  FROM token WHERE id= :id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("id", id);

        String tokenBody = (String) query.uniqueResult();
        return tokenBody;
    }

    @Override
    public void add(MyToken token) {

        manager.getTransaction().begin();
        manager.persist(token);
        manager.getTransaction().commit();
    }
}
