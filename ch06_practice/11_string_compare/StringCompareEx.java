/******************************************************************************************
프로그램명 : StringCompareEx.java
설명 : 강의자료 '스트링 리터럴과 new String()', '스트링 객체의 주요 특징', '문자열 비교' 보충 실습.
       (1) 리터럴로 생성한 문자열은 JVM이 관리하며 공유되고, new String()은 힙에 새 객체를 만든다.
       (2) ==는 참조 주소를 비교하므로 문자열 내용 비교에는 equals()를 사용해야 한다.
       (3) compareTo()는 사전 순(유니코드 값)으로 비교하여 음수/0/양수를 리턴한다.
       (4) trim()과 charAt()을 이용해 문자열 속 특정 문자의 개수를 센다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Arrays; // toCharArray() 결과를 보기 좋게 출력하기 위해 사용

public class StringCompareEx {
    public static void main(String[] args) {
        // (1) (2) 리터럴 생성과 new String() 생성의 차이
        String a = "Hello";             // 리터럴로 생성 (JVM이 관리, 응용프로그램 내에서 공유)
        String b = "Hello";             // a와 동일한 리터럴이므로 같은 객체를 공유
        String c = new String("Hello"); // 힙 메모리에 완전히 새로운 객체 생성

        System.out.println("a == b : " + (a == b));           // true  : 같은 주소를 가리킴
        System.out.println("a == c : " + (a == c));           // false : 주소가 다름
        System.out.println("a.equals(c) : " + a.equals(c));   // true  : 내용이 같음

        // (3) compareTo()로 사전 순 비교 (유니코드 값으로 비교, 'A'=0x41, 'a'=0x61)
        String java = "Java";
        String cpp = "C++";
        int res = java.compareTo(cpp);
        if (res == 0)
            System.out.println("the same");
        else if (res < 0)
            System.out.println(java + " < " + cpp);
        else
            System.out.println(java + " > " + cpp); // "Java"가 "C++"보다 사전에 나중 -> 양수

        // 문자열 연결 : 피연산자에 문자열이 있으면 나머지는 모두 문자열로 변환되어 연결
        System.out.println("abcd" + 1 + true + 3.13e-2 + 'E' + "fgh");
        System.out.println("I love ".concat("Java.")); // concat()은 새로운 문자열을 리턴

        // (4) trim() : 앞뒤의 공백 문자(스페이스, 탭, 개행) 제거
        String withSpace = "      abcd def ";
        String withTab = "      xyz\t";
        System.out.println("[" + withSpace.trim() + "]"); // 중간 공백은 남는다
        System.out.println("[" + withTab.trim() + "]");

        // charAt()으로 문자열의 각 문자에 접근하여 's'의 개수 세기
        int count = 0;
        String word = "class";
        for (int i = 0; i < word.length(); i++) { // word.length()는 5
            if (word.charAt(i) == 's')
                count++;
        }
        System.out.println("\"" + word + "\"에 포함된 's'의 개수 : " + count);

        // 그 외 자주 쓰는 메소드
        System.out.println("대문자로 : " + word.toUpperCase());
        System.out.println("문자 배열로 : " + Arrays.toString(word.toCharArray()));
    }
}
