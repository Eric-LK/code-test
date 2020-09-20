package design.single;

import design.single.hungry.HungrySingleEnum;
import design.single.hungry.HungrySingleOne;
import design.single.hungry.HungrySingleTwo;

/**
 * @introduce: 单例测试类
 * @author: liuBing
 * @date: 2020/6/1
 **/
public class Test {
    public static void main(String[] args) {
        // hungrySingle
        HungrySingleEnum hungrySingleEnum = HungrySingleEnum.instance;
        HungrySingleOne hungrySingleOne = HungrySingleOne.hungrySingleOne;
        HungrySingleTwo hungrySingleTwo = HungrySingleTwo.HUNGRY_SINGLE_TWO;
    }
}
