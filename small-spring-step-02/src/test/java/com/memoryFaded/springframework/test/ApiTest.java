package com.memoryFaded.springframework.test;

import com.memoryFaded.springframework.beans.factory.config.BeanDefinition;
import com.memoryFaded.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.memoryFaded.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = ((UserService) beanFactory.getBean("userService"));
        userService.queryUserInfo();
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
