package demo.reflect;

/**
 * 通过Class对象可以获取某个类中的构造方法；
 * 1).批量的方法:
     * public Constructor[] getConstructors() :所有"公有的"构造方法
     * public Constructor[] getDeclaredConstructors():获取所有的构造方法(包括私有、受保护、默认、公有)
 * 2).获取单个的方法，并调用：
     * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法:
     * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的
 *
 * 调用构造方法Constructor-->newInstance(Object... initargs)
 *
 * @author xiongxianwei
 * 2020/6/2 0002
 */
public class ReflectController {
    public static void main(String[] args) {

    }
}
