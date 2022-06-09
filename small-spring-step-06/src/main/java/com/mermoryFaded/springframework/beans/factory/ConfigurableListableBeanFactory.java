package com.mermoryFaded.springframework.beans.factory;


import com.mermoryFaded.springframework.beans.BeansException;
import com.mermoryFaded.springframework.beans.factory.config.BeanDefinition;
import com.mermoryFaded.springframework.beans.factory.config.BeanPostProcessor;

public interface ConfigurableListableBeanFactory  {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    void preInstantiateSingletons() throws BeansException;
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
