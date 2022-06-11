package com.memoryFaded.springframework.context.event;

import com.memoryFaded.springframework.context.ApplicationContext;

import java.util.EventObject;

public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplication(){
        return ((ApplicationContext) getSource());
    }
}
