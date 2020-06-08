package simpleframework.inject;

import com.xxw.controller.MainPageController;
import com.xxw.service.combine.HeadLineShopCategoryCombineService;
import com.xxw.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import simpleframework.core.BeanContainer;

import java.lang.annotation.Target;

/**
 * @author xiongxianwei
 * 2020/6/8 0008
 */
public class DITest {
    @DisplayName("doIocTest：依赖注入Test")
    @Test
    public void doIocTest(){
        BeanContainer beanContainer=BeanContainer.getBeanContainer();
        beanContainer.loadBeans("com.xxw");
        Assertions.assertEquals(true,beanContainer.isLoaded());

        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        Assertions.assertEquals(null,mainPageController.getHeadLineShopCategoryCombineService());

        DependencyInjector dependencyInjector=new DependencyInjector();
        dependencyInjector.doDI();
        Assertions.assertNotEquals(null,mainPageController.getHeadLineShopCategoryCombineService());

        boolean assignableFrom = HeadLineShopCategoryCombineService.class.isAssignableFrom(HeadLineShopCategoryCombineServiceImpl.class);
        Assertions.assertEquals(true,assignableFrom);
    }
}
