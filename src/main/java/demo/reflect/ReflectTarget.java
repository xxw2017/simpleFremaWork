package demo.reflect;

/**
 * @author xiongxianwei
 * 2020/6/2 0002
 */
public class ReflectTarget {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取对象Class类对象的方式
        //1.第一种
        ReflectTarget reflectTarget=new ReflectTarget();
        Class<? extends ReflectTarget> reflectTargetClass1 = reflectTarget.getClass();
        //2.第二种
        Class<ReflectTarget> reflectTargetClass2 = ReflectTarget.class;
        //3.第三种
        Class<?> reflectTargetClass3 = Class.forName("demo.reflect.ReflectTarget");



    }
}
