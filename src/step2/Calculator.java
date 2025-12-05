package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //속성

    //calculate 연산 결과를 저장하는 리스트
    private List<Integer> operateResult = new ArrayList<>();


    //생성자


    //기능

    //양의 정수 2개와 연산 기호를 매개변수로 전달받아 연산 결과 반환
    public int calculate(int num1, int num2, char operator) {

        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
        }
        return result;
    }

    public List getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(int calculeResult) {
        operateResult.add(calculeResult);
    }

    public void removeOperateResult() {
        operateResult.remove(0);
    }
}
