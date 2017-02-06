package ids;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int volumeA, volumeB, volumeC;
	static int realA, realB, realC;
	static boolean[] result = new boolean[200+1];
	static boolean[][][] visited = new boolean[200+1][200+1][200+1];
	
	public static void main(String[] args) throws IOException {
		initValues();
		
		result[volumeC] = true;
		moveWater(realA, realB, realC);
		
		for(int i=0; i<201; i++) {
			System.out.print((result[i] == true ? i+" " : ""));
		}
	}
	
	public static void moveWater(int a, int b, int c) {

		if(visited[a][b][c]) 	return;
		else					visited[a][b][c] = true;
		
		if(a == 0) result[c] = true;
		
		if(a < volumeA) {
			int capaA = volumeA - a;									// a�� �� �� �ִ� ���� ��
			
			if(b > 0) {
				int availableAmount = b > capaA ? capaA : b;			// ���� �� �� �ִ� ��
				moveWater(a + availableAmount, b - availableAmount, c);	// ���� �ű��
			}
			
			if(c > 0) {
				int availableAmount = c > capaA ? capaA : c;			// ���� �� �� �ִ� ��
				moveWater(a + availableAmount, b, c - availableAmount);	// ���� �ű��
			}
		}
		
		if(b < volumeB) {
			int capaB = volumeB - b;									// b�� �� �� �ִ� ���� ��
			
			if(a > 0) {
				int availableAmount = a > capaB ? capaB : a;			// ���� �� �� �ִ� ��
				moveWater(a - availableAmount, b + availableAmount, c);	// ���� �ű��.
			}
			
			if(c > 0) {
				int availableAmount = c > capaB ? capaB : c;			// ���� �� �� �ִ� ��
				moveWater(a, b + availableAmount, c - availableAmount);	// ���� �ű��
			}
		}
		
		if(c < volumeC) {
			int capaC = volumeC - c;									// c�� �� �� �ִ� ���� ��
			
			if(a > 0) {
				int availableAmount = a > capaC ? capaC : a;			// ���� �� �� �ִ� ��
				moveWater(a - availableAmount, b, c + availableAmount);	// ���� �ű��.
			}
			
			if(b > 0) {
				int availableAmount = b > capaC ? capaC : b;			// ���� �� �� �ִ� ��
				moveWater(a, b - availableAmount, c + availableAmount);	// ���� �ű��
			}
		}
	}
	
	public static void initValues() throws IOException{
		System.setIn(new FileInputStream("C:\\Users\\daim\\workspace\\BaekJoon02251\\src\\ids\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		volumeA = Integer.parseInt(st.nextToken());
		volumeB = Integer.parseInt(st.nextToken());
		volumeC = Integer.parseInt(st.nextToken());
		
		realA = realB = 0;
		realC = volumeC;
	}
}
