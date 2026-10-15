/******************************************************************************************
프로그램명 : BirthdayApp.java
설명 : 연습문제 02. java.util.Calendar 클래스를 활용하여 생일(년 월 일)을 입력받고
       오늘 이 시간까지 태어난지 며칠이 지났는지 계산하여 출력하는 프로그램.
       날짜가 바뀔 때 1일이 지난 것으로 계산하며 오늘도 포함하여 센다.
       (예 : 2024년 4월 14일이 생일이고 오늘이 2024년 11월 3일이면 203일)
       "stop"을 입력하면 종료 메시지를 출력하고 프로그램을 끝낸다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BirthdayApp {
    private static final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L; // 하루에 해당하는 밀리초

    // 년, 월, 일만 지정하고 시/분/초/밀리초는 0으로 지운 Calendar 객체 생성
    // -> 시간 정보를 0으로 맞추어야 '날짜가 바뀐 횟수'를 정확히 계산할 수 있다.
    private static Calendar createDate(int year, int month, int dayOfMonth) {
        Calendar date = Calendar.getInstance();
        date.clear(); // 현재 날짜와 시간 정보를 모두 지움
        date.set(year, month - 1, dayOfMonth); // Calendar의 월은 0부터 시작하므로 -1
        return date;
    }

    // 지정한 년도와 월의 최대 날 수 리턴 (예 : 2024년 2월은 29)
    private static int findMaxDay(int year, int month) {
        Calendar date = Calendar.getInstance();
        date.clear();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month - 1);
        return date.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    // 생일부터 오늘까지 지난 날 수 계산 (두 날짜의 밀리초 차이를 하루 밀리초로 나눔)
    private static long countDaysLived(Calendar birthday, Calendar today) {
        return (today.getTimeInMillis() - birthday.getTimeInMillis()) / MILLIS_PER_DAY;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance(); // 현재 날짜와 시간 정보를 가진 객체
        int todayYear = now.get(Calendar.YEAR);
        int todayMonth = now.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 +1
        int todayDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        System.out.println("오늘은 " + todayYear + "년 " + todayMonth + "월 " + todayDayOfMonth + "일");

        // 오늘 날짜도 시간 정보를 지운 상태로 만들어 두고 계산에 사용
        Calendar today = createDate(todayYear, todayMonth, todayDayOfMonth);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("생일 입력(년 월 일)>>");
            String inputLine = scanner.nextLine();

            if (inputLine.equals("stop")) // "stop"을 입력하면 반복 종료
                break;

            StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
            if (tokenizer.countTokens() != 3) { // 년, 월, 일 세 개가 입력되지 않은 경우
                System.out.println("입력 오류! 년 월 일을 공백으로 구분하여 입력하세요.");
                continue;
            }

            int birthYear = Integer.parseInt(tokenizer.nextToken().trim());  // 문자열을 정수로 변환
            int birthMonth = Integer.parseInt(tokenizer.nextToken().trim());
            int birthDayOfMonth = Integer.parseInt(tokenizer.nextToken().trim());

            if (birthMonth < 1 || birthMonth > 12) { // 월의 범위 확인
                System.out.println("입력 오류! 달의 범위는 1~12입니다.");
                continue;
            }

            int maxDay = findMaxDay(birthYear, birthMonth); // 해당 년/월의 최대 날 수
            if (birthDayOfMonth < 1 || birthDayOfMonth > maxDay) { // 일의 범위 확인
                System.out.println("입력 오류! " + birthYear + "년 " + birthMonth + "월은 "
                        + maxDay + "일까지입니다.");
                continue;
            }

            Calendar birthday = createDate(birthYear, birthMonth, birthDayOfMonth);
            long daysLived = countDaysLived(birthday, today);

            if (daysLived < 0) { // 오늘보다 늦은 날짜를 입력한 경우
                System.out.println("입력 오류! 아직 태어나지 않은 날짜입니다.");
                continue;
            }
            System.out.println("오늘까지 " + daysLived + "일 살아왔습니다.");
        }
        System.out.println("==========================");
        System.out.println("프로그램이 종료되었습니다!");
        scanner.close();
    }
}
