/******************************************************************************************
프로그램명 : Calculator.java
설명 : 강의자료 '이클립스로 쉽게 패키지 만들기(PackageEx)' 실습 중 lib 패키지 부분.
       덧셈/뺄셈/평균을 추상 메소드로 선언한 추상 클래스로,
       다른 패키지(app)의 클래스가 상속할 수 있도록 클래스와 메소드를 public으로 선언한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package lib; // 이 파일을 컴파일한 Calculator.class를 lib 디렉터리(패키지)에 저장하라는 지시

// 다른 패키지(app)의 GoodCalc가 상속하므로 접근 지정자 public을 반드시 붙여야 한다.
// public이 없으면 같은 패키지(lib) 안에서만 사용 가능 -> app 패키지에서 컴파일 오류 발생
public abstract class Calculator {
    public abstract int add(int a, int b);       // 두 정수의 합
    public abstract int subtract(int a, int b);  // 두 정수의 차
    public abstract double average(int[] a);     // 정수 배열의 평균
}
