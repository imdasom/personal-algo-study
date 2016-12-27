package bj02573_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-12-27.
 */
public class MainBFS {

    static int N, M;
    static int[][] arr, newArr;
    static boolean[][] visited;
    static int row, col;

    static Queue<IcebergData> q = new LinkedList<>();
    static int icebergCounter = 0;
    static int year = 0;
    static boolean breakPoint = false;

    public static void main(String[] args) throws IOException {
        initValues();

        while (true) {
            boolean isStartPointEixst = findStartPoint();

            if(!isStartPointEixst){
                if (icebergCounter > 1) break;
                else {
                    year++;
                    visited = new boolean[N][M];
                    arr = newArr;
                    newArr = new int[N][M];
                    icebergCounter = 0;
                    row = col = 0;

                    /*for (int i = row; i < N; i++) {
                        for (int j = col; j < M; j++) {
                            System.out.print(arr[i][j]+" ");
                        }
                        System.out.println();
                    }*/

                    continue;
                }
            }

            q.offer(new IcebergData(row, col, arr[row][col]));

            while(!q.isEmpty()){
                boolean breakPoint = BFS(q.poll());
                if(breakPoint) {
                    System.out.println(year);
                    return;
                }
            }
        }

        System.out.println(year);
    }

    public static boolean findStartPoint() {
        if(col == 6) col = 0;
        for (int i = row; i < N; i++) {
            for (int j = col; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    row = i;
                    col = j;
                    icebergCounter++;
                    return true;
                }
            }
        }

        return false;   // 시작점을 못 찾으면 모두 방문한 것이다. 얼음이 쪼개졌는지 확인해야 한다.
    }

    public static boolean BFS(IcebergData iData) {
        int row = iData.row;
        int col = iData.col;
        int val = iData.val;

        if (row < 0 || row > N || col < 0 || col > M) return false;
        if (visited[row][col]) return false;

        visited[row][col] = true;

        int breakCounter = 0;
        int count = 0;
        if (row - 1 >= 0) {
            if (arr[row - 1][col] == 0) {
                count++;
                breakCounter++;
            } else {
                if(!visited[row - 1][col])
                    q.offer(new IcebergData(row - 1, col, arr[row - 1][col]));
            }
        } else {
            breakCounter++;
        }

        if (row + 1 < N) {
            if (arr[row + 1][col] == 0) {
                count++;
                breakCounter++;
            } else {
                if(!visited[row + 1][col])
                    q.offer(new IcebergData(row + 1, col, arr[row + 1][col]));
            }
        } else {
            breakCounter++;
        }

        if (col - 1 >= 0) {
            if (arr[row][col - 1] == 0) {
                count++;
                breakCounter++;
            } else {
                if(!visited[row][col - 1])
                    q.offer(new IcebergData(row, col - 1, arr[row][col - 1]));
            }
        } else {
            breakCounter++;
        }

        if (col + 1 < M) {
            if (arr[row][col + 1] == 0) {
                count++;
                breakCounter++;
            } else {
                if(!visited[row][col + 1])
                    q.offer(new IcebergData(row, col + 1, arr[row][col + 1]));
            }
        } else {
            breakCounter++;
        }

        newArr[row][col] = ((val - count) < 0 ? 0 : (val - count));

        if(breakCounter == 4){
            return true;
        } else return false;
    }

    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj02573_bfs\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        newArr = new int[N][M];
        visited = new boolean[N][M];

        /*for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        br.close();
    }
}

class IcebergData {
    int row;
    int col;
    int val;

    public IcebergData(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
