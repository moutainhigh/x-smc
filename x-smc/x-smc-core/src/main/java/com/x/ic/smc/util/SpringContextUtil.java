package com.x.ic.smc.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private ApplicationContext context; 

    private static SpringContextUtil instance;

    public synchronized static SpringContextUtil getInstance() {
        if (instance == null) {
            instance = new SpringContextUtil();
        }
        return instance;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * 获取对象
     * 
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
//    public Object getBean(String name) throws BeansException {
//        return context.getBean(name);
//    }

    /**
     * 获取类型为requiredType的对象 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     * 
     * @param name
     *            bean注册名
     * @param requiredType
     *            返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
//    public Object getBean(String name, Class<?> requiredType) throws BeansException {
//        return context.getBean(name, requiredType);
//    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * 
     * @param name
     * @return boolean
     */
    public boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * 
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     */
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     * 
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }
}