package calculator.service.factory;

import calculator.service.OperatorFactory;
import calculator.service.OperatorService;
import calculator.service.impl.SubtractImpl;

public class SubtractFactory implements OperatorFactory {

    @Override
    public OperatorService getOperator() {
        return new SubtractImpl();
    }
}
