/******************************************************************************************
프로그램명 : MathEx.java
설명 : 예제 6-10. 산술 연산 메소드를 제공하는 java.lang.Math 클래스를 활용하는 프로그램.
       Math의 모든 메소드는 static이므로 클래스 이름으로 바로 호출하며,
       Math.random()으로 [1, 45] 사이의 난수 5개(행운의 번호)를 발생시킨다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class MathEx {
    public static void main(String[] args) {
        System.out.println(Math.PI); // 원주율 상수

        double a = 3.14;
        System.out.println(Math.ceil(a));     // 올림 : a보다 크거나 같은 가장 작은 정수
        System.out.println(Math.floor(a));    // 내림 : a보다 작거나 같은 가장 큰 정수
        System.out.println(Math.sqrt(9));     // 제곱근
        System.out.println(Math.round(3.14)); // 반올림 (long 타입 리턴)
        System.out.println(Math.abs(-3.14));  // 절댓값
        System.out.println(Math.max(3, 7) + ", " + Math.min(3, 7)); // 최대값, 최소값

        // [1, 45] 사이의 정수형 난수 5개 발생
        // Math.random()은 0.0 이상 1.0 미만의 실수를 리턴하므로
        // *45 하면 0.0~44.99..., +1 하면 1.0~45.99..., (int) 캐스팅하면 1~45의 정수가 된다.
        System.out.print("이번주 행운의 번호는 ");
        for (int i = 0; i < 5; i++)
            System.out.print((int) (Math.random() * 45 + 1) + " ");
        System.out.println();
    }
}
