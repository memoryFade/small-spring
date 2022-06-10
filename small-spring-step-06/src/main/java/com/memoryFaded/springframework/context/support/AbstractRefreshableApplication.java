package com.memoryFaded.springframework.context.support;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.memoryFaded.springframework.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplication extends AbstractApplicationContext{
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanfactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
