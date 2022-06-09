package com.mermoryFaded.springframework.beans.factory.config;


import com.mermoryFaded.springframework.beans.BeansException;
import com.mermoryFaded.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
