/******************************************************************************************
프로그램명 : StringBufferEx.java
설명 : 예제 6-8. 가변 크기의 문자열을 저장하는 java.lang.StringBuffer를 이용하여
       append(), insert(), replace(), delete(), setLength(), reverse()로 문자열을 조작하는 프로그램.
       String과 달리 StringBuffer는 객체 자신의 내용이 변경된다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class StringBufferEx {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This"); // 지정된 문자열로 초기화된 스트링 버퍼 생성

        sb.append(" is pencil"); // 문자열 덧붙이기
        System.out.println(sb);  // sb.toString()으로 자동 변환되어 출력

        sb.insert(7, " my"); // 인덱스 7의 위치에 " my" 삽입
        System.out.println(sb);

        sb.replace(8, 10, "your"); // 인덱스 8 ~ 9("my")를 "your"로 대치
        System.out.println(sb);

        sb.delete(8, 13); // 인덱스 8 ~ 12("your ") 삭제
        System.out.println(sb);

        sb.setLength(4); // 문자열 길이를 4로 재설정 (뒷부분이 잘림)
        System.out.println(sb);

        System.out.println("현재 버퍼 크기(capacity) : " + sb.capacity()); // 가변 크기 버퍼의 현재 용량
        System.out.println("거꾸로 : " + sb.reverse());                   // 문자 순서 반대로 변경
    }
}
