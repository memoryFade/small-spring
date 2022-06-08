package com.memoryFaded.springframework.test;

import com.memoryFaded.springframework.beans.PropertyValue;
import com.memoryFaded.springframework.beans.PropertyValues;
import com.memoryFaded.springframework.beans.factory.config.BeanDefinition;
import com.memoryFaded.springframework.beans.factory.config.BeanReference;
import com.memoryFaded.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.memoryFaded.springframework.test.bean.UserDao;
import com.memoryFaded.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        //3. UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //4. UserService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
