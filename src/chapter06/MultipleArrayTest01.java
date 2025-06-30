package chapter06;
/*
 * 다차원 배열 (3 X 3)
 */
public class MultipleArrayTest01 {

	public static void main(String[] args) {
		// 3 X 3 : 3행 3열의 배열 생성
		int matrix[][] = new int[3][3];
		// 3 X ? : 3행은 정해졌으나 열은 나중에 생성
		int matrix2[][] = new int[3][];
		
		// matrix2의 1행 2행 3행
		matrix2[0] = new int[3];
		matrix2[1] = new int[6];
		matrix2[2] = new int[9];

		// 3 X 3 : 3행 3열의 배열 생성 및 데이터값 설정
		int matrix3[][] = { {0,0,0}, {0,0,0}, {0,0,0} };
		
		matrix[0][0] = 100;
		matrix[2][1] = 500;
		
		// matrix배열 출력
		for(int i = 0 ; i < matrix.length ; i++ ){
			for(int j = 0 ; j < matrix[i].length ; j++) {
				System.out.print("[" + i + "," + j + "] = " + matrix[i][j] + "\t");
			}
			System.out.println();
		}	

		System.out.println("------------------------------------------------------------");

		// matrix2배열 출력
		for(int i = 0 ; i < matrix2.length ; i++ ){
			for(int j = 0 ; j < matrix2[i].length ; j++) {
				System.out.print("[" + i + "," + j + "] = " + matrix2[i][j] + "\t");
			}
			System.out.println();
		}	

		System.out.println("------------------------------------------------------------");
		
		// matrix3배열 출력
		for(int i = 0 ; i < matrix3.length ; i++ ){
			for(int j = 0 ; j < matrix3[i].length ; j++) {
				System.out.print("[" + i + "," + j + "] = " + matrix3[i][j] + "\t");
			}
			System.out.println();
		}	

		System.out.println("------------------------------------------------------------");
		
	}

}
