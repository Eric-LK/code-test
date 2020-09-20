package exception;


/**
 * @author 17734
 */
public class Start {
    public static void main(String args[]) {
          // 实例化对象，调用方法
          eTest e = new eTest();
          try{
              e.show(1);
              e.aShow(1);
          }catch (Exception es){
              System.out.println(es.getMessage());
          }




    }
}
// 自定义异常类
class ExceptionTest extends Exception{
    // 自定义构造函数，传入异常信息
    ExceptionTest(String message){
        // 继承并使用父类的构造函数
        super(message);
    }
}
// 功能性方法
class eTest{
    // 方法名上标识此方法抛出的异常
    void show(int x) throws ExceptionTest{
        if(x==0){
            // 方法内部抛出异常，方法名上一定要有标识
            throw new ExceptionTest("ce shi exception");
        }
    }
        // 此方法不需要标识
        void aShow(int a){
            if (a==1){
                // 抛出的RuntimeException异常，可以不在方法中标识
                throw new AException("this is AException");
            }
            System.out.println("no Exception!");
        }
    }
    class  AException extends RuntimeException {
        AException(String message){
            super(message);
        }
    }



