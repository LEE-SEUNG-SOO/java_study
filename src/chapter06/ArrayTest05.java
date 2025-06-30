package chapter06;
/*
 * 배열생성시 에러모음
 * 
 */
public class ArrayTest05 {

	public static void main(String[] args) {
		int nList[] = new int[3];
		// nList = "1"; // nList는 주소를 저장하기때문에 에러
		// nList[0] = "1"; // 정수형 배열에 문자열을 넣으려고 함으로 데이터형 미스
		// nList[3] = 99; // 코드작성시에는 데이터형이 일치하므로 에러가 없으나
						  // Runtime시에 ArrayIndexOutOfBoundsException 에러(nList는 최대 2의 Index까지 존재)
		
		// nList의 주소
		System.out.println(nList);
		// nList의 해쉬코드
		System.out.println(nList.hashCode());

		for(int i = 0 ;i <nList.length ; i++) {
			System.out.println("nList[" + i + "] : " + nList[i]);
		}
		
		
	}

}
