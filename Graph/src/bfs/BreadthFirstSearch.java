package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pc on 2016-11-30.
 * <p>
 * 너비 우선 탐색 알고리즘
 */
public class BreadthFirstSearch {

    public static int nV = 6;
    public static int nE = 8;

    public static int[][] ad = {
            {0, 0, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1, 0}
    };

    public static boolean[] visited = new boolean[nV];

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            // 현재 방문하는 노드를 체크한다.
            int current = queue.poll();
            System.out.println("            poll : "+queue.toString());
            System.out.println("방문 : " + (current));

            // 방문 처리를 한 뒤 다음으로 탐색할 정점(연결된 정점)을 큐에 넣어준다.
            for (int i = 0; i < nV; i++) {

                // 인접행렬에서 연결되었는지 여부를 나타내는 데이터를 가져온다.
                // 그 데이터가 1이라면 연결된 것이고, visited[x]도 false라면 방문하지 않은 것이므로
                // 큐에 넣는다.
                if (ad[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }

            System.out.println("            offer : "+queue.toString());
        }
    }
}