package simpleframework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 控制器注解
 * @author xiongxianwei
 * 2020/6/5 0005
 */
//该注解作用在类上
@Target(ElementType.TYPE)
//生命周期是运行时（因为需要反射获取该注解属性）
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
