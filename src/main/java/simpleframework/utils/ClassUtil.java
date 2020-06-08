package simpleframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class ClassUtil {
    //文件类型协议
    public static final String FILE_PROTOCOL = "file";
    private static Logger log=LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 1.获取到类的加载器：
     * 2.通过类加载器获取到加载的资源信息
     * 3.依据不同的资源类型,采用不同的方式获取资源的集合
     *
     * @param packageName 包名
     * @return Class类的set集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName){
        //1.获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        //2.通过类加载器获取到加载的资源信息
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url==null){
            log.warn("unable to retrieve anything from package: "+ packageName);
            return null;
        }
        //3.依据不同的资源类型,采用不同的方式获取资源的集合
        Set<Class<?>> classSet=null;
        //过滤出文件类型的URL资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet=new HashSet<>();
            //获取url的实际路径
            File packageDir=new File(url.getPath());
            //获取包路径下的所有class文件
            extractClassFile(classSet,packageDir,packageName);
        }
        return classSet;
    }

    /**
     * 实例化 Class类
     * @param clazz class对象
     * @param accessible 是否支持创建出私有class对象的实例
     * @param <T> class的类型
     * @return class对象的实例
     */
    public static <T> T newInstance(Class<?> clazz,boolean accessible){
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("创建Class类的实例失败！");
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param emptyClassSet 装载遍历出的Class类的集合
     * @param fileSource    文件或目录
     * @param packageName   包名
     * @return 类的集合
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()){
            return;
        }
        //遍历该目录下的文件夹，若不是文件夹且是class文件，则加入ClassSet集合
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                //accept()里的return true表示遍历获得所有是文件夹的File对象
                if (file.isDirectory()) {
                    return true;
                } else {
                    //获得文件的绝对值路径
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        //若是class文件，则加入集合
                        addClassToSet(absolutePath);
                    }
                }
                return false;
            }
            //根据class文件的绝对值路径,获取并生成class对象,并放入classSet中
            private void addClassToSet(String absolutePath) {
                //1.从class文件的绝对值路径里提取出包含了package的类名
                // 如E:\demo\selfFrameWork\com\xxw\entity\dto\MainPageInfoDTO,需要弄成entity.dto.MainPageInfoDTO
                absolutePath=absolutePath.replace(File.separator,".");
                String className=absolutePath.substring(absolutePath.indexOf(packageName));
                className=className.substring(0,className.lastIndexOf("."));
                //2.通过反射机制获取对应的Class对象并加入到classSet
                Class<?> targetClass=loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });

        if (files!=null){
            for (File f:files){
                extractClassFile(emptyClassSet,f,packageName);
            }
        }
    }

    /**
     * 获取Class对象
     * @param className 类的全名 = package路径+类名
     * @return
     */
    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load Class error:"+e);
            throw new RuntimeException(e);
        }
    }
    /**
     * 获得类加载器
     * @return
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 设置类的成员变量值
     * @param field 成员变量
     * @param target 类实例
     * @param source  成员变量的值
     * @param Accessible 是否允许设置私有成员变量
     */
    public static void setField(Field field,Object target,Object source,boolean Accessible){
        field.setAccessible(Accessible);
        try {
            field.set(target,source);
        } catch (IllegalAccessException e) {
            log.error("设置类属性值失败！"+e);
            throw new RuntimeException(e);
        }
    }
}
