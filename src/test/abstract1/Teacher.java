package test.abstract1;

public class Teacher extends AbstractPerson implements Teach{
    @Override
    public void eat() {
        System.out.println("eat breakfast !");
        System.out.println("eat lunch !");
        System.out.println("eat dinner !");
    }

    @Override
    public void teachMath() {
        System.out.println("Chinese Teacher teach Chinese !");
    }

    @Override
    public void teachChinese() {
        System.out.println("Math Teacher teach Math !");
    }
}
