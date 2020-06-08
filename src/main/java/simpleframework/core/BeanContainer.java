package simpleframework.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleframework.core.annotation.Component;
import simpleframework.core.annotation.Controller;
import simpleframework.core.annotation.Repository;
import simpleframework.core.annotation.Service;
import simpleframework.utils.ClassUtil;
import simpleframework.utils.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * IOC容器
 * 1.可以阻止反射或反序列化的单例模式
 * 2.
 * @author xiongxianwei
 * 2020/6/6 0006
 */

public class BeanContainer {
    private Logger log= LoggerFactory.getLogger(BeanContainer.class);

    private BeanContainer(){

    }
    /**
     * 枚举单例模式 获取bean容器的实例
     * @return
     */
    public static BeanContainer getBeanContainer(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
        HOLDER;
        private BeanContainer instance;
        ContainerHolder(){
            instance=new BeanContainer();
        }
    }
    /**
     * 存放所有被配置标记的目标对象的map
     */
    private final Map<Class<?>,Object> beanMap=new ConcurrentHashMap<>();

    /**
     * 注解列表(有这些注解的bean会被加载)
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION =
            Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);

    private boolean loaded = false;
    /**
     * 判断bean容器是否被加载过
     * @return true 已加载 false未加载过
     */
    public boolean isLoaded(){
        return loaded;
    }

    /**
     * 获取bean的数量
     * @return
     */
    public int beanMapSize(){
        return beanMap.size();
    }

    /**
     * bean容器加载（初始化）
     * 扫描并加载所有Bean
     * (加synchronized防止两个线程进入加载)
     * @param packageName 包名
     */
    public synchronized void loadBeans(String packageName){
        //判断bean容器是否被加载过
        if (isLoaded()){
            log.warn("bean容器已经被加载过");
            return;
        }
        Set<Class<?>> classSet= ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)){
            log.warn("extract nothing from packageName"+packageName);
            return;
        }

        for (Class<?> extractClazz:classSet){
            for (Class<? extends Annotation> annotation :BEAN_ANNOTATION){
                //判断指定包路径下扫描到的class是否是定义好的四个bean注解
                if (extractClazz.isAnnotationPresent(annotation)){
                    //将目标类本身作为键,目标类的实例作为值,放入到beanMap中
                    beanMap.put(extractClazz,ClassUtil.newInstance(extractClazz,true));
                }
            }
        }
        //标记bean容器已被加载
        loaded=true;
    }

    /**
     * 添加一个IOC容器管理的Class对象及bean实例
     * @param clazz
     * @param object
     * @return bean的实例 没有则返回null
     */
    public Object addBean(Class<?> clazz,Object object){
        return beanMap.put(clazz,object);
    }

    /**
     * 移除一个IOC容器管理的Class对象及bean实例
     * @param clazz
     * @return bean的实例 没有则返回null
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }

    /**
     * 获得一个IOC容器管理的Class对象及bean实例
     * @param clazz
     * @return bean的实例 没有则返回null
     */
    public Object getBean(Class<?> clazz){
        return beanMap.get(clazz);
    }

    /**
     * 获得ioc容器所有Class对象集合
     * @return
     */
    public Set<Class<?>> getClasses(){
        return beanMap.keySet();
    }

    /**
     * 获得ioc容器所有实例集合
     * @return
     */
    public Set<Object> getBeans(){
        return new HashSet<>(beanMap.values());
    }

    /**
     * 筛选IOC容器中某一注解的所有class对象
     * @param annotation 注解类
     * @return 该注解标记的所有class对象集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class <? extends Annotation> annotation){
        //1.获取容器里所有class对象
        Set<Class<?>> keySet=getClasses();
        if (ValidationUtil.isEmpty(keySet)){
            log.warn("容器里没有Class对象！");
            return null;
        }
        //2.通过注解筛选Class对象 放入classSet集合里
        Set<Class<?>> classSet=new HashSet<>();
        for (Class<?> clazz:keySet){
            if (clazz.isAnnotationPresent(annotation)){
                classSet.add(clazz);
            }
        }
        return classSet.size()>0?classSet:null;
    }

    /**
     * 根据父类类型筛选IOC容器中的class对象
     * @param interfaceOrClass 父类或接口类型
     * @return 继承该父类或接口的所有class对象集合
     */
    public Set<Class<?>> getClassesBySuper(Class <?> interfaceOrClass){
        //1.获取容器里所有class对象
        Set<Class<?>> keySet=getClasses();
        if (ValidationUtil.isEmpty(keySet)){
            log.warn("容器里没有Class对象！");
            return null;
        }
        //2.判断容器中class类是否是其子类
        Set<Class<?>> classSet=new HashSet<>();
        for (Class<?> clazz:keySet){
            //遍历判断clazz是否为interfaceOrClass的子类
            if (interfaceOrClass.isAssignableFrom(clazz)){
                classSet.add(clazz);
            }
        }
        return classSet.size()>0?classSet:null;
    }

}
