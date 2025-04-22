# java_calculator
내일배움캠프 Chapter2. 자바 프로젝트 - 계산기 만들기

## 개요
해당 프로젝트는 Java의 문법을 학습하기 위해 진행된 프로젝트입니다.
자바의 기본 문법, 객체지향 코드, Enum, 제네릭, 람다, 스트림을 적용하여 구현하였습니다.


calculator 패키지는 다음 두 가지 계산기 앱을 제공합니다.
**1. App**
  - 정수(int) 기반의 기본 사칙연산을 수행
  - Calculator 및 ArithmeticCalculator 두 가지 구현체 비교

**2. App2**
  - 실수(double) 및 정수(int) 모두 처리 가능한 제네릭 계산기
  - 메뉴를 통해 연산 수행, 저장된 결과 중 기준값 초과 결과 필터링
    
## 클래스 설명
### 1. Calculator
- 기본 사칙연산 메소드 구현
- double calculate(int a, int b, char operator)
  - 숫자 두개와 연산자를 매개변수로 받아 클래스 내부에 구현되어있는 사칙연산 메소드를 이용하여 계산결과 리턴.
  - 연산 결과를 내부 컬렉션에 저장
 
### 2. ArithmeticCalculator
- 기존 Calculator 에 enum 기반 운영 타입 분리 적용 버전
- double calculate(int a, int b, char operator)
  - OperatorType.fromSymbol(operator) 로 알맞은 연산자 선택
  - void deleteFirstResult() – 가장 첫 번째 결과 삭제

### 3. OperatorType
- 추상메서드를 이용하여 심볼(+, -, *, /) 별로 apply 구현
- fromSymbol 으로 char → OperatorType 매핑

### 4. GenericCalculator
- 제네릭 타입(Number 하위) 연산 지원
- <S extends Number, U extends Number> double calculate(S num1, U num2, char operator)
  - 다양한 타입의 숫자를 받아 doubleValue() 로 변환 후 switch 로 연산
- void printResultsGreaterThan(double num)
  - 저장된 결과 중 num 보다 큰 값만 포맷팅 출력
 
### 5. App
정수 연산용 콘솔 애플리케이션
- main
  - handleExit(String input)를 사용하여 “exit” 입력 시 종료
  - getPositiveInteger → 양의 정수 입력 받기
  - getOperator → 사칙연산 기호 검증
  - alculator vs ArithmeticCalculator 결과 비교 출력

### 6. App2
- 제네릭 계산기용 메뉴 기반 콘솔 애플리케이션
- showMenu(), doCalculation(), printResultsGreaterThan(), exitProgram()
