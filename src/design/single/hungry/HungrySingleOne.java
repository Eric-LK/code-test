package design.single.hungry;

/**
 * 单例模式
 *
 * @author: liuBing
 * @date: 2020/6/1
 **/
public class HungrySingleOne {
    public static HungrySingleOne hungrySingleOne;

    static {
        // 这块用于初始化 一些配置文件中的数据
        hungrySingleOne = new HungrySingleOne();
    }

    private HungrySingleOne() {
    }

}
