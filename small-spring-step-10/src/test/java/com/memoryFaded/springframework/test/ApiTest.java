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

    @Test
    public void test_event1() {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }

    static void pong() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.print("pong");
    }

    @Test
    public void test_equals() {
        Integer a = new Integer(200);
        int b = 200;
        Integer c = 200;
        Integer d = 200;
        Integer e = 3;
        Integer f = 3;
        Double g = 3.0;
        Double h = 3.0;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(g == h);
    }

    @Test
    public void parseString() {
        String log = "2020-05-16 19:20:34|user.login|name=Charles&location=Beijing&device=iPhone";
        String[] names = log.substring(log.indexOf("name"), log.indexOf("location") - 1).split("=");
        String[] locations = log.substring(log.indexOf("location"), log.indexOf("device") - 1).split("=");
        String[] devices = log.substring(log.indexOf("device")).split("=");

        if (names.length < 2 | locations.length < 2 | devices.length < 2) {
            throw new IllegalArgumentException("数据不合法");
        }
        System.out.println("{");
        System.out.println(names[0] + ":\"" + names[1] + "\",");
        System.out.println(locations[0] + ":\"" + locations[1] + "\",");
        System.out.println(devices[0] + ":\"" + devices[1] + "\"");
        System.out.println("}");
    }

    @Test
    public void a() {
        StringBuilder sb = new StringBuilder("a");
        System.out.println(sb.hashCode());
        b(sb);
        System.out.println(sb);
    }

    private void b(StringBuilder sb) {
        sb.append("b");
        System.out.println(sb.hashCode());
        System.out.println(sb.toString());
    }

    @Test
    public void a1() {
        String s = "a";
        b1(s);
        System.out.println(s);
    }

    private void b1(String s) {
        s += "b";
        System.out.println(s);
    }

    @Test
    public void test_Integer() {
        Integer a = 1;
        test_Integer1(a);
        System.out.println(a);
    }

    private void test_Integer1(Integer a) {
        a = a + 1;
        System.out.println(a);
    }


    @Test
    public void test_Dog() {
        Dog dog = new Dog("dog");
        test_Dog1(dog);
        System.out.println(dog.name);
    }

    private void test_Dog1(Dog dog) {
        dog.name = "cat";
        System.out.println(dog.name);
    }

    class Dog {
        String name;

        Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
