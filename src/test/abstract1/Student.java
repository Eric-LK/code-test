package test.abstract1;

import thread.imooc.Punishment;

public class Student extends AbstractPerson implements Play{


    @Override
    public void eat() {
        System.out.println("eat breakfast !");
        System.out.println("eat lunch !");
        System.out.println("eat dinner !");
    }

    @Override
    public void playGame() {
        System.out.println("play computer with my son ！");
    }

    @Override
    public void playBasketBall() {
        System.out.println("play basketball with brother ！");
    }
}
