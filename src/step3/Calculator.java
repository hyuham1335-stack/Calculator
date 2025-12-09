package step3;


import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {

    //속성
    private T num1;
    private T num2;

    //calculate 연산 결과를 저장하는 리스트
    private static List<Number> operateResult = new ArrayList<>();


    //생성자
    Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //기능

    //숫자 2개와 연산 기호를 매개변수로 전달받아 연산 결과 반환
    public double calculate(OperatorType operator) {

        switch (operator) {
            case SUM:
                return num1.doubleValue() + num2.doubleValue();

            case SUB:
                return num1.doubleValue() - num2.doubleValue();

            case MUL:
                return num1.doubleValue() * num2.doubleValue();

            case DIV:
                return num1.doubleValue() / num2.doubleValue();

            default:
                return 0;
        }
    }

    public List getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(double calculeResult) {
        operateResult.add(calculeResult);
    }

    public void removeOperateResult() {
        operateResult.remove(0);
    }
}
