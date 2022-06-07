package com.memoryFaded.springframework.beans.factory.support;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.factory.config.BeanDefinition;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException|IllegalAccessException e){
            throw  new BeansException("Instantiation of bean failed",e) ;
        }
//
        addSingleton(beanName,bean);
        return bean;
    }
}
