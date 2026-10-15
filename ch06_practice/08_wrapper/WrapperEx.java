/******************************************************************************************
프로그램명 : WrapperEx.java
설명 : 예제 6-5. 자바의 기본 타입을 클래스화한 Wrapper 클래스(Character, Integer, Double, Boolean 등)의
       주요 메소드를 활용하는 프로그램. Wrapper 클래스의 메소드는 대부분 static 타입이므로
       클래스 이름으로 바로 호출한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class WrapperEx {
    public static void main(String[] args) {
        System.out.println(Character.toLowerCase('A')); // 'A'를 소문자로 변환

        char c1 = '4', c2 = 'F';
        if (Character.isDigit(c1)) // 문자 c1이 숫자이면 true
            System.out.println(c1 + "는 숫자");
        if (Character.isAlphabetic(c2)) // 문자 c2가 영문자이면 true
            System.out.println(c2 + "는 영문자");

        System.out.println(Integer.parseInt("-123"));     // 문자열 "-123"을 10진수 정수로 변환
        System.out.println(Integer.toHexString(28));      // 정수 28을 16진수 문자열로 변환
        System.out.println(Integer.toBinaryString(28));   // 정수 28을 2진수 문자열로 변환
        System.out.println(Integer.bitCount(28));         // 28의 2진수에 포함된 1의 개수

        Double d = Double.valueOf(3.14);                  // 기본 타입 값으로 Wrapper 객체 생성
        System.out.println(d.toString());                 // Double 객체를 문자열 "3.14"로 변환
        System.out.println(Double.parseDouble("3.14"));    // 문자열을 실수 3.14로 변환

        boolean b = (4 > 3);                              // b는 true
        System.out.println(Boolean.toString(b));          // true를 문자열 "true"로 변환
        System.out.println(Boolean.parseBoolean("false")); // 문자열 "false"를 false로 변환

        // Wrapper 객체로부터 기본 타입 값 알아내기 (언박싱 메소드)
        Integer i = Integer.valueOf("10"); // 문자열로 Wrapper 객체 생성
        int ii = i.intValue();             // Integer -> int
        Character ch = Character.valueOf('c');
        char cc = ch.charValue();          // Character -> char
        System.out.println("intValue() : " + ii + ", charValue() : " + cc);

        // Integer 클래스의 상수 : 표현할 수 있는 정수의 최대/최소값
        System.out.println("int의 최대값 : " + Integer.MAX_VALUE + ", 최소값 : " + Integer.MIN_VALUE);
    }
}
