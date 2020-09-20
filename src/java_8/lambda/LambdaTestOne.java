package java_8.lambda;

public class LambdaTestOne {
    public static void main(String args[]) {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
        // s.convert1(2,"123");
        /// int a1 = (int)Math.random();
        mathOperator add = Integer::sum;
        mathOperator divis = (x,y) -> x*y;

        LambdaTestOne noNameClass = new LambdaTestOne();

        System.out.println(noNameClass.operator(1,2,divis));
        System.out.println(noNameClass.operator(2,3,divis));
        //lambda xtn = (a,b,c) -> Math.max(a,Math.max(b,c));

        // int a ;
        // System.out.println(a);

    }

    public interface Converter<T1, T2> {
        void convert(int i);
        //void convert1(int i,String j);
    }

    public interface mathOperator {
        int add(int a,int b);
        // int maxThreeNumber(int x,int y,int z);
    }

    private int operator(int a, int b,mathOperator lambda){
        return lambda.add(a , b);
    }
}
