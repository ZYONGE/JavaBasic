/******************************************************************************************
프로그램명 : ObjectPropertyEx.java
설명 : 예제 6-1. 모든 클래스의 수퍼 클래스인 java.lang.Object의 메소드를 이용하여
       객체 레퍼런스만으로 클래스명, 해시코드 값, 객체의 문자열을 알아내는 프로그램.
       Object의 toString()은 '클래스명@16진수해시코드' 형식의 문자열을 리턴한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ObjectPropertyEx {
    // Object 타입 매개변수 -> 모든 객체를 받을 수 있다(모든 클래스는 Object를 상속)
    public static void print(Object obj) {
        System.out.println(obj.getClass().getName()); // 런타임에 객체가 속한 클래스의 이름
        System.out.println(obj.hashCode());           // 객체를 식별하는 고유한 정수 값
        System.out.println(obj.toString());           // 객체를 문자열로 만들어 출력
        System.out.println(obj);                      // obj.toString()으로 자동 변환되어 출력
    }

    public static void main(String[] args) {
        Point p = new Point(2, 3);
        print(p);

        // hashCode()를 16진수로 바꾸면 toString()이 보여 주는 값과 같다.
        System.out.println("해시코드를 16진수로 : " + Integer.toHexString(p.hashCode()));
    }
}
