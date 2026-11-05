/******************************************************************************************
프로그램명 : ImageCopy.java
설명 : 연습문제 04. 복사할 이미지 파일과 복사될 파일의 위치·파일명을 입력 받아
       바이트 스트림(FileInputStream/FileOutputStream)으로 파일을 복사하는 프로그램.
       복사가 10%씩 진행될 때마다 '*'를 하나씩 출력하고,
       복사될 파일의 경로(폴더)가 없으면 경로를 생성한다.
작성일시 : 2026.11.05
작성자 : 2023314009_김지용
******************************************************************************************/

import java.io.BufferedInputStream;   // 버퍼를 사용하여 바이트 단위로 읽는 입력 스트림
import java.io.BufferedOutputStream;  // 버퍼를 사용하여 바이트 단위로 쓰는 출력 스트림
import java.io.File;                  // 파일 크기, 경로, 폴더 생성을 다루기 위한 클래스
import java.io.FileInputStream;       // 파일을 바이트 단위로 읽는 입력 스트림
import java.io.FileOutputStream;      // 파일에 바이트 단위로 쓰는 출력 스트림
import java.io.IOException;           // 입출력 중 발생하는 예외
import java.util.Scanner;             // 키보드 입력을 받기 위한 Scanner 클래스

public class ImageCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("복사할 파일 : ");
        File src = new File(scanner.nextLine().trim());
        System.out.print("복사될 파일 : ");
        File dest = new File(scanner.nextLine().trim());
        scanner.close();

        if (!src.isFile()) { // 복사할 파일이 없거나 폴더인 경우
            System.out.println(src.getPath() + " 파일이 없습니다.");
            return;
        }

        // 복사될 파일의 경로(폴더)가 없으면 필요한 상위 폴더까지 모두 생성
        File parent = dest.getAbsoluteFile().getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                System.out.println(parent.getPath() + " 경로를 생성할 수 없습니다.");
                return;
            }
        }

        long total = src.length(); // 복사할 파일의 전체 크기(바이트)
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buf = new byte[1024]; // 한 번에 최대 1024 바이트씩 복사
            long copied = 0;             // 지금까지 복사한 바이트 수
            int stars = 0;               // 지금까지 출력한 '*' 개수 (10% 당 1개)
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
                copied += n;
                // 진행률(10% 단위)이 출력한 '*' 개수보다 커질 때마다 '*' 출력
                while (stars < copied * 10 / total) {
                    System.out.print("*");
                    stars++;
                }
            }
            while (stars < 10) { // 빈 파일(크기 0)인 경우에도 100%를 표시
                System.out.print("*");
                stars++;
            }
            System.out.println();
            System.out.println("#파일 복사 완료");
        } catch (IOException e) {
            System.out.println("파일 복사 중 오류가 발생했습니다 : " + e.getMessage());
        }
    }
}
