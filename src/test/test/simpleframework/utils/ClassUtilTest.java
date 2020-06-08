package simpleframework.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class ClassUtilTest {

    @DisplayName(value = "提取目标类方法：extractPackageClassTest")
    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.xxw.entity");
        System.out.println(classSet);
        //用于校验结果是否准确
        Assertions.assertEquals(4,classSet.size());

    }
}
