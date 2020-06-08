package com.xxw.pattern.singleTon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过枚举实现单例：
 * 反编译之后可以发现枚举内部是饿汉模式，在静态代码块就初始化了实例对象，
 * 且枚举类的构造器不能通过反射来获取
 * @author xiongxianwei
 * 2020/6/6 0006
 */
public class EnumStarvingSingleTon {

    private EnumStarvingSingleTon(){
    }

    public static EnumStarvingSingleTon getInstance(){
        return ContainerHolder.Test.singleTon;
    }

    private enum ContainerHolder{
        Test;
        private EnumStarvingSingleTon singleTon;
        ContainerHolder(){
            singleTon=new EnumStarvingSingleTon();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(EnumStarvingSingleTon.getInstance());
        //用反射可以破解双检查锁单例
        Class clazz=ContainerHolder.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        DoubleCheckSingleTon doubleCheckSingleTon = (DoubleCheckSingleTon)constructor.newInstance();
        System.out.println(doubleCheckSingleTon);
    }
}
