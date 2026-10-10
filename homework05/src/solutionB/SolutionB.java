/*
 * 성명: 최수빈
 * 과목명:자바프로그래밍
 * 분반: 01분반
 * 문제: B -->모든 비트가 1인 가장 작은 수 찾기
 */

package solutionB;
import java.util.Scanner;

public class SolutionB {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt(); //테스트 케이스 개수
		while(t-- > 0) {
			long n = sc.nextLong();
			long x = 1; // 비트가 전부 1인 가장 작은 수
			while(x < n) x = x * 2 +1;
			System.out.println(x);
		}
	}

}
