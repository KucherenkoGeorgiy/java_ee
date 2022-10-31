package com.hillel.crm.repository;

import com.hillel.crm.connection.SessionFactoryHolder;
import com.hillel.crm.entity.User;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserRepository extends BaseRepository<User> {

    private final static String HQL_GET_ORDER_BY_ID = "select u from User u where u.name = :ida and u.password=:idb";

    public Optional<User> findByNameAndPassword(String name, String password) {
        Session session = SessionFactoryHolder.provideSession();
        Query<User> query = session.createQuery(HQL_GET_ORDER_BY_ID, User.class);
        query.setParameter("ida", name);
        query.setParameter("idb", password);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }
}