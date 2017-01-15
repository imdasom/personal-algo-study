package bj04963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-01-15.
 *
 * 백준 온라인 저지 맞은 사람 중 psychobabo님 답
 */

public class OthersSolution {
    static int w, h;
    static int[] size;
    static int[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int result;

    static boolean safe(int x, int y) {
        return (0<=x && x<w) && (0<=y && y<h);
    }

    static boolean cmp(int a, int b) {
        return a > b;
    }

    static void dfs(int x, int y, int value) {
        board[y][x] = value;
        for(int i=0; i<8; i++) {
            if(safe(x+dx[i], y+dy[i]) && board[y+dy[i]][x+dx[i]] == 1) {
                dfs(x+dx[i], y+dy[i], value);
            }
        }
    }

    static void solve() {
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(board[i][j] == 1) {
                    result++;
                    dfs(j,i,result+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        String input;
        StringBuffer sb = new StringBuffer("");
        while( !(input = br.readLine()).equals("0 0")) {
            token = new StringTokenizer(input);
            w = Integer.parseInt(token.nextToken());
            h = Integer.parseInt(token.nextToken());
            board = new int[h][w];
            size = new int[100];
            result = 0;
            for(int i=0; i<h; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            solve();
            sb.append(result + "\n");
        }
        System.out.print(sb.toString());
    }
}