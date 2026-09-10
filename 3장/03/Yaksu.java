/******************************************************************************************
프로그램명 : Yaksu.java
설명 : 입력받은 양수의 모든 약수를 찾아 대괄호와 공백으로 구분하여 출력하는 프로그램
작성일시 : 2026.09.10
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

class Yaksu {
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

        StringBuilder result = new StringBuilder("[");
        boolean isFirst = true;
        for (int divisor = 1; divisor <= inputNumber; divisor++) {
            if (inputNumber % divisor == 0) {
                if (!isFirst) {
                    result.append(" ");
                }
                result.append(divisor);
                isFirst = false;
            }
        }
        result.append("]");

        System.out.println(result);
        scanner.close();
    }
}
