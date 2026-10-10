/*
 * 성명: 최수빈
 * 과목명:자바프로그래밍
 * 분반: 01분반
 * 문제: A -->주어진 정수를 구성하는 수 중에 가장 빈도수가 작은 수 찾기
 */

package homework05;

import java.util.*;

public class Solution {
    // 문자열 s에서 가장 적게 등장한 숫자를 반환 (빈도가 같으면 가장 작은 숫자)
    static int solution(String s) {
        // key: 숫자, value: 등장 횟수
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int d = c - '0';
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        // 가장 적은 등장 횟수 찾기
        int min = Collections.min(map.values());
        
        // 등장 횟수가 min인 숫자들 중 가장 작은 숫자 고르기
        int answer = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == min) answer = Math.min(answer, m.getKey());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            System.out.println(solution(s));
        }
    }
}