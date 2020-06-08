package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 用于解析注解
 * @author xiongxianwei
 * 2020/6/2 0002
 */
public class AnnotationParser {
    //1.解析类注解
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("demo.annotation.JavaCourse");
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation:annotations){
            CourseInfoAnnotation courseInfoAnnotation= (CourseInfoAnnotation) annotation;
            System.out.println(courseInfoAnnotation.courseName()+","+courseInfoAnnotation.courseProfile()+","+
                    courseInfoAnnotation.courseTag()+","+courseInfoAnnotation.courseIndex());
        }
    }

    //2.解析成员变量的注解
    public static void parseFiledAnnotation() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("demo.annotation.JavaCourse");
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(PersonInfoAnnotation.class)){
                PersonInfoAnnotation personInfoAnnotation= field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println(personInfoAnnotation.name()+","+personInfoAnnotation.age());
                for (String language:personInfoAnnotation.language()){
                    System.out.println(language);
                }
            }
        }
    }

    //3.解析方法的注解
    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("demo.annotation.JavaCourse");
        Method[] methods=clazz.getDeclaredMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(CourseInfoAnnotation.class)){
                CourseInfoAnnotation courseInfoAnnotation= method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println(courseInfoAnnotation.courseName()+","+courseInfoAnnotation.courseProfile()+","+
                        courseInfoAnnotation.courseTag()+","+courseInfoAnnotation.courseIndex());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //parseTypeAnnotation();
        parseFiledAnnotation();
        //parseMethodAnnotation();
    }
}
