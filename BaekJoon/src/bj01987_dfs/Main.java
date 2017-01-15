package bj01987_dfs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-01-15.
 */
public class Main {
    static int R, C;
    static char[] list;
    static boolean[] visited = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        initValues();

        DFS(0, 0, list[0], 1);

        System.out.println(max);
    }

    public static int DFS(int row, int col, char curChar, int result) {
        visited[curChar - 65] = true;
        if(result > max) max = result;

        char nextChar;

        if (row - 1 >= 0 && !visited[(nextChar = list[(row - 1) * C + col]) - 65]) {
            if (curChar != nextChar)
                result = DFS(row - 1, col, nextChar, result+1);
        }

        if (row + 1 < R && !visited[(nextChar = list[(row + 1) * C + col]) - 65]) {
            if (curChar != nextChar)
                result = DFS(row + 1, col, nextChar, result+1);
        }

        if (col - 1 >= 0 && !visited[(nextChar = list[row * C + (col - 1)]) - 65]) {
            if (curChar != nextChar)
                result = DFS(row, col - 1, nextChar, result+1);
        }

        if (col + 1 < C && !visited[(nextChar = list[row * C + (col + 1)]) - 65]) {
            if (curChar != nextChar)
                result = DFS(row, col + 1, nextChar, result+1);
        }

        visited[curChar - 65] = false;
        return result-1;

    }

    public static void initValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("BaekJoon\\src\\bj01987_dfs\\input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new char[R * C];

        for (int row = 0; row < R; row++) {
            String newLine = br.readLine();
            for (int col = 0; col < C; col++) {
                list[row * C + col] = newLine.charAt(col);
            }
        }
    }
}
