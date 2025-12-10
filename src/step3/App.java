package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean loopCheck = true;
        Scanner sc = new Scanner(System.in);

        while(loopCheck){

            double a, b;
            char operator = '\0';
            boolean operateCheck = true;
            OperatorType operatorType = null;

            while (true) {
                try {
                    System.out.print("첫번째 숫자를 입력해 주세요: ");
                    a = sc.nextDouble();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("0 이상의 정수만 입력 가능합니다.");
                    sc.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("두번째 숫자를 입력해 주세요: ");
                    b = sc.nextDouble();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("0 이상의 정수만 입력 가능합니다.");
                    sc.nextLine();
                }
            }

            while (operateCheck) {
                operateCheck = false;

                System.out.print("사칙연산 기호를 입력해 주세요: ");
                operator = sc.next().charAt(0);

                switch (operator) {
                    case '+':
                        operatorType = OperatorType.SUM;
                        break;

                    case '-':
                        operatorType = OperatorType.SUB;
                        break;

                    case '*':
                        operatorType = OperatorType.MUL;
                        break;

                    case '/':
                        if (b == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            operateCheck = true;
                        } else {
                            operatorType = OperatorType.DIV;
                        }
                        break;

                    default:
                        System.out.println("올바른 사칙연산 기호를 입력해 주세요");
                        operateCheck = true;
                        break;
                }
                sc.nextLine();
            }

            // Calculator 객체 생성
            Calculator<Double> calculator = new Calculator<>(a, b);

            double calculateResult = calculator.calculate(operatorType);
            calculator.addOperateResult(calculateResult);
            calculator.getOperateResult();

            System.out.println("====== 계산 종료 ======");

            boolean operateSelection = true;

            while (operateSelection) {

                System.out.println("====== 동작 선택 ======");

                System.out.println("1. 연산 결과 데이터 삭제");
                System.out.println("2. 검색 최솟값 설정 후 검색");
                System.out.println("3. 계산을 계속 진행");
                System.out.println("4. 계산을 종료");
                System.out.print("번호 입력 : ");

                try {
                    int operateNum = sc.nextInt();
                    sc.nextLine();
                    switch (operateNum) {
                        case 1:
                            System.out.print("첫번째 연산 결과 데이터를 삭제하려면 remove를 입력해 주세요 : ");
                            String removeCheck = sc.nextLine();
                            if(removeCheck.equals("remove")){
                                calculator.removeOperateResult();
                            } else {
                                System.out.println("입력이 잘못되었습니다.");
                            }
                            break;

                        case 2:
                            System.out.print("검색 최솟값 설정을 위한 값을 입력해주세요 : ");
                            String minString = sc.nextLine();

                            try {
                                double minNum = Double.parseDouble(minString);
                                calculator.showOperateResult(minNum);
                            } catch (NumberFormatException e) {
                                System.out.println("입력이 잘못되었습니다.");
                            }
                            break;

                        case 3:
                            operateSelection = false;
                            break;

                        case 4:
                            System.out.print("계산을 종료할려면 exit을 입력해 주세요 : ");
                            String exitCheck = sc.nextLine();
                            if (exitCheck.equals("exit")) {
                                loopCheck = false;
                                operateSelection = false;
                            } else {
                                System.out.println("입력이 잘못되었습니다.");
                            }
                            break;

                        default:
                            System.out.println("1~4 까지의 정수만 입력 가능합니다.");
                    }
                } catch (InputMismatchException e){
                    System.out.println("1~4 까지의 정수만 입력 가능합니다.");
                    sc.nextLine();
                }
            }
        }

        sc.close();
    }
}
