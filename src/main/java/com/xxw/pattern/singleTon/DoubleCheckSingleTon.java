package com.xxw.pattern.singleTon;

/**
 * 双检查锁单例模式
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class DoubleCheckSingleTon {
    //若不使用volatile修饰，那么下面创建单例对象时，2、3步执行顺序可能会交换
    //若发生3先执行（此时singleton不为空），而2还没执行的时候，新来的线程会发现singleton不为空，则直接返回还没初始化的对象
    private volatile static DoubleCheckSingleTon singleton;

    //防止外部创建该对象
    private DoubleCheckSingleTon (){}

    public static DoubleCheckSingleTon getSingleton() {
        //A、第一次判空
        if (singleton == null) {
            //B、加对象锁（对所有线程生效）
            synchronized (DoubleCheckSingleTon.class) {
                //C、第二次判空
                if (singleton == null) {
                    //以下是创建对象的步骤
                    //memory = allocate(); //1.给单例对象分配内存空间
                    //singleton(memory); //2.初始化对象
                    //singleton = memory; //3.设置singleton指向刚分配内存地址,此时singleton ! =null

                    //D、创建单例对象
                    singleton = new DoubleCheckSingleTon();
                }
            }
        }
        return singleton;
    }
}
