/******************************************************************************************
프로그램명 : SensorDriver.java
설명 : com.uslab.device 모듈의 내부 구현 클래스.
       module-info.java에서 exports 하지 않은 패키지(internal)에 있으므로
       같은 모듈 안에서는 사용할 수 있지만 다른 모듈(com.uslab.app)에서는 접근할 수 없다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package com.uslab.device.internal;

public class SensorDriver {
    // 실제 센서 대신 고정된 값에서 조금씩 변하는 온도를 돌려주는 흉내내기(mock) 메소드
    public static double readRawTemperature(int step) {
        return 20.0 + step * 0.5;
    }
}
