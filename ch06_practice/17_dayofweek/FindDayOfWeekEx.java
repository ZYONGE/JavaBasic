/******************************************************************************************
프로그램명 : FindDayOfWeekEx.java
설명 : 예제 6-12. 사용자로부터 년, 월, 일을 한 줄로 입력받아
       StringTokenizer로 분리하고 Integer.parseInt()로 정수 변환한 뒤,
       Calendar를 이용하여 그 날이 무슨 요일인지 출력하는 프로그램.
       getActualMaximum()으로 해당 년/월의 최대 날 수를 알아내어 입력 오류도 검사한다.
       "그만"을 입력하면 종료한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.*; // Calendar, Scanner, StringTokenizer 모두 java.util 패키지 소속

public class FindDayOfWeekEx {
    public static String findDayOfWeek(int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance(); // Calendar 객체 생성

        if (month < 1 || month > 12) // month의 범위 오류 확인(1~12)
            return "입력 오류! 달의 범위는 1~12입니다.";

        cal.set(Calendar.YEAR, year);      // 캘린더 객체에 년도 지정
        cal.set(Calendar.MONTH, month - 1); // 달은 0부터 시작하므로 -1

        // cal 객체에 설정된 년도와 월의 최대 날짜 알아내기 (예 : 2024년 2월은 29)
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (dayOfMonth < 1 || dayOfMonth > maxDay)
            return "입력 오류! " + year + "년 " + month + "월은 " + maxDay + "일까지입니다.";

        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth); // 캘린더 객체에 일 지정

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일 알아내기(1 = 일요일, 7 = 토요일)
        String res = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY    : res = "일요일"; break;
            case Calendar.MONDAY    : res = "월요일"; break;
            case Calendar.TUESDAY   : res = "화요일"; break;
            case Calendar.WEDNESDAY : res = "수요일"; break;
            case Calendar.THURSDAY  : res = "목요일"; break;
            case Calendar.FRIDAY    : res = "금요일"; break;
            case Calendar.SATURDAY  : res = "토요일"; break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("년 월 일 입력>>");
            String line = scanner.nextLine();
            if (line.equals("그만"))
                break;

            StringTokenizer st = new StringTokenizer(line, " ");
            if (st.countTokens() != 3) { // 토큰이 3개가 아니면 잘못된 입력
                System.out.println("입력 오류! 년 월 일을 공백으로 구분하여 입력하세요.");
                continue;
            }
            int year = Integer.parseInt(st.nextToken().trim());       // 문자열을 정수로 변환
            int month = Integer.parseInt(st.nextToken().trim());
            int dayOfMonth = Integer.parseInt(st.nextToken().trim());

            String dayOfWeek = findDayOfWeek(year, month, dayOfMonth);
            System.out.println(dayOfWeek);
        }
        scanner.close();
    }
}
