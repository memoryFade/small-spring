package com.memoryFaded.springframework.context;

import com.memoryFaded.springframework.beans.factory.HierarchicalBeanFactory;
import com.memoryFaded.springframework.beans.factory.ListableBeanFactory;
import com.memoryFaded.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
