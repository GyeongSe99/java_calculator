package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Double> results = new ArrayList<>();

    public double calculate(int num1, int num2, char operator) {
        double result = 0;
        try {
            switch (operator) {
                case '+':
                    result = add(num1, num2);

                    break;
                case '-':
                    result = subtract(num1, num2);
                    results.add(result);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    results.add(result);
                    break;
                case '/':
                    result = divide(num1, num2);
                    results.add(result);
                    break;
                default:
                    System.out.println("[Error] : 알 수 없는 연산자입니다.");
            }
        } catch (ArithmeticException e) {
            System.out.println("[Error] : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[Error] : 연산 중 오류가 발생했습니다. (" + e.getMessage() + ")");
        }

        results.add(result);
        return result;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double) a / b;
    }
}
