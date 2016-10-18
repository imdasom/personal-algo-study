package path.bj1753;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-18.
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("Baekjoon\\input_data\\bj1753InputData.txt"));
        int nVertex = sc.nextInt();
        int nEdge = sc.nextInt();
        int K = sc.nextInt();

        int[][] directedGraph = new int[nVertex+1][nVertex+1];
        for (int i = 1; i < nVertex+1; i++) {
            for(int j=0; j<nVertex+1; j++){
                directedGraph[i][j] = -1;
            }
        }

        while (sc.hasNext()) {
            directedGraph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }


        boolean[] visited = new boolean[nVertex+1];
        int[] distances = new int[nVertex+1]; //무한대로 초기화향 한다.
        for (int i = 1; i < nVertex+1; i++) {
            visited[i] = false;
            distances[i] = 999;
        }

        int[] sequence = new int[nVertex+1];
        int sequenceIndex = 1;

        //startVertex에 방문을 표시한다.
        int curVertex = K;
        visited[curVertex] = true;
        distances[curVertex] = 0;
        sequence[sequenceIndex++] = curVertex;

        while (!isVisitedAllNode(visited)) {
            System.out.println("\n while문 시작, curVertex : " + curVertex);
            //이 변수들은 min값 구하기 위해 쓰는거.
            int minDistance = distances[1];
            int minVertex = 1;

            for (int i = 1; i < nVertex+1; i++) {
                if (directedGraph[curVertex][i] == -1 || directedGraph[curVertex][i] == 0)
                    continue;

                if (distances[i] != 999) {
                    int newDis = directedGraph[curVertex][i] + distances[curVertex];
                    if (newDis < distances[i]) {
                        distances[i] = newDis;
                    }
                } else {
                    distances[i] = directedGraph[curVertex][i];
                }
z
                if ((minDistance == 0) || ((distances[i] < minDistance) && (!visited[i]))) {
                    minDistance = distances[i];
                    minVertex = i;
                }
            }

            curVertex = minVertex;
            visited[curVertex] = true;   // 거리가 가장 작은 정점을 방문한다.
            System.out.println("sequenceIndex : " + sequenceIndex);
            sequence[sequenceIndex++] = curVertex;
            //System.out.printf("startVertex, visited[%d], sequence[%d] : %d, %b, %d\n", curVertex, (sequenceIndex-1), startVertex, visited[curVertex], sequence[sequenceIndex-1]);
        }

        printPath(sequence);
        printWeight(distances);
    }

    public static boolean isVisitedAllNode(boolean[] visited) {
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    public static void printPath(int[] sequence) {
        for (int vertex : sequence) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    public static void printWeight(int[] distances) {
        for (int dis : distances) {
            System.out.print(dis + " ");
        }
        System.out.println();
    }
}
