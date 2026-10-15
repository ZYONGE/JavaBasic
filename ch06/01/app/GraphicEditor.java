/******************************************************************************************
프로그램명 : GraphicEditor.java
설명 : 연습문제 01. Shape 클래스는 graphic 패키지, Circle 클래스는 component 패키지,
       GraphicEditor 클래스는 app 패키지로 분리하여 작성한 프로그램.
       main()에서 Shape 타입 레퍼런스로 Circle 객체를 가리키고(업캐스팅) draw()를 호출하면
       오버라이딩된 Circle의 draw()가 실행되어 "Circle"이 출력된다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package app; // 컴파일된 GraphicEditor.class를 app 디렉터리(패키지)에 저장

import component.Circle; // component 패키지의 Circle 클래스 사용
import graphic.Shape;    // graphic 패키지의 Shape 클래스 사용
                         // import가 없으면 graphic.Shape, component.Circle처럼 전체 경로명을 써야 한다.

public class GraphicEditor {
    public static void main(String[] args) {
        Shape shape = new Circle(); // 수퍼 클래스 타입으로 서브 클래스 객체를 가리킴(업캐스팅)
        shape.draw();               // 동적 바인딩에 의해 Circle의 draw()가 호출됨 -> "Circle" 출력

        // 참고 : 각 클래스의 경로명은 패키지명을 포함하여
        //        graphic.Shape, component.Circle, app.GraphicEditor가 된다.
        //        (Shape.class.getName(), shape.getClass().getName()으로 확인 가능)
    }
}
