package com.memoryFaded.springframework.test.common;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.beans.PropertyValue;
import com.memoryFaded.springframework.beans.PropertyValues;
import com.memoryFaded.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.memoryFaded.springframework.beans.factory.config.BeanDefinition;
import com.memoryFaded.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company","改为:字节跳动"));
    }


}
