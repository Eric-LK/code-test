package test.assertt;

/**
 * @author: 刘兵
 * @date: 2020/6/22 21:28
 **/
public class AssertTest {
    public static void main(String[] args) {
        compare(3);
    }

    public static void compare(Integer a ){
        assert a < 2 : "怎么回事？";
        System.out.println(1);
    }
}
