package com.xxw.pattern.singleTon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xiongxianwei
 * 2020/6/6 0006
 */
public class TestDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(DoubleCheckSingleTon.getSingleton());

        //用反射可以破解双检查锁单例
        Class clazz=DoubleCheckSingleTon.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        DoubleCheckSingleTon doubleCheckSingleTon = (DoubleCheckSingleTon)constructor.newInstance();
        System.out.println(doubleCheckSingleTon);
    }
}
