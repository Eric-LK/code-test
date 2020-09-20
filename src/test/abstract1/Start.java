package test.abstract1;

public class Start {
    public static void main(String[] args){
        Student student = new Student();
        student.eat();
        student.breathing();

        Play seeStudent = new Student();
        seeStudent.playBasketBall();
        seeStudent.playGame();
    }

}
