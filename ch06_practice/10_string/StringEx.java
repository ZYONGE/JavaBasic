/******************************************************************************************
프로그램명 : StringEx.java
설명 : 예제 6-7. java.lang.String 클래스의 주요 메소드
       length(), contains(), concat(), trim(), replace(), split(), substring(), charAt()을
       차례로 활용하여 문자열이 어떻게 변해 가는지 확인하는 프로그램.
       String 객체는 수정 불가능(immutable)하므로 메소드는 새로운 문자열을 리턴한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

public class StringEx {
    public static void main(String[] args) {
        String a = new String(" C#");
        String b = new String(",C++ ");

        System.out.println(a + "의 길이는 " + a.length()); // 문자열의 길이(문자 개수)
        System.out.println(a.contains("#"));              // 인자로 전달한 문자열의 포함 여부

        a = a.concat(b); // 문자열 연결 (새로운 문자열을 리턴하므로 다시 a에 대입해야 함)
        System.out.println(a);

        a = a.trim(); // 문자열 앞뒤의 공백 제거 (중간의 공백은 제거되지 않음)
        System.out.println(a);

        a = a.replace("C#", "Java"); // 문자열 대치
        System.out.println(a);

        String s[] = a.split(","); // ','를 기준으로 문자열 분리
        for (int i = 0; i < s.length; i++)
            System.out.println("분리된 문자열" + i + ": " + s[i]);

        a = a.substring(5); // 인덱스 5부터 끝까지 서브 스트링 리턴
        System.out.println(a);

        char c = a.charAt(2); // 인덱스 2의 문자 리턴
        System.out.println(c);
    }
}
