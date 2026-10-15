# ch06 실습 — 모듈과 패키지 개념, 자바 기본 패키지

> **이 디렉터리는 강의자료 실습(예제 따라하기) 코드 모음입니다.**
> 제출용 연습문제(과제) 풀이는 [`../ch06`](../ch06) 디렉터리에 있습니다.

강의자료 `ch06_모듈과패키지.pdf`(60쪽)의 목차를 따라 실습 코드로 정리한 디렉터리.
예제 6-1 ~ 6-12는 강의자료의 예제를 그대로 실습하고, 그 외 폴더는 슬라이드 설명을 직접
확인해 보기 위해 추가한 보충 실습이다. 한 폴더에 실습 프로그램 하나(main 클래스 하나)를 둔다.

## 구성

| 폴더 | 파일 | 강의자료 | 내용 |
| --- | --- | --- | --- |
| `01_package` | `lib/Calculator.java`, `app/GoodCalc.java` | 8~18쪽 (PackageEx) | `package` 선언으로 `lib`, `app` 두 패키지를 만들고, 다른 패키지의 추상 클래스를 `import`하여 상속 |
| `02_import` | `ImportDemo.java` | 7쪽 | 전체 경로명 / 클래스 하나 `import` / 패키지 전체 `import(*)` 비교, `*`는 하위 패키지를 포함하지 않음, `java.lang`은 자동 `import` |
| `03_module` | `com.uslab.device`, `com.uslab.app` | 5쪽 | `module-info.java`로 모듈 선언. `requires`로 의존성, `exports`로 공개 패키지 지정(공개하지 않은 패키지는 다른 모듈에서 접근 불가) |
| `04_object` | `ObjectPropertyEx.java` | 예제 6-1 | `getClass().getName()`, `hashCode()`, `toString()`으로 객체 속성 알아내기 |
| `05_tostring` | `ToStringEx.java` | 예제 6-2 | `toString()` 오버라이딩, '객체 + 문자열' 자동 변환 |
| `06_equals` | `EqualsEx.java` | 예제 6-3 | `==`(레퍼런스 비교)와 `equals()`(내용 비교)의 차이 |
| `07_rect` | `RectEqualsEx.java` | 예제 6-4 | 면적이 같으면 같은 사각형으로 판별하는 `equals()` 작성 |
| `08_wrapper` | `WrapperEx.java` | 예제 6-5 | `Character`, `Integer`, `Double`, `Boolean`의 주요 static 메소드 |
| `09_boxing` | `AutoBoxingUnBoxingEx.java` | 예제 6-6 | 박싱 / 언박싱, 자동 박싱 / 자동 언박싱 |
| `10_string` | `StringEx.java` | 예제 6-7 | `length()`, `contains()`, `concat()`, `trim()`, `replace()`, `split()`, `substring()`, `charAt()` |
| `11_string_compare` | `StringCompareEx.java` | 35~41쪽 | 리터럴 생성 vs `new String()`, `==`/`equals()`/`compareTo()`, 문자열 연결, `trim()`, `charAt()`으로 문자 개수 세기 |
| `12_stringbuffer` | `StringBufferEx.java` | 예제 6-8 | 가변 문자열 `append()`, `insert()`, `replace()`, `delete()`, `setLength()`, `reverse()` |
| `13_stringtokenizer` | `StringTokenizerEx.java` | 예제 6-9 | 구분 문자 `/`로 토큰 분리 (`countTokens()`, `hasMoreTokens()`, `nextToken()`) |
| `14_query_token` | `QueryTokenEx.java` | 48~49쪽 | 질의 문자열 분리. `StringTokenizer`는 지정한 문자 각각을 구분 문자로 쓰고, `"&="` 같은 문자열 자체로 분리하려면 `split()`을 써야 함 |
| `15_math` | `MathEx.java` | 예제 6-10 | `PI`, `ceil()`, `floor()`, `sqrt()`, `round()`, `random()`으로 난수 발생 |
| `16_calendar` | `CalendarEx.java` | 예제 6-11 | 현재 날짜/시간 알아내기와 특정 날짜/시간 설정 (`MONTH`는 0부터 시작) |
| `17_dayofweek` | `FindDayOfWeekEx.java` | 예제 6-12 | 년 월 일을 입력받아 요일 출력. `getActualMaximum()`으로 달의 최대 날 수 검사, `"그만"` 입력 시 종료 |

## 컴파일 & 실행

단일 파일 폴더(`02_import`, `04_object` ~ `17_dayofweek`)는 폴더로 이동한 뒤 아래처럼 실행한다.
(`bin/`은 `.gitignore`에 등록되어 있어 커밋되지 않는다.)

```bash
cd 04_object
javac -encoding UTF-8 -d bin ObjectPropertyEx.java
java -cp bin ObjectPropertyEx
```

### 01_package — 패키지 두 개를 함께 컴파일

```bash
cd 01_package
javac -encoding UTF-8 -d bin lib/Calculator.java app/GoodCalc.java
java -cp bin app.GoodCalc      # 클래스의 경로명은 app.GoodCalc
```

### 03_module — 모듈 두 개를 함께 컴파일

```bash
cd 03_module
javac -encoding UTF-8 -d bin --module-source-path . -m com.uslab.app,com.uslab.device
java --module-path bin -m com.uslab.app/com.uslab.app.api.AppMain
```

`AppMain.java`에서 주석 처리해 둔 `import com.uslab.device.internal.SensorDriver;`의 주석을 풀면
`package com.uslab.device.internal is not visible` 오류가 난다. `exports`하지 않은 패키지는
다른 모듈에서 보이지 않는다는 뜻으로, 모듈이 제공하는 캡슐화를 직접 확인할 수 있다.

## 실행 결과 (JDK 17 기준)

```
# 01_package / app.GoodCalc
5
-1
3.0
이 객체의 경로명 : app.GoodCalc
수퍼 클래스의 경로명 : lib.Calculator

# 03_module / com.uslab.app
=== 모듈 com.uslab.app 실행 ===
1회 측정 : 20.0℃
2회 측정 : 20.5℃
3회 측정 : 21.0℃
Thermometer(측정횟수=3)
AppMain 패키지 : com.uslab.app.api, 모듈 : com.uslab.app
Thermometer 패키지 : com.uslab.device.api, 모듈 : com.uslab.device
String 클래스의 모듈 : java.base

# 10_string / StringEx
 C#의 길이는 3
true
 C#,C++
C#,C++
Java,C++
분리된 문자열0: Java
분리된 문자열1: C++
C++
+

# 17_dayofweek / FindDayOfWeekEx
년 월 일 입력>>2024 1 1
월요일
년 월 일 입력>>2024 2 30
입력 오류! 2024년 2월은 29일까지입니다.
년 월 일 입력>>2024 13 7
입력 오류! 달의 범위는 1~12입니다.
년 월 일 입력>>그만
```

`04_object`의 해시코드, `15_math`의 난수, `16_calendar`의 현재 시각은 실행할 때마다 값이 달라진다.

## 메모

- **패키지**: 관련된 클래스/인터페이스의 클래스 파일을 하나의 디렉터리로 묶은 것. 경로는 `.`으로 구분하며,
  `package` 선언문은 소스 파일의 첫 줄(주석 제외)에 와야 한다. `package` 선언이 없으면 디폴트 패키지(현재 디렉터리)에 속한다.
- **모듈**: 여러 패키지와 자원을 모아 놓은 컨테이너. JDK 9부터 자바 API 전체가 모듈로 재구성되었고(`java.base` 등),
  `module-info.java`에 `requires`(의존성)와 `exports`(공개 패키지)를 선언한다.
- **다른 패키지에서 쓸 클래스는 `public`** 이어야 한다. `01_package/lib/Calculator.java`에서 `public`을 지우면
  `app` 패키지 컴파일 시 오류가 난다.
- **`String`은 수정 불가능(immutable)** 하므로 `concat()`, `replace()`, `trim()` 등은 새 문자열을 리턴한다.
  리턴값을 다시 대입하지 않으면 원본은 그대로다. 내용을 바꿔야 하면 `StringBuffer`를 쓴다.
- **문자열 비교는 `equals()`** 로 한다. `==`는 참조 주소를 비교하므로 `new String("Hello") == "Hello"`는 `false`다.
- 예제 6-2(`05_tostring`)와 예제 6-3(`06_equals`)의 `Point`는 예제 6-1(`04_object`)의 `Point`와
  이름이 겹치지 않도록 `static` 내부 클래스로 작성했다. 세 폴더를 한 프로젝트(IDE)로 함께 열어도
  `duplicate class: Point` 오류가 나지 않는다. 코드 내용은 강의자료와 같다.
- `03_module`은 모듈 단위로 컴파일해야 하므로 IDE 프로젝트로 묶지 말고 위의 터미널 명령으로 실행한다.
- **`Calendar.MONTH`는 0부터 시작**한다. 가져올 때는 `+1`, 설정할 때는 `-1`.
  강의자료 57쪽 출력 예시에는 2024년 12월 25일이 "일요일"로 적혀 있으나, 실제로 그날은 **수요일**이며
  `16_calendar`를 실행하면 수요일로 출력된다.
