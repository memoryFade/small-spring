
package com.memoryFaded.springframework.test.event;

import com.memoryFaded.springframework.context.ApplicationListener;
import com.memoryFaded.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}