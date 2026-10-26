package com.shopapi.ecommerceMini.demo;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MiniContainer {

    private final Map<Class<?>, Object> beans = new HashMap<>();

    public <T> T getBean(Class<T> type) {
        Object bean = beans.get(type);
        if (bean == null) {
            bean = create(type);
            beans.put(type, bean);
        }
        return type.cast(bean);
    }

    private Object create(Class<?> type) {
        if (!type.isAnnotationPresent(MyComponent.class)) {
            throw new IllegalStateException("Không phải bean: " + type.getName());
        }
        try {
            Constructor<?> ctor = type.getDeclaredConstructors()[0];
            Object[] args = Arrays.stream(ctor.getParameterTypes())
                    .map(this::getBean)
                    .toArray();
            return ctor.newInstance(args);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
