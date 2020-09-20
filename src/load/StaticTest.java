package load;

/**
 * 静态代码块练习
 *
 * @author: 刘兵
 * @date: 2020/6/7 20:15
 **/
public class StaticTest {
    static Integer a;
    public static void main(String[] args) {

        System.out.println(Student.data);
        System.out.println(a);
    }

}
class Person{
    static{
        System.out.println("Person");
    }
    public static int data  = 123;
}

class Student extends Person{
    static {
        System.out.println("Student");
    }
}
