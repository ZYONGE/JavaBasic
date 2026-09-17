/******************************************************************************************
프로그램명 : StaticEx.java
설명 : static 메서드만 가진 ArrayUtil 클래스. 두 배열을 이어붙이는 concat()과
       배열 내용을 "[ ... ]" 형식으로 출력하는 print()를 제공
작성일시 : 2026.09.17
작성자 : 2023314009_김지용
******************************************************************************************/

class ArrayUtil {
    // 배열 a와 b를 이어붙인 새로운 배열을 리턴
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;

        for (int value : a) {
            result[index++] = value;
        }
        for (int value : b) {
            result[index++] = value;
        }

        return result;
    }

    // 배열 a를 "[ 요소1 요소2 ... ]" 형식으로 출력
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}

public class StaticEx {
    public static void main(String[] args) {
        int[] array1 = { 1, 5, 7, 9 };
        int[] array2 = { 3, 6, -1, 100, 77 };
        int[] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
