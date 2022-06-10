package com.memoryFaded.springframework.test;


import com.memoryFade.springframework.BeanDefinition;
import com.memoryFade.springframework.BeanFactory;
import com.memoryFaded.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        //1. 初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2. 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 查询bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
