package spring.ioc;

import spring.ioc.context.SpringContext;
import spring.ioc.service.IUserService;

public class SpringIocTest {
    public static void main(String[] args) throws Exception {
        // 指定扫描的包路径
        String path = "spring.ioc.service.impl";
        // 创建springContext对象
        SpringContext context = new SpringContext(path);
        // 通过SpringContext创建包下的对象
        IUserService userService = (IUserService) context.getBean("user-service");
        // 调用方法
        System.out.println(userService.findOrder("eric"));
    }
}
