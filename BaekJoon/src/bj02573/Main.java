package bj02573;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-12-25.
 */
public class Main {
    static int N, M;
    static int[][] arr, newArr;
    static boolean[][] visited;
    static int row, col;

    static Stack<IcebergData> stack = new Stack<>();
    static int icebergCounter = 0;
    static int year = 0;

    public static void main(String[] args) throws IOException {
        initValues();
        System.out.println(N);
        System.out.println(M);

        while (!isSeperated()) {
            findStartPoint();
            DFS(stack.pop());

            if (visitedAll()) {
                year++;
                visited = new boolean[N][M];
                arr = newArr;
                newArr = new int[N][M];
                icebergCounter = 0;
                row = col = 0;
            }
        }

        System.out.println(year);
    }

    public static boolean visitedAll() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void findStartPoint() {
        for (int i = row; i < N; i++) {
            for (int j = col; j < M; j++) {
                if (/*arr[i][j] != 0 && */!visited[i][j]) {
                    row = i;
                    col = j;
                    // 스택에 넣는다
                    stack.push(new IcebergData(row, col, arr[i][j]));
                    icebergCounter++;
                    return;
                }
            }
        }
    }

    public static void DFS(IcebergData iData) {
        int row = iData.row;
        int col = iData.col;
        int val = iData.val;

        if (row < 0 || row > N || col < 0 || col > M) return;
        if (val!=0 && visited[row][col]) return;

        visited[row][col] = true;

        int count = 0;
        if (row - 1 >= 0) {
            if (arr[row - 1][col] == 0) {
                //if (!visited[row - 1][col]) visited[row - 1][col] = true;
                count++;
            } /*else*/ stack.push(new IcebergData(row - 1, col, arr[row - 1][col]));
        }

        if (row + 1 < N) {
            if (arr[row + 1][col] == 0) {
                //if (!visited[row + 1][col]) visited[row + 1][col] = true;
                count++;
            } /*else*/ stack.push(new IcebergData(row + 1, col, arr[row + 1][col]));
        }

        if (col - 1 >= 0) {
            if (arr[row][col - 1] == 0) {
                //if (!visited[row][col - 1]) visited[row][col - 1] = true;
                count++;
            } /*else*/ stack.push(new IcebergData(row, col - 1, arr[row][col - 1]));
        }

        if (col + 1 < M) {
            if (arr[row][col + 1] == 0) {
                //if (!visited[row][col + 1]) visited[row][col + 1] = true;
                count++;
            } /*else */stack.push(new IcebergData(row, col + 1, arr[row][col + 1]));
        }

        if(val > 0) newArr[row][col] = val - count;

        while (!stack.isEmpty()) {
            DFS(stack.pop());
        }
    }

    public static boolean isSeperated() {
        if (icebergCounter > 1) return true;
        else return false;
    }

    public static void initValues() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj02573\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        newArr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

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
