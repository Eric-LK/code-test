package calculator.service.impl;

import calculator.service.OperatorService;

public class AddImpl implements OperatorService {

    @Override
    public Integer getResult(int a, int b) {
        return a+b;
    }

}
