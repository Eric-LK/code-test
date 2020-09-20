package test;


public class NoNameClass {
    public void method (){
        //匿名内部类
        new NoNameClass(){
            void  show(){
                System.out.println("inner");
            }
            void speak(){
                System.out.println("speak");
            }
        }.show();
    }
}

