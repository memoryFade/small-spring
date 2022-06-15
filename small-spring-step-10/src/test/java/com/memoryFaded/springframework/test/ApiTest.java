package com.memoryFaded.springframework.test;
import com.memoryFaded.springframework.context.support.ClassPathXmlApplicationContext;
import com.memoryFaded.springframework.test.event.CustomEvent;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));
        applicationContext.registerShutdownHook();
    }
}
