/******************************************************************************************
프로그램명 : PrimeNumber.java
설명 : 500부터 1000까지의 범위에서 소수를 모두 찾아 출력
작성일시 : 2026.09.10
작성자 : 2023314009_김지용
******************************************************************************************/

class PrimeNumber {
    public static void main(String[] args) {
        final int START = 500;
        final int END = 1000;
        StringBuilder result = new StringBuilder();

        for (int number = START; number <= END; number++) {
            if (isPrime(number)) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(number);
            }
        }

        System.out.println(result);
    }

    // 소수 여부 판별 : 2를 제외한 짝수는 바로 제외하고, 홀수는 제곱근까지만 나누어 검사
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int sqrtOfNumber = (int) Math.sqrt(number);
        for (int divisor = 3; divisor <= sqrtOfNumber; divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
