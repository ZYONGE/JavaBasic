/******************************************************************************************
프로그램명 : CalendarEx.java
설명 : 예제 6-11. java.util.Calendar를 이용하여 현재 날짜와 시간을 알아내고,
       특정 날짜와 시간을 설정하여 출력하는 프로그램.
       Calendar는 추상 클래스이므로 new가 아니라 getInstance()로 객체를 얻으며,
       MONTH는 0부터 시작하므로 가져온 값에 +1, 설정할 때는 -1을 해야 한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.Calendar;

public class CalendarEx {
    public static void printCalendar(String msg, Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;      // 달은 0부터 시작하므로 +1
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1(일요일) ~ 7(토요일)
        int hour = cal.get(Calendar.HOUR);             // 12시간제 시간
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY); // 24시간제 시간
        int ampm = cal.get(Calendar.AM_PM);            // 오전(Calendar.AM) / 오후(Calendar.PM)
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);

        System.out.print(msg + year + "/" + month + "/" + day + "/");
        switch (dayOfWeek) {
            case Calendar.SUNDAY    : System.out.print("일요일"); break;
            case Calendar.MONDAY    : System.out.print("월요일"); break;
            case Calendar.TUESDAY   : System.out.print("화요일"); break;
            case Calendar.WEDNESDAY : System.out.print("수요일"); break;
            case Calendar.THURSDAY  : System.out.print("목요일"); break;
            case Calendar.FRIDAY    : System.out.print("금요일"); break;
            case Calendar.SATURDAY  : System.out.print("토요일"); break;
        }
        System.out.print("(" + hourOfDay + "시)");
        if (ampm == Calendar.AM)
            System.out.print("오전");
        else
            System.out.print("오후");
        System.out.println(hour + "시 " + minute + "분 " + second + "초 " + millisecond + "밀리초");
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance(); // 현재 날짜와 시간 정보를 가진 객체 생성
        printCalendar("현재 ", now);

        Calendar firstDate = Calendar.getInstance();
        firstDate.clear(); // 현재 날짜와 시간 정보를 모두 지운다.
        firstDate.set(2024, 11, 25);                // 2024년 12월 25일 (12월은 11로 설정)
        firstDate.set(Calendar.HOUR_OF_DAY, 20);    // 저녁 8시
        firstDate.set(Calendar.MINUTE, 30);         // 30분
        printCalendar("처음 데이트한 날은 ", firstDate);

        // Calendar 객체에 날짜/시간을 저장해도 컴퓨터의 날짜와 시간이 바뀌는 것은 아니다.
        printCalendar("확인용 현재 ", Calendar.getInstance());
    }
}
