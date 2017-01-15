package bj04963;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-01-15.
 */
public class Main {
    static int[] list;
    static int R, C, startR, startC, numOfLands;
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        // 이거 대체하는 좋은 방법
        // System.setIn(new FileInputStream("BaekJoon\\src\\bj04963\\input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("BaekJoon\\src\\bj04963\\input.txt")));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if(R + C == 0) break;

            list = new int[R*C];

            for (int row = 0; row < R; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < C; col++) {
                    list[row * C + col] = Integer.parseInt(st.nextToken());
                }
            }

            numOfLands = 0;
            startR = startC = 0;
            BFS();
            System.out.println(numOfLands);
        }
    }

    public static void BFS(){
        q = new LinkedList<>();

        while(findStartPoint()){
            while(!q.isEmpty()){
                Pair curPos = q.poll();
                final int ROW = curPos.row;
                final int COL = curPos.col;

                if(ROW-1 >= 0){
                    if(list[(ROW-1)*C+COL] == 1){
                        q.offer(new Pair(ROW-1, COL));
                        list[(ROW-1)*C + COL] = 0;
                    }

                    if(COL-1 >= 0 && list[(ROW-1)*C+(COL-1)] == 1){
                        q.offer(new Pair(ROW-1, COL-1));
                        list[(ROW-1)*C + (COL-1)] = 0;
                    }
                }

                if(ROW+1 < R){
                    if(list[(ROW+1)*C+COL] == 1){
                        q.offer(new Pair(ROW+1, COL));
                        list[(ROW+1)*C + COL] = 0;
                    }

                    if(COL-1 >= 0 && list[(ROW+1)*C+(COL-1)] == 1){
                        q.offer(new Pair(ROW+1, COL-1));
                        list[(ROW+1)*C + (COL-1)] = 0;
                    }
                }

                if(COL-1 >= 0){
                    if(list[ROW*C + (COL-1)] == 1){
                        q.offer(new Pair(ROW, COL-1));
                        list[ROW*C + (COL-1)] = 0;
                    }
                }

                if(COL+1 < C){
                    if(list[ROW*C + (COL+1)] == 1){
                        q.offer(new Pair(ROW, COL+1));
                        list[ROW*C + (COL+1)] = 0;
                    }

                    if(ROW-1 >= 0 && list[(ROW-1)*C+(COL+1)] == 1){
                        q.offer(new Pair(ROW-1, COL+1));
                        list[(ROW-1)*C + (COL+1)] = 0;
                    }

                    if(ROW+1 < R && list[(ROW+1)*C+(COL+1)] == 1){
                        q.offer(new Pair(ROW+1, COL+1));
                        list[(ROW+1)*C + (COL+1)] = 0;
                    }
                }
            }
        }
    }

    public static boolean findStartPoint(){
        for (int row = startR; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if(list[row*C + col] == 1){
                    startR = row;
                    startC = col;
                    numOfLands++;

                    // 방문처리
                    q.offer(new Pair(startR, startC));
                    list[startR*C + startC] = 0;
                    return true;
                }
            }
        }

        return false;
    }
}

class Pair{
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

