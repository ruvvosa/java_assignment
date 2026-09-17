/*
 * 이름: 최수빈
 * 학번: 2025100066
 * 과목명: 자바프로그래밍(01분반)
 */


package homework01;

import java.util.Scanner;


public class Sol01 {

	//magazine의 문자만으로 ransomNote를 만들 수 있는지 검사
	static boolean canConstuct(String ransomNote,String magzine)
	{
		int[] freq = new int[26]; //정수 26개짜리 배열 생성
		
		//문자열을 문자 배열로 바꿈
		for(var c: ransomNote.toCharArray())
			--freq[c-'a'];
		
		for(var c: magzine.toCharArray())
			++freq[c-'a'];
		
		for(int i =0;i<26;i++)
			if(freq[i] < 0) return false;
		return true;

	}
	
	public static void main(String[] args) {
			Scanner in =  new Scanner(System.in);
			boolean done = false;
			while(!done)
			{
				System.out.print("랜섬 노트 입력: ");
				String ransomeNote = in.nextLine();
				System.out.print("잡지 문자열 입력: ");
				String magazine = in.nextLine();
				
				System.out.println(canConstuct(ransomeNote,magazine)?  "랜섬 노트 작성 가능" : "랜섬 노트 작성 불가");
	            System.out.print("계속(y/n)? ");
				String answer = in.nextLine();
	            done = !answer.equalsIgnoreCase("y"); //대소문자 구분 없이 y 또는 Y를 입력하면 계속 진행, 그밖의 문자는 중단
				
				
			}
	}

}
