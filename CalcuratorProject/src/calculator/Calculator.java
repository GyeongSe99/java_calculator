package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, Calculator!");

        int num1 = getPositiveInteger("첫 번째 숫자를 입력하세요: ");
        int num2 = getPositiveInteger("두 번째 숫자를 입력하세요: ");

        System.out.println(num1);
        System.out.println(num2);

        char operator = getOperator("사칙연산 기호를 입력하세요: ");
    }

    private static int getPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = SCANNER.nextInt();
                if (input < 0) {
                    throw new IllegalArgumentException("[Error] : 양의 정수(0 포함)만 입력 가능합니다.");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("[Error] : 정수를 입력해주세요.");
                SCANNER.next(); // 잘못된 토큰 제거
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static char getOperator(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            if (line.length() == 1) {
                char op = line.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("[Error] : 유효한 사칙연산 기호를 입력해주세요. (+, -, *, /)");
        }
    }
}
