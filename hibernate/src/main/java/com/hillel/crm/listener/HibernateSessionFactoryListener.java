package com.hillel.crm.listener;

import com.hillel.crm.connection.SessionFactoryHolder;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebListener
public class HibernateSessionFactoryListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SessionFactory sessionFactory = SessionFactoryHolder.getSessionFactory();
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        SessionFactoryHolder.setSessionFactory(sf);
    }
}
