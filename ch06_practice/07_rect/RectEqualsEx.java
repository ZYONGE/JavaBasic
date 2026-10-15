/******************************************************************************************
프로그램명 : RectEqualsEx.java
설명 : 예제 6-4. int 타입의 width(너비)와 height(높이) 필드를 가지는 Rect 클래스를 작성하고,
       면적이 같으면 두 Rect 객체를 같은 것으로 판별하는 equals()를 작성하는 프로그램.
       생성자에서 너비와 높이를 받아 필드를 초기화한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

class Rect {
    private int width;
    private int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 면적(width * height)이 같으면 두 사각형을 같은 것으로 판별
    @Override
    public boolean equals(Object obj) {
        Rect p = (Rect) obj;
        if (width * height == p.width * p.height)
            return true;
        else
            return false;
    }

    // 어떤 사각형끼리 비교했는지 쉽게 알아보기 위해 toString()도 함께 오버라이딩
    @Override
    public String toString() {
        return "Rect(" + width + "x" + height + ", 면적=" + (width * height) + ")";
    }
}

public class RectEqualsEx {
    public static void main(String[] args) {
        Rect a = new Rect(2, 3); // 면적 6
        Rect b = new Rect(3, 2); // 면적 6
        Rect c = new Rect(3, 4); // 면적 12

        System.out.println("a = " + a + ", b = " + b + ", c = " + c);

        if (a.equals(b)) // true : 면적이 모두 6
            System.out.println("a is equal to b");
        if (a.equals(c)) // false
            System.out.println("a is equal to c");
        if (b.equals(c)) // false
            System.out.println("b is equal to c");
    }
}
