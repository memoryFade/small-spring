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

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal("2840.02").setScale(2,RoundingMode.HALF_UP);
        System.out.println("b = "+ b.doubleValue());
        System.out.println(a.divide(b).doubleValue());
    }
}
