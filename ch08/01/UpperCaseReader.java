/******************************************************************************************
프로그램명 : UpperCaseReader.java
설명 : 연습문제 01. 강의자료에서 활용한 system.ini 파일을 FileReader로 한 문자씩 읽어와
       소문자를 대문자로 변경(Character.toUpperCase)하여 화면에 출력하는 프로그램
작성일시 : 2026.11.05
작성자 : 2023314009_김지용
******************************************************************************************/

import java.io.File;                  // 파일 경로와 존재 여부를 다루기 위한 클래스
import java.io.FileReader;            // 텍스트 파일을 문자 단위로 읽는 문자 입력 스트림
import java.io.FileNotFoundException; // 파일이 없을 때 발생하는 예외
import java.io.IOException;           // 입출력 중 발생하는 예외

public class UpperCaseReader {
    public static void main(String[] args) {
        // 강의자료와 같은 경로(Windows)의 system.ini 파일
        File file = new File("c:\\windows\\system.ini");
        if (!file.exists()) // Windows가 아닌 환경에서는 현재 폴더의 system.ini 사용
            file = new File("system.ini");

        FileReader fin = null;
        try {
            fin = new FileReader(file); // 파일과 연결된 문자 입력 스트림 생성
            int c;
            while ((c = fin.read()) != -1) { // 파일 끝(-1)을 만날 때까지 한 문자씩 읽기
                char ch = Character.toUpperCase((char) c); // 소문자이면 대문자로 변경
                System.out.print(ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println(file.getPath() + " 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다.");
        } finally {
            try {
                if (fin != null)
                    fin.close(); // 스트림 닫기
            } catch (IOException e) {
                System.out.println("파일을 닫는 중 오류가 발생했습니다.");
            }
        }
    }
}
