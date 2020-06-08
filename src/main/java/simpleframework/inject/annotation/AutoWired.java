package simpleframework.inject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目前只支持成员变量的注入
 * @author xiongxianwei
 * 2020/6/8 0008
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoWired {

    /**
     * 若注入的接口有多个实现类，该属性用于表明注入的是哪个实现类
     * @return
     */
    String value() default "";
}
