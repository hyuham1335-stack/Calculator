package step3;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // 계산 결과 리스트 출력
    public void getOperateResult() {

        System.out.println("연산 결과 List: " + operateResult);
    }

    // 전달 받은 값 이상의 데이터를 계산 결과 리스트에서 출력
    public void showOperateResult(double minNum) {
        List<Number> list = operateResult.stream()
                        .filter(num -> num.doubleValue() >= minNum)
                        .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("리스트에 조건에 맞는 데이터가 존재하지 않습니다.");
        } else {
            System.out.println("검색 결과 List : " + list);
        }
    }

    // 계산 결과를 리스트에 추가
    public void addOperateResult(double calculeResult) {
        operateResult.add(calculeResult);
    }

    // 계산 결과 리스트의 맨 처음 값 제거
    public void removeOperateResult() {

        if(operateResult.isEmpty()){
            System.out.println("리스트에 데이터가 존재하지 않습니다.");
        } else {
            System.out.println("리스트에서 " + operateResult.get(0) + "삭제");
            operateResult.remove(0);
        }
    }

}
