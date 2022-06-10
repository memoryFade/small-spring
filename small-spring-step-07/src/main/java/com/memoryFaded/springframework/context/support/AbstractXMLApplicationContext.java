package com.memoryFaded.springframework.context.support;

import com.memoryFaded.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.memoryFaded.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXMLApplicationContext extends AbstractRefreshableApplication {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations = getConfigLocations();
        if (null!=configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
