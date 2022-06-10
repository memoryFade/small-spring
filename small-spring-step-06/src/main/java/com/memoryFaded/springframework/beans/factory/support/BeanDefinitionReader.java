package com.memoryFaded.springframework.beans.factory.support;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.core.io.Resource;
import com.memoryFaded.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;


}
