/******************************************************************************************
프로그램명 : StackApp.java
설명 : IStack 인터페이스를 상속(구현)받아 문자열을 저장하는 StringStack 클래스를 작성하고,
       사용자로부터 스택 용량과 문자열을 입력 받아 스택에 저장(push)한 뒤
       "그만"을 입력하면 스택에 저장된 문자열을 꼭대기부터 차례로 꺼내(pop) 출력하는 프로그램
작성일시 : 2026.10.08
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Scanner; // 키보드 입력을 받기 위한 Scanner 클래스

// 스택의 기능을 정의한 인터페이스 (문제에서 주어진 코드)
interface IStack {
    int capacity();           // 스택에 저장 가능한 개수 리턴
    int length();             // 스택에 현재 저장된 개수 리턴
    boolean push(String val); // 스택의 톱(top)에 문자열 저장하고 true 리턴.
                              // 꽉 차서 넣을 수 없으면 false 리턴
    String pop();             // 스택의 톱(top)에 저장된 문자열 리턴. 스택이 비어 있으면 null 리턴
}

// IStack 인터페이스를 구현하여 문자열을 저장하는 스택 클래스
class StringStack implements IStack {
    private String[] stackArray; // 문자열을 실제로 저장하는 배열
    private int topIndex;        // 다음에 문자열이 저장될 위치 (= 현재 저장된 문자열 개수)

    // 생성자 : 스택 용량(stackCapacity)만큼 배열을 생성하고 스택을 빈 상태로 초기화
    public StringStack(int stackCapacity) {
        stackArray = new String[stackCapacity];
        topIndex = 0; // 처음에는 저장된 문자열이 없음
    }

    // 스택에 저장 가능한 최대 개수(배열의 크기) 리턴
    @Override
    public int capacity() {
        return stackArray.length;
    }

    // 스택에 현재 저장된 문자열 개수 리턴
    @Override
    public int length() {
        return topIndex;
    }

    // 스택의 꼭대기에 문자열을 저장
    // 스택이 가득 차 있으면 저장하지 않고 false 리턴
    @Override
    public boolean push(String val) {
        if (topIndex == capacity()) { // 저장된 개수가 용량과 같으면 가득 찬 상태
            return false;
        }
        stackArray[topIndex] = val; // 꼭대기 위치에 문자열 저장
        topIndex++;                 // 꼭대기 위치를 한 칸 위로 이동
        return true;
    }

    // 스택의 꼭대기에 저장된 문자열을 꺼내서 리턴
    // 스택이 비어 있으면 null 리턴
    @Override
    public String pop() {
        if (topIndex == 0) { // 저장된 문자열이 없으면 빈 상태
            return null;
        }
        topIndex--;                                // 꼭대기 위치를 한 칸 아래로 이동
        String poppedString = stackArray[topIndex]; // 꼭대기에 있던 문자열을 꺼냄
        stackArray[topIndex] = null;               // 꺼낸 자리는 비워 둠
        return poppedString;
    }
}

// main 함수를 실행하는 클래스 (문제에서 주어진 코드, 수정 불가)
public class StackApp {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("스택 용량>>");
        int cap = scanner.nextInt();
        StringStack sStack = new StringStack(cap);
        while(true) {
            System.out.print("문자열 입력>>");
            String str = scanner.next();
            if(str.equals("그만"))
                break;
            if(sStack.push(str) == false) {
                System.out.println("스택이 꽉 차서 " + str + " 저장 불가");
            }
        }
        System.out.print("스택에 저장된 문자열 팝 : ");
        while(true) {
            String str = sStack.pop();
            if(str == null) {
                break; // 스택이 비어 있음
            }
            System.out.print(str + " ");
        }
        System.out.println();
        scanner.close();
    }
}
