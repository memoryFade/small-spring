package com.memoryFaded.springframework.context.support;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.memoryFaded.springframework.beans.factory.config.BeanPostProcessor;
import com.memoryFaded.springframework.core.io.DefaultResourceLoader;
import com.memoryFaded.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.memoryFaded.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1. 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();

        //2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3. 在Bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactory(beanFactory);

        //4. BeanPostProcessor 需要提前与其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();


    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeanOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeanOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeanOfType(type);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name,requiredType);
    }
}
