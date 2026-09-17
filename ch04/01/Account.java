/******************************************************************************************
프로그램명 : Account.java
설명 : 은행계좌 하나를 표현하는 Account 클래스. 단일 금액/배열 예금과 잔액 내 출금을 지원
       (인출 요청 금액이 잔액보다 크면 잔액만큼만 인출)
작성일시 : 2026.09.17
작성자 : 2023314009_김지용
******************************************************************************************/

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    // 단일 금액 예금
    public void deposit(int money) {
        balance += money;
    }

    // 배열에 담긴 모든 금액을 예금 (오버로딩)
    public void deposit(int[] moneyList) {
        for (int money : moneyList) {
            balance += money;
        }
    }

    public int getBalance() {
        return balance;
    }

    // 잔액보다 큰 금액을 요청하면 잔액만큼만 인출하고, 실제 인출한 금액을 반환
    public int withdraw(int money) {
        int withdrawAmount = (balance < money) ? balance : money;
        balance -= withdrawAmount;
        return withdrawAmount;
    }
}

class AccountTest {
    public static void main(String[] args) {
        Account a = new Account(100); // 100원을 예금하면서 계좌 생성
        a.deposit(5000); // 5000원 예금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int bulk[] = { 100, 500, 200, 700 };
        a.deposit(bulk); // bulk[] 배열에 있는 모든 돈 예금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int money = 1000; // 인출하고자 하는 금액
        int wMoney = a.withdraw(money); // wMoney는 실제 인출한 금액
        if (wMoney < money) // 인출하고자 하는 금액보다 작은 돈이 인출된 경우
            System.out.println(wMoney + "원만 인출"); // 잔금이 1000원보다 작은 경우
        else
            System.out.println(wMoney + "원 인출"); // 잔금이 1000원보다 큰 경우

        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}
