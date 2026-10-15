/******************************************************************************************
프로그램명 : ToStringEx.java
설명 : 예제 6-2. Point 클래스에 Object의 toString()을 오버라이딩하여
       객체를 사람이 읽기 쉬운 문자열로 리턴하게 만드는 프로그램.
       '객체 + 문자열' 연산은 '객체.toString() + 문자열'로 자동 변환된다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class ToStringEx {
    // 예제 6-1(04_object)의 Point와 클래스 이름이 겹치지 않도록 static 내부 클래스로 작성
    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Object의 toString()을 오버라이딩 : Point 객체를 문자열로 리턴
        @Override
        public String toString() {
            return "Point(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.println(p.toString());     // 직접 호출
        System.out.println(p);                // p는 p.toString()으로 자동 변환
        System.out.println(p + "입니다.");     // p.toString() + "입니다."로 자동 변환

        String s = p + "점"; // 문자열 연결에서도 toString()이 호출된다.
        System.out.println(s);
    }
}
