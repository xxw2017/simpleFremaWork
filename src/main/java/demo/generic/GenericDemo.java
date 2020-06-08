package demo.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */
public class GenericDemo {
    public static void main(String[] args) {
        List<Object> linkedList=new LinkedList<>();
        linkedList.add("xxw");
        linkedList.add(1);
        for (Object o:linkedList){
            Object newO=o;
            System.out.println(newO.toString());
        }
    }
}
