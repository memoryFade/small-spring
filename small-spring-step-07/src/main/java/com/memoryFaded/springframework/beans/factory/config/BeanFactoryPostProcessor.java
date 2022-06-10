package com.memoryFaded.springframework.beans.factory.config;


import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
