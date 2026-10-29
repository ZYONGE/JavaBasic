/******************************************************************************************
프로그램명 : StockHashMap.java
설명 : 연습문제 02. "stop"이 입력될 때까지 주식 종목과 주가를 입력 받아
       해시맵(HashMap<String, Integer>)에 저장하고, 다시 주식 종목을 입력 받아
       해당 종목의 주가를 검색하여 출력하는 프로그램.
       검색 단계에서도 "stop"을 입력하면 종료 메시지를 출력하고 프로그램을 끝낸다.
작성일시 : 2026.10.29
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.HashMap;         // 종목(키)과 주가(값)를 쌍으로 저장할 해시맵 클래스
import java.util.Scanner;         // 키보드 입력을 받기 위한 Scanner 클래스
import java.util.StringTokenizer; // 한 줄에 입력된 종목과 주가를 분리하기 위한 클래스

public class StockHashMap {
    public static void main(String[] args) {
        // 종목 이름을 키로, 주가를 값으로 저장하는 해시맵
        HashMap<String, Integer> stockMap = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);

        // 1단계 : "stop"이 입력될 때까지 종목과 주가를 입력 받아 해시맵에 저장
        System.out.println("주식 종목과 주가를 입력하세요(예:삼송전자 75000)");
        while (true) {
            System.out.print("종목, 주가>>");
            String inputLine = scanner.nextLine().trim(); // 한 줄을 읽어 앞뒤 공백 제거

            if (inputLine.equals("stop")) // "stop"을 입력하면 저장 종료
                break;

            StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
            if (tokenizer.countTokens() != 2) { // 종목과 주가 두 개가 입력되지 않은 경우
                System.out.println("입력 오류! 종목과 주가를 공백으로 구분하여 입력하세요.");
                continue;
            }
            String stockName = tokenizer.nextToken();                 // 주식 종목 이름
            int stockPrice = Integer.parseInt(tokenizer.nextToken()); // 주가(문자열을 정수로 변환)
            stockMap.put(stockName, stockPrice); // 해시맵에 (종목, 주가)를 쌍으로 저장
        }

        // 2단계 : "stop"이 입력될 때까지 종목을 입력 받아 주가를 검색하여 출력
        System.out.println("주가를 검색합니다.");
        while (true) {
            System.out.print("종목>>");
            String stockName = scanner.nextLine().trim();

            if (stockName.equals("stop")) // "stop"을 입력하면 검색 종료
                break;

            if (stockMap.containsKey(stockName)) // 해시맵에 저장된 종목인지 확인
                System.out.println(stockName + "의 주가는 " + stockMap.get(stockName) + "원");
            else
                System.out.println(stockName + "은 없는 종목입니다.");
        }
        System.out.println("=====프로그램 종료=====");
        scanner.close();
    }
}
