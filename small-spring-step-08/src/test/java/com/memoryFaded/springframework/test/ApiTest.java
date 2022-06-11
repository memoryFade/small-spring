package com.memoryFaded.springframework.test;

import com.memoryFaded.springframework.context.support.ClassPathXmlApplicationContext;
import com.memoryFaded.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_xml() {
        //结果
        //执行：init-method
        //ClassLoader：sun.misc.Launcher$AppClassLoader@18b4aac2
        //使用不同版本jdk会使类加载器产生变化
        //ClassLoader：jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
        //Bean Name is：userService
        //测试结果：小傅哥, 公司：腾讯, 地点深圳
        //ApplicationContextAware：com.memoryFaded.springframework.context.support.ClassPathXmlApplicationContext@19bb089b
        //BeanFactoryAware：com.memoryFaded.springframework.beans.factory.support.DefaultListableBeanFactory@4563e9ab
        //执行：destroy-method
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }
}
