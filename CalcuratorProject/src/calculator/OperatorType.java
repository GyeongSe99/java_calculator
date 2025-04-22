package calculator;

public enum OperatorType {
    ADD('+') {
        @Override
        public double apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT('-') {
        @Override
        public double apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY('*') {
        @Override
        public double apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE('/') {
        @Override
        public double apply(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return (double) a / b;
        }
    };

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("알 수 없는 연산자입니다: " + symbol);
    }

    public abstract double apply(int a, int b);
}