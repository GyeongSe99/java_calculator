package calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Calculator CALCULATOR = new Calculator();
    private static final DecimalFormat df = new DecimalFormat();

    public static void main(String[] args) {
        System.out.println("Hello, App!");
        while (true) {
            System.out.println("계산을 중단하려면 exit 를 입력해주세요.");

            int num1 = getPositiveInteger("첫 번째 숫자를 입력하세요. (exit입력 시 종료): ");
            int num2 = getPositiveInteger("두 번째 숫자를 입력하세요. (exit입력 시 종료): ");

            char operator = getOperator("사칙연산 기호를 입력하세요. (exit입력 시 종료): ");

            double  result = CALCULATOR.calculate(num1, num2, operator);

            System.out.printf("[결과] %d %s %d = %s \n", num1, operator, num2, df.format(result));

        }

    }

    private static int getPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            handleExit(input);
            try {
                int num = Integer.parseInt(input);

                if (num < 0) {
                    throw new IllegalArgumentException("[Error] : 양의 정수(0 포함)만 입력 가능합니다.");
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("[Error] : 정수를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Exception: " + e.getMessage());
            }
        }
    }

    private static char getOperator(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            handleExit(line);

            if (line.length() == 1) {
                char op = line.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("[Error] : 유효한 사칙연산 기호를 입력해주세요. (+, -, *, /)");
        }
    }

    private static void handleExit(String input) {
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("프로그램을 종료합니다.");
            SCANNER.close();
            System.exit(0);
        }
    }
}