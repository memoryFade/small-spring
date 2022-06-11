package com.memoryFaded.springframework.beans.factory;

import com.memoryFaded.springframework.beans.BeansException;
import com.memoryFaded.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware{
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
