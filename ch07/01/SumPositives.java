/******************************************************************************************
프로그램명 : SumPositives.java
설명 : 연습문제 01. Scanner 클래스를 이용하여 0이 입력될 때까지 정수를 입력 받아
       벡터(Vector<Integer>)에 하나씩 저장하고, 벡터에 저장된 음수들은 모두 0으로 수정한 뒤
       벡터 전체를 검색하여 양수들의 합을 구해 출력하는 프로그램
작성일시 : 2026.10.29
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Scanner; // 키보드 입력을 받기 위한 Scanner 클래스
import java.util.Vector;  // 정수들을 저장할 벡터 클래스

public class SumPositives {
    private Vector<Integer> v = new Vector<Integer>(); // 입력받은 정수들을 저장하는 벡터

    // 키보드로부터 0이 입력될 때까지 정수를 읽어 벡터 v에 하나씩 저장
    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요. 0을 입력하면 입력이 끝납니다.");
        while (true) {
            System.out.print("정수>>");
            int number = scanner.nextInt();
            if (number == 0) // 0이 입력되면 입력 종료 (0은 벡터에 저장하지 않음)
                break;
            v.add(number); // 벡터의 맨 뒤에 정수 저장
        }
        scanner.close();
    }

    // 벡터 v에 저장된 음수들을 모두 0으로 변경
    public void changeToZero() {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) < 0) // i번째 원소가 음수이면
                v.set(i, 0);  // i번째 원소의 값을 0으로 수정
        }
    }

    // 벡터 v에 저장된 원소들을 모두 출력
    public void showAll() {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println(); // 원소를 모두 출력한 뒤 줄 바꿈
    }

    // 벡터 v 전체를 검색하여 저장된 정수들의 합을 리턴
    // (음수는 changeToZero()에서 이미 0으로 바뀌었으므로 결과는 양수들의 합)
    public int add() {
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i);
        }
        return sum;
    }

    // main 메소드 (문제에서 주어진 코드, 수정 불가)
    public static void main(String[] args) {
        SumPositives sp = new SumPositives();
        sp.read(); // 키보드로부터 정수들을 읽어 벡터 v에 하나씩 저장
        sp.changeToZero(); // 벡터 v에 저장된 음수는 0으로 변경
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll(); // 벡터 v의 원소들을 모두 출력
        System.out.println("양수들의 합은 " + sp.add()); // 벡터 v의 정수들의 합 출력
    }
}
