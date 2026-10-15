/******************************************************************************************
프로그램명 : AppMain.java
설명 : com.uslab.app 모듈의 실행 클래스.
       requires로 선언한 com.uslab.device 모듈의 공개 클래스(Thermometer)를 사용하고,
       자신이 속한 모듈/패키지 정보를 출력하여 모듈과 패키지의 관계를 확인한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package com.uslab.app.api;

import com.uslab.device.api.Thermometer; // exports된 패키지의 클래스이므로 import 가능

// import com.uslab.device.internal.SensorDriver;
// -> 위 줄의 주석을 풀면 "package com.uslab.device.internal is not visible" 컴파일 오류 발생.
//    exports 하지 않은 패키지는 다른 모듈에서 보이지 않는다(모듈의 캡슐화).

public class AppMain {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();

        System.out.println("=== 모듈 com.uslab.app 실행 ===");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d회 측정 : %.1f℃%n", i + 1, thermometer.readCelsius());
        }
        System.out.println(thermometer);

        // 실행 중인 클래스가 어느 모듈/패키지에 속하는지 확인 (JDK 9 이상)
        Class<?> appClass = AppMain.class;
        Class<?> deviceClass = Thermometer.class;
        System.out.println("AppMain 패키지 : " + appClass.getPackageName()
                + ", 모듈 : " + appClass.getModule().getName());
        System.out.println("Thermometer 패키지 : " + deviceClass.getPackageName()
                + ", 모듈 : " + deviceClass.getModule().getName());
        System.out.println("String 클래스의 모듈 : " + String.class.getModule().getName()); // java.base
    }
}
