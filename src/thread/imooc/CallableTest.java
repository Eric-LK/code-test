package thread.imooc;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("CallableTest");
        return 123;
    }
}
