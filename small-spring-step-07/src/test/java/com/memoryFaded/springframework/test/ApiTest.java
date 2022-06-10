package com.memoryFaded.springframework.test;

import com.memoryFaded.springframework.context.support.ClassPathXmlApplicationContext;
import com.memoryFaded.springframework.test.bean.UserService;
import org.junit.Test;

import java.nio.ByteOrder;

public class ApiTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE+"   "+Integer.MIN_VALUE);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        System.out.println(byteOrder);
    }
}
