package test.abstract1;

public interface Play {
    void playGame();
    void playBasketBall();
    default void speak(){
        System.out.println("123");
    }
}
