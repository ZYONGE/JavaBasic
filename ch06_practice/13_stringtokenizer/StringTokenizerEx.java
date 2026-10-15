/******************************************************************************************
프로그램명 : StringTokenizerEx.java
설명 : 예제 6-9. java.util.StringTokenizer를 이용하여 "홍길동/장화/홍련/콩쥐/팥쥐" 문자열을
       '/'를 구분 문자(delimiter)로 하여 토큰으로 분리하고 각 토큰을 출력하는 프로그램.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.StringTokenizer; // StringTokenizer는 java.util 패키지 소속이므로 import 필요

public class StringTokenizerEx {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/");

        System.out.println("분리된 토큰 개수 : " + st.countTokens()); // 분리한 토큰의 개수

        // 커서는 첫 번째 토큰 바로 앞에서 시작하여 nextToken()을 호출할 때마다 다음으로 이동
        while (st.hasMoreTokens())        // 다음 토큰이 있으면 true
            System.out.println(st.nextToken()); // 다음 토큰 리턴
    }
}
