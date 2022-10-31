package com.hillel.crm.repository;

import com.hillel.crm.connection.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public abstract class BaseRepository<T> {

    public List<T> getListWithOneParameter(int idFirst, String hqlQuerry, Class<T> finalClass) {
        return getListWithTwoParameters(idFirst, -1, hqlQuerry, finalClass);
    }

    public List<T> getListWithoutParameter(String hqlQuerry, Class<T> finalClass) {
        return getListWithOneParameter(-1, hqlQuerry, finalClass);
    }

    public List<T> getListWithTwoParameters(int idFirst, int idSecond, String hqlQuerry, Class<T> finalClass) {
        Session session = SessionFactoryHolder.provideSession();
        List<T> result = List.of();

        Query<T> query = session.createQuery(hqlQuerry, finalClass);

        if (idFirst != -1) {
            query.setParameter("ida", idFirst);
        }

        if (idSecond != -1) {
            query.setParameter("idb", idSecond);
        }

        result = query.list();
        session.close();
        return result;
    }
}

