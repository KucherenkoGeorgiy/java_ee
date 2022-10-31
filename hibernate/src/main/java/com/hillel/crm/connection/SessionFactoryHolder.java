package com.hillel.crm.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionFactoryHolder {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    public static Session provideSession() {
        return sessionFactory.openSession();
    }

}
