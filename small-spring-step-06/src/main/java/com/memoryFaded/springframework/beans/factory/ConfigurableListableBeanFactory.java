package com.memoryFaded.springframework.beans.factory;


import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.factory.config.BeanDefinition;
import com.memoryFaded.springframework.beans.factory.config.BeanPostProcessor;
import com.memoryFaded.springframework.beans.factory.config.AutowireCapalbeBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapalbeBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
