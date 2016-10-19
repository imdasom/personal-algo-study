package path.bj1753;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by dasom on 2016-10-18.
 */
public class DijkstraAlgorithm {
    public static final int INF = 10000000;

    public static void main(String[] args) throws IOException {

        //BufferedReader와 StringTokenizer 사용하여 읽어오는 방법. --> 이게 훨씬 빠르다.
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\input_data\\bj1753InputData.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nVertex = Integer.parseInt(st.nextToken());
        int nEdge = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        Vector<Element>[] adj = new Vector[nVertex];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<>();
        }

        for (int i = 0; i < nEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[start - 1].add(new Element(weight, end - 1));
        }

        int[] dist = new int[nVertex];
        boolean[] visited = new boolean[nVertex];

        for (int i = 0; i < nVertex; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        //--start Dijkstra Algorithm
        dist[K] = 0;    //시작점에서 시작점까지의 거리는 0이므로 초기화해준다.
        pq.offer(new Element(0, K));

        while (!pq.isEmpty()) {
            int curVertex;
            do {
                curVertex = pq.peek().vertex;
                pq.poll();
            } while (!pq.isEmpty() && visited[curVertex]);

            if (visited[curVertex]) break;

            for (Element e : adj[curVertex]) {
                int next = e.vertex;
                int oldDis = dist[next];
                int newDis = dist[curVertex] + e.dis;

                if (newDis < oldDis) {
                    dist[next] = newDis;
                    pq.offer(new Element(newDis, next));
                }
            }
        }
        //--end of Dijkstra Algorithm

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}

class Element implements Comparable<Element> {
    int dis;
    int vertex;

    public Element(int dis, int vertex) {
        this.dis = dis;
        this.vertex = vertex;
    }


    @Override
    public int compareTo(Element o) {
        return dis <= o.dis ? -1 : 1;
    }
}