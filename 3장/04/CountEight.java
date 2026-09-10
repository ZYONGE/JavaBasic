/******************************************************************************************
프로그램명 : CountEight.java
설명 : 1부터 10000까지의 모든 숫자에서 숫자 8이 각 자릿수에 총 몇 번 등장하는지 세어 출력하는 프로그램
       (예 : 8808은 3번, 8888은 4번으로 카운팅)
작성일시 : 2026.09.10
작성자 : 2023314009_김지용
******************************************************************************************/

class CountEight {
    public static void main(String[] args) {
        final int LIMIT = 10000;
        int eightCount = 0;

        for (int number = 1; number <= LIMIT; number++) {
            int digitCheck = number;
            while (digitCheck > 0) {
                if (digitCheck % 10 == 8) {
                    eightCount++;
                }
                digitCheck /= 10;
            }
        }

        System.out.println(eightCount);
    }
}
