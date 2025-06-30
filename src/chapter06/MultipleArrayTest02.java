package chapter06;
/*
 * 다차원 배열
 */
public class MultipleArrayTest02 {

	public static void main(String[] args) {
		// 가변형 배열 생성 : 3행의 구조에 열은 1부터 하나씩 증가하는 구조
		int nList[][] = new int[8][];
		int numCount = 0;
		
		// 열 생성(행이 홀수 일 경우)
		if((nList.length % 2) != 0) {
			for(int i = 0 ; i < nList.length ; i++){
				// 중간지점까지 각 열 수 1씩 증가
				if(i <= (nList.length/2)){
					nList[i] = new int [i+1];	
				} 
				// 중간지점이후 각 열 수 1씩 감소
				else {
					nList[i] = new int [nList.length - i];
				}
			}
		} 
		// 열 생성(행이 짝수 일 경우)
		else {
			for(int i = 0 ; i < nList.length ; i++){
				// 중간지점까지 각 열 수 1씩 증가
				if(i < (nList.length/2)){
					nList[i] = new int [i+1];
				} 
				// 행수가 중간지점일 경우
				else if(i == nList.length/2) {
					nList[i] = new int [i];
				} 
				// 중간지점이후 각 열 수 1씩 감소
				else {
					nList[i] = new int [nList.length - i];
				}
			}
		}
						
		//출력
		for(int i = 0; i < nList.length; i++) {
			for(int j =0; j < nList[i].length; j++) {
				// 각 배열에 1씩 증가하는 값 입력
				nList[i][j] = ++numCount;
				System.out.print("nList[" + i +"]" + "[" + j + "] : " + nList[i][j] + " \t");
			}
				System.out.println();
		}		
	}
}
