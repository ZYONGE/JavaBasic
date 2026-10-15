/******************************************************************************************
프로그램명 : AutoBoxingUnBoxingEx.java
설명 : 예제 6-6. 박싱(기본 타입 값 -> Wrapper 객체)과 언박싱(Wrapper 객체 -> 기본 타입 값),
       그리고 JDK 1.5부터 지원되는 자동 박싱/자동 언박싱을 확인하는 프로그램.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class AutoBoxingUnBoxingEx {
    public static void main(String[] args) {
        int n = 10;
        Integer intObject = n; // 자동 박싱. Integer.valueOf(n)으로 자동 처리
        System.out.println("intObject = " + intObject);

        int m = intObject + 10; // 자동 언박싱. intObject.intValue() + 10으로 자동 처리
        System.out.println("m = " + m);

        // 자동 박싱/언박싱이 없던 방식과 비교
        Integer boxed = Integer.valueOf(20); // 수동 박싱
        int unboxed = boxed.intValue();      // 수동 언박싱
        System.out.println("수동 박싱 : " + boxed + ", 수동 언박싱 : " + unboxed);

        // 다른 타입에서도 동일하게 동작
        Double dObject = 3.14;   // 자동 박싱
        double dValue = dObject; // 자동 언박싱
        Character cObject = 'K'; // 자동 박싱
        char cValue = cObject;   // 자동 언박싱
        Boolean bObject = true;  // 자동 박싱
        boolean bValue = bObject; // 자동 언박싱
        System.out.println(dValue + ", " + cValue + ", " + bValue);
    }
}
