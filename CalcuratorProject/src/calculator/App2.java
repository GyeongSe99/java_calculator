package calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App2 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GenericCalculator GENERIC_CALCULATOR = new GenericCalculator();
    private static final DecimalFormat df = new DecimalFormat();

    public static void main(String[] args) {
        System.out.println("=== Generic Calculator App ===");

        while (true) {
            showMenu();
            String choice = SCANNER.nextLine().trim();

            switch (choice) {
                case "1":
                    doCalculation();
                    break;
                case "2":
                    printResultsGreaterThan();
                    break;
                case "3":
                    exitProgram();
                    break;
                default:
                    System.out.println("[Error] : 올바른 메뉴를 선택하세요. (1, 2, 3)");
            }
        }
    }

    private static void exitProgram() {
        System.out.println("프로그램을 종료합니다.");
        SCANNER.close();
        System.exit(0);
    }

    private static void printResultsGreaterThan() {
        double num = getNumber("기준값을 입력하세요 (exit 입력 시 종료): ");
        GENERIC_CALCULATOR.printResultsGreaterThan(num);
    }

    private static void showMenu() {
        System.out.println("\n[Menu]");
        System.out.println("1. 계산하기");
        System.out.println("2. 저장된 값중 기준값보다 큰 결과 리스트 보기");
        System.out.println("3. 종료");
        System.out.print("선택> ");
    }

    private static void doCalculation() {
        double num1 = getNumber("첫 번째 숫자를 입력하세요 (exit 입력 시 종료): ");
        double num2 = getNumber("두 번째 숫자를 입력하세요 (exit 입력 시 종료): ");
        char operator = getOperator("사칙연산 기호를 입력하세요 (+, -, *, /) (exit 입력 시 종료): ");

        try {
            double result = GENERIC_CALCULATOR.calculate(num1, num2, operator);
            System.out.printf("[결과] %s %c %s = %s%n",
                    df.format(num1), operator, df.format(num2), df.format(result));
        } catch (ArithmeticException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[Error] : 연산 중 오류가 발생했습니다. (" + e.getMessage() + ")");
        }
    }

    private static double getNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            handleExit(input);

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("[Error] : 유효한 숫자를 입력해주세요.");
            }
        }
    }

    private static char getOperator(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            handleExit(input);

            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("[Error] : 유효한 사칙연산 기호를 입력해주세요. (+, -, *, /)");
        }
    }

    private static void handleExit(String input) {
        if (input.equalsIgnoreCase("exit")) {
            exitProgram();
        }
    }
}
