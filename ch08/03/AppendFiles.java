/******************************************************************************************
프로그램명 : AppendFiles.java
설명 : 연습문제 03. 2개의 문자 파일의 경로와 파일명을 입력 받아 두 파일의 내용을 차례로 읽어
       하나로 합친 새로운 파일(appended.txt)을 생성하는 프로그램.
       입력한 파일이 없는 경우를 대비하여 예외처리를 하고,
       새로운 파일은 클래스 파일(AppendFiles.class)이 위치한 폴더에 생성한다.
작성일시 : 2026.11.05
작성자 : 2023314009_김지용
******************************************************************************************/

import java.io.File;                  // 파일 경로와 존재 여부를 다루기 위한 클래스
import java.io.FileReader;            // 텍스트 파일을 문자 단위로 읽는 문자 입력 스트림
import java.io.FileWriter;            // 텍스트 파일에 문자 단위로 쓰는 문자 출력 스트림
import java.io.FileNotFoundException; // 파일이 없을 때 발생하는 예외
import java.io.IOException;           // 입출력 중 발생하는 예외
import java.net.URISyntaxException;   // 클래스 파일 위치(URI)를 파일 경로로 바꿀 때 발생할 수 있는 예외
import java.util.Scanner;             // 키보드 입력을 받기 위한 Scanner 클래스

public class AppendFiles {
    // 클래스 파일(AppendFiles.class)이 위치한 폴더를 리턴
    private static File getClassFolder() throws URISyntaxException {
        return new File(AppendFiles.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }

    // reader로부터 파일 끝까지 읽은 내용을 writer에 그대로 씀
    private static void copy(FileReader reader, FileWriter writer) throws IOException {
        char[] buf = new char[1024]; // 한 번에 최대 1024 문자씩 읽기
        int n;
        while ((n = reader.read(buf)) != -1) { // 실제로 읽은 문자 개수 n
            writer.write(buf, 0, n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫번째 파일 : ");
        String firstPath = scanner.nextLine().trim();
        System.out.print("두번째 파일 : ");
        String secondPath = scanner.nextLine().trim();
        scanner.close();

        // try-with-resources : 블록이 끝나면 열린 스트림들이 자동으로 닫힘.
        // 두 입력 파일을 먼저 연 뒤 출력 파일을 만들기 때문에,
        // 입력 파일이 없으면 appended.txt를 만들지 않고 바로 catch로 넘어감
        try (FileReader first = new FileReader(firstPath);
             FileReader second = new FileReader(secondPath)) {
            File outFile = new File(getClassFolder(), "appended.txt");
            try (FileWriter writer = new FileWriter(outFile)) {
                copy(first, writer);  // 첫번째 파일 내용 쓰기
                copy(second, writer); // 이어서 두번째 파일 내용 쓰기
            }
            System.out.println("appended.txt 파일 생성 완료");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다 : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다 : " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("클래스 파일의 위치를 찾을 수 없습니다.");
        }
    }
}
