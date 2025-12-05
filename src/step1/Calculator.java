package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a, b;

        while (true)
        {
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

        while (true)
        {
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
    }
}
