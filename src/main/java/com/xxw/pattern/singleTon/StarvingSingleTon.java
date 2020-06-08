package com.xxw.pattern.singleTon;

/**
 * 懒汉模式
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class StarvingSingleTon {
    //创建 StarvingSingleTon 的一个对象
    private static StarvingSingleTon instance = new StarvingSingleTon();

    //让构造函数为 private，这样该类就不会被实例化
    private StarvingSingleTon(){}

    //获取唯一可用的对象
    public static StarvingSingleTon getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(StarvingSingleTon.getInstance());
        System.out.println(StarvingSingleTon.getInstance());
    }
}
