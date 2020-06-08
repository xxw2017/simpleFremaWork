package simpleframework.inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleframework.core.BeanContainer;
import simpleframework.inject.annotation.AutoWired;
import simpleframework.utils.ClassUtil;
import simpleframework.utils.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * 依赖注入类
 * @author xiongxianwei
 * 2020/6/8 0008
 */

public class DependencyInjector {
    private Logger log= LoggerFactory.getLogger(DependencyInjector.class);

    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer=BeanContainer.getBeanContainer();
    }

    /**
     * 执行依赖注入
     */
    public void doDI(){
        Set<Class<?>> classes = beanContainer.getClasses();
        if (ValidationUtil.isEmpty(classes)){
            log.warn("IOC容器中没有class对象！");
            return;
        }
        //1.遍历Bean容器中所有的Class对象
        for (Class<?> clazz:classes){
            //2.通过反射，遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)){
                continue;
            }
            for (Field field:fields){
                //3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(AutoWired.class)){

                    //获得autowired的属性值
                    AutoWired autoWired = field.getAnnotation(AutoWired.class);
                    String autoWiredValue=autoWired.value();

                    //4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldObject=getFiledInstance(fieldClass,autoWiredValue);
                    if (fieldObject==null){
                        throw new RuntimeException("容器内该成员变量实例:"+fieldClass.getName()+",为null! autoWiredValue="+autoWiredValue);
                    }
                    //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                    else {
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field,targetBean,fieldObject,true);
                    }
                }
            }
        }

    }

    /**
     * 根据成员变量Class(可能为接口) 获取bean容器里 该Class的实例或该接口的实现类
     * @param fieldClass
     * @param autoWiredValue
     * @return
     */
    private Object getFiledInstance(Class<?> fieldClass, String autoWiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue!=null){
            return fieldValue;
        }
        //等于null表示获取到的Bean有可能是接口
        else {
            //获得其实现类
            Class<?> implementedClass = getImplementedClass(fieldClass,autoWiredValue);
            //如果实现类不为null，就返回实现类实例 否则返回null
            if (implementedClass!=null){
                return beanContainer.getBean(implementedClass);
            }else {
                return null;
            }
        }
    }

    private Class<?> getImplementedClass(Class<?> fieldClass, String autoWiredValue) {
        Set<Class<?>> implementedClassSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(implementedClassSet)){
            //autowired注解的value属性用于指定注入的实现类名字
            if (ValidationUtil.isEmpty(autoWiredValue)){
                //如果只有一个实现类直接返回
                if (implementedClassSet.size()==1){
                    return implementedClassSet.iterator().next();
                }else {
                    throw new RuntimeException(fieldClass.getName()+"接口有多个实现类，请在@Autowired注解的value属性赋值指定注入的是哪个实现类！当前autoWiredValue="+autoWiredValue);
                }
            }else {
                for (Class<?> clazz:implementedClassSet){
                    //返回与autowiredValue相等的实现类名
                    if (autoWiredValue.equals(clazz.getSimpleName())){
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
