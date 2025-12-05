package step2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean loopCheck = true;
        Calculator calculator = new Calculator();

        while(loopCheck){
            Scanner sc = new Scanner(System.in);
            int a, b;
            char operator = '\0';
            boolean operateCheck = true;

            while (true) {
                try {
                    System.out.print("첫번째 숫자를 입력해 주세요: ");
                    a = sc.nextInt();
                    if (a < 0) {
                        System.out.println("0 이상의 정수만 입력 가능합니다.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("0 이상의 정수만 입력 가능합니다.");
                    sc.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("두번째 숫자를 입력해 주세요: ");
                    b = sc.nextInt();
                    if (b < 0) {
                        System.out.println("0 이상의 정수만 입력 가능합니다.");
                    } else {
                        break;
                    }
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
                        break;

                    case '-':
                        break;

                    case '*':
                        break;

                    case '/':
                        if(b == 0)
                        {
                            System.out.println("0으로 나눌 수 없습니다.");
                            operateCheck = true;
                        }
                        break;

                    default:
                        System.out.println("올바른 사칙연산 기호를 입력해 주세요");
                        operateCheck = true;
                        break;
                }
                sc.nextLine();
            }

            int calculateResult = calculator.calculate(a, b, operator);
            calculator.setOperateResult(calculateResult);

            System.out.println(calculator.getOperateResult());

            System.out.println("계산을 종료할려면 exit을 입력해 주세요");
            String exitCheck = sc.nextLine();
            if (exitCheck.equals("exit")) {
                loopCheck = false;
            }
        }

    }
}
