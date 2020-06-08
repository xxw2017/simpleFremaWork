package com.xxw.pattern.factory.entity;

/**
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class DellMouse implements Mouse {



    @Override
    public void sayHi() {
        System.out.println("生产戴尔鼠标");
    }
}
