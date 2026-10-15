/******************************************************************************************
프로그램명 : Circle.java
설명 : 연습문제 01. Shape을 상속받아 draw()를 오버라이딩한 원 클래스를 component 패키지로 분리한 파일.
       수퍼 클래스 Shape이 다른 패키지(graphic)에 있으므로 import로 경로명을 알려 주어야 한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package component; // 컴파일된 Circle.class를 component 디렉터리(패키지)에 저장

import graphic.Shape; // 다른 패키지에 있는 수퍼 클래스의 경로명(graphic.Shape)을 컴파일러에게 알림

public class Circle extends Shape { // 패키지가 달라도 public 클래스이므로 상속 가능

    // 수퍼 클래스의 draw()를 오버라이딩
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
