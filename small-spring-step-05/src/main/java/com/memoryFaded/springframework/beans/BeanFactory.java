package com.memoryFaded.springframework.beans;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    /**
     *  重载的方法，方便传递入参给构造函数实例化
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}


