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
			int capaA = volumeA - a;									// a에 들어갈 수 있는 물의 양
			
			if(b > 0) {
				int availableAmount = b > capaA ? capaA : b;			// 실제 들어갈 수 있는 양
				moveWater(a + availableAmount, b - availableAmount, c);	// 물을 옮긴다
			}
			
			if(c > 0) {
				int availableAmount = c > capaA ? capaA : c;			// 실제 들어갈 수 있는 양
				moveWater(a + availableAmount, b, c - availableAmount);	// 물을 옮긴다
			}
		}
		
		if(b < volumeB) {
			int capaB = volumeB - b;									// b에 들어갈 수 있는 물의 양
			
			if(a > 0) {
				int availableAmount = a > capaB ? capaB : a;			// 실제 들어갈 수 있는 양
				moveWater(a - availableAmount, b + availableAmount, c);	// 물을 옮긴다.
			}
			
			if(c > 0) {
				int availableAmount = c > capaB ? capaB : c;			// 실제 들어갈 수 있는 양
				moveWater(a, b + availableAmount, c - availableAmount);	// 물을 옮긴다
			}
		}
		
		if(c < volumeC) {
			int capaC = volumeC - c;									// c에 들어갈 수 있는 물의 양
			
			if(a > 0) {
				int availableAmount = a > capaC ? capaC : a;			// 실제 들어갈 수 있는 양
				moveWater(a - availableAmount, b, c + availableAmount);	// 물을 옮긴다.
			}
			
			if(b > 0) {
				int availableAmount = b > capaC ? capaC : b;			// 실제 들어갈 수 있는 양
				moveWater(a, b - availableAmount, c + availableAmount);	// 물을 옮긴다
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
