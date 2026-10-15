/******************************************************************************************
프로그램명 : Thermometer.java
설명 : com.uslab.device 모듈이 외부에 공개(exports)하는 API 클래스.
       내부 패키지(internal)의 SensorDriver를 이용해 온도를 읽어 주지만,
       다른 모듈은 내부 구현을 모른 채 이 공개 클래스만 사용한다(캡슐화).
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

package com.uslab.device.api;

import com.uslab.device.internal.SensorDriver; // 같은 모듈 안이므로 internal 패키지 사용 가능

public class Thermometer {
    private int step = 0; // 측정 횟수

    // 섭씨 온도 측정
    public double readCelsius() {
        return SensorDriver.readRawTemperature(step++);
    }

    // 화씨 온도로 변환하여 측정
    public double readFahrenheit() {
        return readCelsius() * 9 / 5 + 32;
    }

    @Override
    public String toString() {
        return "Thermometer(측정횟수=" + step + ")";
    }
}
