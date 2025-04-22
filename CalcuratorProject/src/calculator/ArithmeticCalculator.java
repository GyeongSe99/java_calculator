package calculator;

import java.util.LinkedList;
import java.util.List;

public class ArithmeticCalculator {
    private final List<Double> results;

    public ArithmeticCalculator() {
        this.results = new LinkedList<>();
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> newResults) {
        this.results.clear();
        if (newResults != null) {
            this.results.addAll(newResults);
        }
    }

    public double calculate(int num1, int num2, char operator) {
        double result = OperatorType.fromSymbol(operator).apply(num1, num2);
        this.results.add(result);
        return result;
    }

    public void deleteFirstResult() {
        this.results.remove(0);
    }
}