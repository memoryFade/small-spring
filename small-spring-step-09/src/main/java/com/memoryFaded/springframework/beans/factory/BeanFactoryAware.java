package com.memoryFaded.springframework.beans.factory;

import com.memoryFaded.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
