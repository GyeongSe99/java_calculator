package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, Calculator!");

        int num1 = getPositiveInteger("첫 번째 숫자를 입력하세요: ");
        int num2 = getPositiveInteger("두 번째 숫자를 입력하세요: ");

        char operator = getOperator("사칙연산 기호를 입력하세요: ");

        try {
            switch (operator) {
                case '+':
                    System.out.printf("[결과] %d + %d = %d%n", num1, num2, add(num1, num2));
                    break;
                case '-':
                    System.out.printf("[결과] %d - %d = %d%n", num1, num2, subtract(num1, num2));
                    break;
                case '*':
                    System.out.printf("[결과] %d * %d = %d%n", num1, num2, multiply(num1, num2));
                    break;
                case '/':
                    System.out.printf("[결과] %d / %d = %f%n", num1, num2, divide(num1, num2));
                    break;
                default:
                    System.out.println("[Error] : 알 수 없는 연산자입니다.");
            }
        } catch (ArithmeticException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[Error] : 연산 중 오류가 발생했습니다. (" + e.getMessage() + ")");
        }

        SCANNER.close();
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double) a / b;
    }

    private static int getPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = SCANNER.nextInt();
                SCANNER.nextLine();

                if (input < 0) {
                    throw new IllegalArgumentException("[Error] : 양의 정수(0 포함)만 입력 가능합니다.");
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("[Error] : 정수를 입력해주세요.");
                SCANNER.nextLine();
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
