package calculator;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class GenericCalculator {
    private final List<Double> results;
    private static final DecimalFormat df = new DecimalFormat();

    public <S extends Number, U extends Number> double calculate(S num1, U num2, char operator) {
        double doubleNum1 = num1.doubleValue();
        double doubleNum2 = num2.doubleValue();
        double result = 0;

        switch (operator) {
            case '+':
                result = doubleNum1 + doubleNum2;
                break;
            case '-':
                result = doubleNum1 - doubleNum2;
                break;
            case '*':
                result = doubleNum1 * doubleNum2;
                break;
            case '/':
                if (doubleNum2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = doubleNum1 / doubleNum2;
                break;
            default:
                System.out.println("[Error] : 알 수 없는 연산자입니다.");
        }

        this.results.add(result);
        return result;
    }

    public GenericCalculator() {
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

    public void printResultsGreaterThan(double num) {
        System.out.printf("기준값(%s)보다 큰 결과들: \n", df.format(num));
        results.stream()
                .filter(r -> r > num)
                .forEach(r -> System.out.print(" " + df.format(r)));
        System.out.println();
    }


}