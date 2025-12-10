package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean loopCheck = true;
        Scanner sc = new Scanner(System.in);
        while(loopCheck){

            int a, b;
            char operator;
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
                        System.out.println("연산 결과: " + (a + b));
                        break;

                    case '-':
                        System.out.println("연산 결과: " + (a - b));
                        break;

                    case '*':
                        System.out.println("연산 결과: " + (a * b));
                        break;

                    case '/':
                        try {
                            System.out.println("연산 결과: " + (a / b));
                        } catch (ArithmeticException e) {
                            System.out.println("0으로 나눌 수 없습니다.");
                        }
                        break;

                    default:
                        System.out.println("올바른 사칙연산 기호를 입력해 주세요");
                        operateCheck = true;
                        break;
                }
            }
            sc.nextLine();

            System.out.println("계산을 종료할려면 exit을 입력해 주세요");
            String exitCheck = sc.nextLine();
            if (exitCheck.equals("exit")) {
                loopCheck = false;
            }
        }
        sc.close();
    }
}
