package com.ncblog;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            // РЎРѕР·РґР°РµС‚ СЃРµСЃСЃРёСЋ СЃ hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Р§РёСЃС‚РёС‚ РєРµС€ Рё Р·Р°РєСЂС‹РІР°РµС‚ СЃРѕРµРґРёРЅРµРЅРёРµ СЃ Р‘Р”
        getSessionFactory().close();
    }

}

