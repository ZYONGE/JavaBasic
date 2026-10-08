/******************************************************************************************
프로그램명 : DictionaryApp.java
설명 : '키'와 '값' 두 문자열을 하나의 아이템으로 저장하는 추상 클래스 PairMap을 상속받아
       Dictionary 클래스를 구현하고, 아이템을 저장(put), 검색(get), 삭제(delete)하는 프로그램
작성일시 : 2026.10.08
작성자 : 2023314009_김지용
******************************************************************************************/

// '키'와 '값'의 쌍을 저장하는 추상 클래스 (문제에서 주어진 코드)
abstract class PairMap {
    protected String keyArray [];   // 키 문자열을 저장하는 배열
    protected String valueArray []; // 값 문자열을 저장하는 배열
    abstract public String get(String key);             // key 값으로 value 검색
    abstract public void put(String key, String value); // key와 value를 쌍으로 저장.
                                                        // key가 이미 저장되어 있으면 값을 value로 수정
    abstract public String delete(String key);          // key 값을 가진 아이템(value와 함께) 삭제.
                                                        // 삭제된 value 값 리턴
    abstract public int length();                       // 현재 저장된 아이템 개수 리턴
}

// PairMap을 상속받아 키-값 쌍을 저장하는 사전 클래스
class Dictionary extends PairMap {
    private int itemCount; // 현재 저장된 아이템 개수

    // 생성자 : 최대 저장 개수(dictionaryCapacity)만큼 키 배열과 값 배열을 생성
    public Dictionary(int dictionaryCapacity) {
        keyArray = new String[dictionaryCapacity];
        valueArray = new String[dictionaryCapacity];
        itemCount = 0; // 처음에는 저장된 아이템이 없음
    }

    // key가 저장된 배열의 인덱스를 찾아 리턴, 없으면 -1 리턴
    // (get, put, delete에서 공통으로 사용하는 검색 메소드)
    private int findIndex(String key) {
        for (int index = 0; index < itemCount; index++) {
            if (keyArray[index].equals(key)) { // 문자열 비교는 equals() 사용
                return index;
            }
        }
        return -1;
    }

    // key로 검색하여 해당 value 리턴, key가 없으면 null 리턴
    @Override
    public String get(String key) {
        int foundIndex = findIndex(key);
        if (foundIndex == -1) {
            return null;
        }
        return valueArray[foundIndex];
    }

    // key와 value를 쌍으로 저장
    // key가 이미 있으면 value만 새 값으로 수정하고, 없으면 맨 뒤에 새로 추가
    @Override
    public void put(String key, String value) {
        int foundIndex = findIndex(key);
        if (foundIndex != -1) { // 이미 저장된 key → 값 수정
            valueArray[foundIndex] = value;
            return;
        }
        if (itemCount == keyArray.length) { // 배열이 가득 차서 더 이상 저장 불가
            System.out.println("사전이 꽉 차서 " + key + " 저장 불가");
            return;
        }
        keyArray[itemCount] = key;     // 새 key 저장
        valueArray[itemCount] = value; // 새 value 저장
        itemCount++;
    }

    // key에 해당하는 아이템(key, value)을 삭제하고 삭제된 value 리턴
    // key가 없으면 null 리턴
    @Override
    public String delete(String key) {
        int foundIndex = findIndex(key);
        if (foundIndex == -1) {
            return null;
        }
        String deletedValue = valueArray[foundIndex]; // 삭제할 value를 미리 보관

        // 삭제된 자리 뒤의 아이템들을 한 칸씩 앞으로 당겨 빈 칸을 메움
        for (int index = foundIndex; index < itemCount - 1; index++) {
            keyArray[index] = keyArray[index + 1];
            valueArray[index] = valueArray[index + 1];
        }
        itemCount--;
        keyArray[itemCount] = null;   // 맨 뒤 칸 비우기
        valueArray[itemCount] = null;
        return deletedValue;
    }

    // 현재 저장된 아이템 개수 리턴
    @Override
    public int length() {
        return itemCount;
    }
}

// main 함수를 실행하는 클래스 (문제에서 주어진 코드, 수정 불가)
public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
