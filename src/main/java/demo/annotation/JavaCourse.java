package demo.annotation;

/**
 * @author xiongxianwei
 * 2020/6/2 0002
 */
@CourseInfoAnnotation(courseName = "java课程",courseTag = "面试",courseProfile = "介绍各种java课程")
public class JavaCourse {
    @PersonInfoAnnotation(name = "熊十三" ,language={"Java","Python"})
    private String auther;

    @CourseInfoAnnotation(courseName = "java课程2",courseTag = "面试2",courseProfile = "介绍各种java课程2")
    public void getJavaCourse(){

    }
}
