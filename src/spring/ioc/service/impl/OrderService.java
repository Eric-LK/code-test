package spring.ioc.service.impl;

import spring.ioc.annoation.IocService;
import spring.ioc.service.IOrderService;

@IocService
public class OrderService implements IOrderService {
    @Override
    public String findOrder(String userName){
        return "用户：" + userName + "订单编号是：1001";
    }
}
