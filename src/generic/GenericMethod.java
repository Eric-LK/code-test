package generic;

/**
 * 泛型方法练习
 *
 * @author: liuBing
 * @date: 2020/6/5
 **/
public class GenericMethod {
    /*
     * 泛型有类型擦除
     * 所有泛型的类型都只保留在编译阶段，在代码运行的时候，所有的类型都会变成object类型
     *
     * 
     *
     */


    /**
     * 泛型方法和类是否是泛型没关系
     *
     * @param t   t
     * @param <T> T
     * @return string
     */
    public <T> String showName(T t) {
        return "123" + t;
    }

    /**
     * 通配符，配合泛型来使用，就是参数的类是一个泛型，但是还不确定泛型是什么类型
     *
     * @param genericClass genericClass
     * @return String
     */
    public String showData(GenericClass<?> genericClass) {
        return genericClass.getData().toString();
    }

    /**
     * 通配符的上限，此类以及它的子类
     * 最高是 Number 类
     *
     * @param genericClass genericClass
     * @return String
     */
    public String showDataTop(GenericClass<? extends Number> genericClass) {
        return genericClass.getData().toString();
    }

    /**
     * 通配符的下限，此类以及它的父类
     * 最低是 Integer 类
     *
     * @param genericClass genericClass
     * @return String
     */
    public String showDataDown(GenericClass<? super Integer> genericClass) {
        return genericClass.getData().toString();
    }
}
