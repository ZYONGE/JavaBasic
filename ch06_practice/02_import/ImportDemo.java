/******************************************************************************************
프로그램명 : ImportDemo.java
설명 : 강의자료 'import와 클래스 경로' 실습.
       (1) import 없이 전체 경로명으로 쓰는 방법, (2) 클래스 하나만 import 하는 방법,
       (3) 패키지 전체를 import(*) 하는 방법을 한 파일에서 비교하고,
       *는 하위 패키지까지 포함하지 않는다는 점과 java.lang은 자동 import 된다는 점을 확인한다.
       package 선언문이 없으므로 이 클래스는 디폴트 패키지(현재 디렉터리)에 속한다.
작성일시 : 2026.10.15
작성자 : 2023314009_김지용
******************************************************************************************/

import java.util.ArrayList;       // (2) 특정 클래스의 경로명만 포함 -> 가독성이 좋고 불필요한 로딩을 막음
import java.util.StringTokenizer; // 필요한 클래스만 하나씩 import
import java.util.*;               // (3) java.util 패키지 '바로 아래'의 모든 클래스를 클래스명만으로 사용

public class ImportDemo {
    public static void main(String[] args) {
        // (1) import를 이용하지 않는 경우 : 패키지 이름을 포함한 전체 경로명을 모두 써야 한다.
        java.util.Date today = new java.util.Date();
        System.out.println("[1] 전체 경로명 사용 : " + today);

        // (2) import java.util.ArrayList; 덕분에 클래스명만 사용하면 된다.
        ArrayList<String> list = new ArrayList<String>();
        list.add("패키지");
        list.add("모듈");
        System.out.println("[2] import한 클래스명만 사용 : " + list);

        // (3) import java.util.*; 덕분에 Scanner, Random 등도 클래스명만으로 사용 가능
        Random random = new Random(2026); // 씨드를 고정하여 항상 같은 난수가 나오게 함
        System.out.println("[3] java.util.* 로 사용 : " + random.nextInt(100));

        StringTokenizer st = new StringTokenizer("java util package", " ");
        System.out.println("    토큰 개수 : " + st.countTokens());

        // *는 현재 패키지의 클래스만 의미하므로 하위 패키지(java.util.concurrent)는 포함되지 않는다.
        // -> 아래 클래스는 전체 경로명을 쓰거나 따로 import 해야 한다.
        java.util.concurrent.TimeUnit unit = java.util.concurrent.TimeUnit.SECONDS;
        System.out.println("[4] 하위 패키지는 *에 포함 안 됨 : " + unit);

        // java.lang 패키지(String, System, Math, Integer ...)는 자동 import 되므로 import 문이 필요 없다.
        System.out.println("[5] java.lang은 자동 import : " + Math.max(3, 7)
                + ", " + Integer.class.getName());
    }
}
