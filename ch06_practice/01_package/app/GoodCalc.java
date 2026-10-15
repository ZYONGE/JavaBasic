/******************************************************************************************
프로그램명 : GoodCalc.java
설명 : 강의자료 '이클립스로 쉽게 패키지 만들기(PackageEx)' 실습 중 app 패키지 부분.
       lib 패키지의 추상 클래스 Calculator를 import하여 상속받고
       add(), subtract(), average()를 구현한 뒤 main()에서 실행 결과를 출력한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package app; // 컴파일된 GoodCalc.class를 app 디렉터리(패키지)에 저장

import lib.Calculator; // 다른 패키지에 있는 클래스의 경로명(lib.Calculator)을 컴파일러에게 알림
                       // import가 없으면 lib.Calculator c = new GoodCalc(); 처럼 전체 경로명을 써야 한다.

public class GoodCalc extends Calculator { // 패키지가 달라도 public 클래스이므로 상속 가능

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double average(int[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length; // 배열 원소의 합을 개수로 나눈 평균
    }

    public static void main(String[] args) {
        Calculator c = new GoodCalc(); // 수퍼 클래스 타입(lib.Calculator)으로 업캐스팅
        System.out.println(c.add(2, 3));
        System.out.println(c.subtract(2, 3));
        System.out.println(c.average(new int[] { 2, 3, 4 }));

        // 클래스의 경로명(패키지명 + 클래스명) 확인
        System.out.println("이 객체의 경로명 : " + c.getClass().getName());
        System.out.println("수퍼 클래스의 경로명 : " + c.getClass().getSuperclass().getName());
    }
}
