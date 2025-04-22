package calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private final List<Double> results;

    public double calculate(int num1, int num2, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = this.add(num1, num2);
                break;
            case '-':
                result = this.subtract(num1, num2);
                break;
            case '*':
                result = this.multiply(num1, num2);
                break;
            case '/':
                result = this.divide(num1, num2);
                break;
            default:
                System.out.println("[Error] : 알 수 없는 연산자입니다.");
        }

        this.results.add(result);
        return result;
    }

    public Calculator() {
        this.results = new LinkedList<>();
    }

    public List<Double> getResults() {
        return this.results;
    }

    public void setResults(List<Double> newResults) {
        this.results.clear();
        if (newResults != null) {
            this.results.addAll(newResults);
        }
    }

    public void deleteFirstResult() {
        this.results.remove(0);
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
