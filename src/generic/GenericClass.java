package generic;

/**
 * 泛型类
 *
 * @author: liuBing
 * @date: 2020/6/5
 **/
public class GenericClass<T> {

    private T data;

    public GenericClass(T data) {
        this.data = data;
    }

    /**
     * 没有 <T> 的方法都不是泛型方法，只有泛型方法才可以写成静态的
     *
     * @param t t
     */
    public void setData(T t) {
        data = t;
    }

    public T getData() {
        return data;
    }

    public static <T> String show(T t) {
        return "123" + t;
    }

}
