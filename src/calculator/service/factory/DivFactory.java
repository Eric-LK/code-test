package calculator.service.factory;

import calculator.service.OperatorFactory;
import calculator.service.OperatorService;
import calculator.service.impl.DivImpl;

public class DivFactory implements OperatorFactory {

    @Override
    public OperatorService getOperator() {
        return new DivImpl();
    }
}
