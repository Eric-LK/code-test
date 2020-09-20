package calculator.service.factory;

import calculator.service.OperatorFactory;
import calculator.service.OperatorService;
import calculator.service.impl.AddImpl;

public class AddFactory implements OperatorFactory {

    @Override
    public OperatorService getOperator() {
        return new AddImpl();
    }
}
