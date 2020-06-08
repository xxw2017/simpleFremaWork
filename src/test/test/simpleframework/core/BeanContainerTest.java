package simpleframework.core;

import com.xxw.HelloServlet;
import com.xxw.controller.MainPageController;
import org.junit.jupiter.api.*;

import java.lang.annotation.Target;

/**
 * @author xiongxianwei
 * 2020/6/7 0007
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer=BeanContainer.getBeanContainer();
        System.out.println(beanContainer);
        beanContainer=BeanContainer.getBeanContainer();
        System.out.println(beanContainer);
    }

    @Order(1)
    @DisplayName("loadBeanTest：加载目标包路径的所有Class对象和其实例")
    @Test
    public void loadBeanTest(){
        Assertions.assertEquals(false,beanContainer.isLoaded());
        beanContainer.loadBeans("com.xxw");
        Assertions.assertEquals(4,beanContainer.beanMapSize());
        Assertions.assertEquals(true,beanContainer.isLoaded());
    }

    @Order(2)
    @DisplayName("getBeansTest：根据Class对象获取其实例")
    @Test
    public void getBeansTest(){
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        HelloServlet helloServlet= (HelloServlet) beanContainer.getBean(HelloServlet.class);
        Assertions.assertEquals(false,helloServlet instanceof HelloServlet);
    }


}
