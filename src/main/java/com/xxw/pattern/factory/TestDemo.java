package com.xxw.pattern.factory;

/**
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class TestDemo {
    public static void main(String[] args) {
        MouseFactory mouseFactory=new HpMouseFactory();
        mouseFactory.createMouse().sayHi();
    }
}
