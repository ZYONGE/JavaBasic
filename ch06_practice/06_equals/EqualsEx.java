/******************************************************************************************
프로그램명 : EqualsEx.java
설명 : 예제 6-3. == 연산자는 두 레퍼런스(주소)를 비교하고,
       equals()는 객체의 내용(필드 값)을 비교한다는 것을 확인하는 프로그램.
       Point 클래스에 두 점의 좌표가 같으면 true를 리턴하는 equals()를 오버라이딩한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class EqualsEx {
    // 예제 6-1(04_object)의 Point와 클래스 이름이 겹치지 않도록 static 내부 클래스로 작성
    static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Object의 equals()를 오버라이딩 : x, y 좌표가 모두 같으면 같은 점으로 판단
        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj; // Object 타입을 Point 타입으로 다운캐스팅
            if (x == p.x && y == p.y)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Point a = new Point(2, 3);
        Point b = new Point(2, 3);
        Point c = new Point(3, 4);
        Point d = a; // a와 같은 객체를 가리키는 레퍼런스

        if (a == b) // false : 내용은 같지만 서로 다른 객체(주소가 다름)
            System.out.println("a==b");
        if (a == d) // true : 같은 객체를 가리킴
            System.out.println("a==d");
        if (a.equals(b)) // true : 좌표가 같음
            System.out.println("a is equal to b");
        if (a.equals(c)) // false : 좌표가 다름
            System.out.println("a is equal to c");
    }
}
