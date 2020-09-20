package test.abstract1;

public interface Teach {
    void teachMath();
    void teachChinese();
    default void teachCurriculum(){
        System.out.println("TeachCurriculum is very glory");
    }
}
