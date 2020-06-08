package simpleframework.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 校验工具类
 * @author xiongxianwei
 * 2020/6/7 0007
 */
public class ValidationUtil {


    /**
     * 数组判空
     * @param arr
     * @return true 是 false 否
     */
    public static boolean isEmpty(Object[] arr){
        return arr==null||arr.length==0;
    }

    /**
     * 字符串判空
     * @param str
     * @return true 是 false 否
     */
    public static boolean isEmpty(String str){
        return str==null||"".equals(str);
    }

    /**
     * Map判空
     * @param map
     * @return true 是 false 否
     */
    public static boolean isEmpty(Map<?,?> map){
        return map==null||map.isEmpty();
    }

    /**
     * 集合判空
     * @param collection
     * @return true 是 false 否
     */
    public static boolean isEmpty(Collection<?> collection){
        return collection==null || collection.isEmpty();
    }
}
