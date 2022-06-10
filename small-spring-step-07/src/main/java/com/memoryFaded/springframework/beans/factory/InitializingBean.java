package com.memoryFaded.springframework.beans.factory;

/**
 * @author memoryFaded
 */
public interface InitializingBean {
    /**
     * bean处理属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
