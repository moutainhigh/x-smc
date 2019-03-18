package com.x.ic.smc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {

    private static final String PATH = "context/core-context.xml";

    private static ApplicationContext appContext;

    private static ServiceFactory instance;

    private synchronized static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }

    private synchronized static void initApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { PATH });
        context.start();
        appContext = context;
    }

    public static <T> T getService(String beanId, Class<T> clazz) {
        return ServiceFactory.getInstance().getServiceId(beanId, clazz);
    }

    public static <T> T getService(Class<T> clazz) {
        return ServiceFactory.getInstance().getServiceId(clazz);
    }

    public static <T> T getService(String beanId) {
        return ServiceFactory.getInstance().getServiceId(beanId);
    }

    private <T> T getServiceId(String beanId, Class<T> clazz) {
        if (appContext == null) {
            synchronized (this) {
                initApplicationContext();
            }
        }
        Object t = (T) appContext.getBean(beanId, clazz);
        if (t == null) {
            synchronized (appContext) {
                appContext = null;
                initApplicationContext();
            }
        }
        return (T) appContext.getBean(beanId, clazz);
    }

    private <T> T getServiceId(Class<T> clazz) {
        if (appContext == null) {
            synchronized (this) {
                initApplicationContext();
            }
        }
        Object t = (T) appContext.getBean(clazz);
        if (t == null) {
            synchronized (appContext) {
                appContext = null;
                initApplicationContext();
            }
        }
        return (T) appContext.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
    private <T> T getServiceId(String beanId) {
        if (appContext == null) {
            synchronized (this) {
                initApplicationContext();
            }
        }
        Object t = (T) appContext.getBean(beanId);
        if (t == null) {
            synchronized (appContext) {
                appContext = null;
                initApplicationContext();
            }
        }
        return (T) appContext.getBean(beanId);
    }

}
