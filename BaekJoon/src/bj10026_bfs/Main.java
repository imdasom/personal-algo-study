package bj10026_bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2017-01-16.
 */
public class Main {
    static int N;
    static char curChar;
    static Queue<Pair> q = new LinkedList<>();
    static char[] list;
    static int startRow, startCol;
    static int result = 0, result2 = 0; //result2는 적색과 녹색이 인접한 횟수 카운팅하는 변수
    static boolean adjFlag = false;

    public static void main(String[] args) throws IOException {
        initValues();

        BFS();

        System.out.println(result+", "+result2);
    }

    public static void BFS() {

        while (findFirstPoint()) {

            while (!q.isEmpty()) {
                Pair curPos = q.poll();
                char nextChar;

                if (checkBoundary(curPos.row - 1, curPos.col)) {
                    nextChar = list[(curPos.row - 1) * N + curPos.col];
                    if ((curChar + nextChar) == 153 || (curChar + nextChar) == 185) {
                        adjFlag = true;

                    } else if (nextChar == curChar) {
                        list[(curPos.row - 1) * N + curPos.col] += 32;
                        q.offer(new Pair(curPos.row - 1, curPos.col));
                    }
                }

                if (checkBoundary(curPos.row + 1, curPos.col)) {
                    nextChar = list[(curPos.row + 1) * N + curPos.col];
                    if ((curChar + nextChar) == 153 || (curChar + nextChar) == 185) {
                        adjFlag = true;

                    } else if (nextChar == curChar) {
                        list[(curPos.row + 1) * N + curPos.col] += 32;
                        q.offer(new Pair(curPos.row + 1, curPos.col));
                    }
                }

                if (checkBoundary(curPos.row, curPos.col - 1)) {
                    nextChar = list[curPos.row * N + (curPos.col - 1)];
                    if ((curChar + nextChar) == 153 || (curChar + nextChar) == 185) {
                        adjFlag = true;

                    } else if (curChar == nextChar) {
                        list[curPos.row * N + (curPos.col - 1)] += 32;
                        q.offer(new Pair(curPos.row, curPos.col - 1));
                    }
                }

                if (checkBoundary(curPos.row, curPos.col + 1)) {
                    nextChar = list[curPos.row * N + (curPos.col + 1)];
                    if ((curChar + nextChar) == 153 || (curChar + nextChar) == 185) {
                        adjFlag = true;

                    } else if (curChar == nextChar) {
                        list[curPos.row * N + (curPos.col + 1)] += 32;
                        q.offer(new Pair(curPos.row, curPos.col + 1));
                    }
                }
            }

            if (adjFlag) {
                result2++;
            }
        }
    }

    public static boolean checkBoundary(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) {
            return true;
        }
        return false;
    }

    private static boolean findFirstPoint() {
        for (int i = startRow; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (list[i * N + j] < 90) {
                    result++;
                    adjFlag = false;
                    curChar = list[i * N + j];
                    startRow = i;
                    startCol = j;
                    q.offer(new Pair(startRow, startCol));
                    list[i * N + j] += 32;  // 방문 표시
                    return true;
                }
            }
        }
        return false;
    }

    public static void initValues() throws IOException {
        System.setIn(new FileInputStream("BaekJoon\\src\\bj10026_bfs\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new char[N * N];

        for (int i = 0; i < N; i++) {
            String newLine = br.readLine();
            for (int j = 0; j < N; j++) {
                list[i * N + j] = newLine.charAt(j);
            }
        }
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}