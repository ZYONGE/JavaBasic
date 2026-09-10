/******************************************************************************************
프로그램명 : SquareSum.java
설명 : 1부터 입력받은 양수까지 제곱을 모두 더한 합을 출력
작성일시 : 2026.09.10
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

class SquareSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;

        System.out.print("1보다 큰 양수를 입력 : ");
        try {
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해야 합니다.");
            scanner.close();
            return;
        }

        if (inputNumber <= 1) {
            System.out.println("1보다 큰 양수를 입력해야 합니다.");
            scanner.close();
            return;
        }

        long squareSum = 0;
        for (int number = 1; number <= inputNumber; number++) {
            squareSum += (long) number * number;
        }

        System.out.println(squareSum);
        scanner.close();
    }
}
