package calculator.service.factory;

import calculator.service.OperatorFactory;
import calculator.service.OperatorService;
import calculator.service.impl.MulImpl;

public class MulFactory implements OperatorFactory {
    @Override
    public OperatorService getOperator() {
        return new MulImpl();
    }
}
