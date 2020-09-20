package design.single.hungry;

/**
 * 懒汉模式
 * 安全，推荐
 *
 * @author 刘兵
 */
public class HungrySingleTwo {
    public final static HungrySingleTwo HUNGRY_SINGLE_TWO = new HungrySingleTwo();
    private HungrySingleTwo(){}
}
