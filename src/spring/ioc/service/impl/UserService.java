package spring.ioc.service.impl;

import spring.ioc.annoation.IocResource;
import spring.ioc.annoation.IocService;
import spring.ioc.service.IOrderService;
import spring.ioc.service.IUserService;

@IocService(name = "user-service")
public class UserService implements IUserService {

    @IocResource
    private IOrderService orderService;

    @Override
    public String findOrder(String userName){
        return orderService.findOrder(userName);
    }
}
