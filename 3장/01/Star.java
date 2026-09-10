/******************************************************************************************
프로그램명 : Star.java
설명 : 입력받은 높이만큼 별(*)로 이루어진 삼각형을 가운데 정렬하여 출력하는 프로그램
작성일시 : 2026.09.10
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

class Star {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height;

        System.out.print("별의 높이 입력 : ");
        try {
            height = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해야 합니다.");
            scanner.close();
            return;
        }

        if (height <= 0) {
            System.out.println("1 이상의 양수를 입력해야 합니다.");
            scanner.close();
            return;
        }

        System.out.println();
        for (int row = 1; row <= height; row++) {
            int spaceCount = height - row;
            int starCount = 2 * row - 1;

            for (int space = 0; space < spaceCount; space++) {
                System.out.print(" ");
            }
            for (int star = 0; star < starCount; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
