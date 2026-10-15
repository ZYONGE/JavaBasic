/******************************************************************************************
프로그램명 : QueryTokenEx.java
설명 : 강의자료 'StringTokenizer 객체 생성과 문자열 분리' 보충 실습.
       (1) 질의 문자열(name=kitae&addr=seoul&age=21)을 '&'와 '='를 구분 문자로 분리하고,
       (2) "&=" 처럼 문자열 자체를 기준으로 분리할 때는 StringTokenizer가 아니라
           String의 split()을 사용해야 한다는 차이를 확인한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Arrays;
import java.util.StringTokenizer;

public class QueryTokenEx {
    public static void main(String[] args) {
        // (1) StringTokenizer : 구분 문자 '&'로 분리
        String query = "name=kitae&addr=seoul&age=21";
        StringTokenizer st = new StringTokenizer(query, "&");
        System.out.println("[구분 문자 '&'로 분리]");
        while (st.hasMoreTokens())
            System.out.println(st.nextToken());

        // 구분 문자를 여러 개 지정하면 각 문자가 모두 구분 문자로 사용된다("&=" -> '&' 또는 '=')
        System.out.println("\n[구분 문자 '&'와 '=' 로 분리]");
        StringTokenizer st2 = new StringTokenizer(query, "&=");
        while (st2.hasMoreTokens())
            System.out.print(st2.nextToken() + " ");
        System.out.println();

        // (2) "&=" 라는 문자열 자체를 기준으로 분리하려면 split()을 사용
        String query2 = "name&=UJin&=company&=EchoChoe";
        System.out.println("\n[\"&=\" 문자열 자체를 기준으로 split()]");
        String[] tokens = query2.split("&=");
        for (String token : tokens)
            System.out.println(token);

        // 구분 문자가 연속으로 붙어 있으면 StringTokenizer는 빈 토큰을 만들지 않으므로
        // 위 문자열에서는 결과가 우연히 같아 보인다. 아래처럼 '&'와 '='가 따로 쓰인 문자열에서는
        // StringTokenizer("&=")가 두 문자를 각각 구분 문자로 처리하여 결과가 완전히 달라진다.
        String mixed = "a&b=c&=d";
        System.out.println("\n[\"a&b=c&=d\" 비교]");
        System.out.println("split(\"&=\")       -> " + Arrays.toString(mixed.split("&=")));
        StringTokenizer st4 = new StringTokenizer(mixed, "&=");
        System.out.print("StringTokenizer(\"&=\") -> ");
        while (st4.hasMoreTokens())
            System.out.print(st4.nextToken() + " ");
        System.out.println();
    }
}
