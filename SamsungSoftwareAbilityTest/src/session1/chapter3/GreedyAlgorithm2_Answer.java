package session1.chapter3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dasom on 2016-10-18.
 */
public class GreedyAlgorithm2_Answer {

    public static final int INF = 1000000000;   //절대 나올 수 없는 경로값

    public static int V;
    public static int E;
    public static int K;
    public static Vector<Pair>[] adj;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("SamsungSoftwareAbilityTest\\data\\GreedyAlgorithm2_AnswerInputData.txt"));
        //Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        adj = new Vector[V];
        for(int i=0; i<V; i++){
            adj[i] = new Vector<>();
        }

        K--;

        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj[u-1].add(new Pair(w, v-1));
        }

        int[] dis = new int[V];
        fill(dis, INF);

        boolean[] visited = new boolean[V];
        fill(visited, false);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        startDijkstraAlgorithm(dis, visited, priorityQueue);

        for(int i=0; i<V; i++){
            if(dis[i] == INF) System.out.println("INF");
            else
                System.out.println(dis[i]);
        }
    }

    public static void startDijkstraAlgorithm(int[] dis, boolean[] visieted, PriorityQueue<Pair> pq){
        dis[K] = 0; //시작점에서 시작점의 거리는 0
        pq.add(new Pair(0, K)); //시작점을 pq에 넣고 시작

        //pq가 비면 종료한다.
        while(!pq.isEmpty()){
            int curV;

            do{
                curV = pq.peek().vector;
                pq.poll();
            }while(!pq.isEmpty() && visieted[curV]);    //curV가 방문한 정점이면 무시한다.(즉, 큐에서 계속해서 꺼낸다.)

            // while문을 다 돌았는데도 curV가 true면 더 이상 방문할 정점이 없는 것이므로 while문을 빠져나간다.
            if(visieted[curV]) break;

            visieted[curV] = true;  //방문
            for(Pair pair : adj[curV]){
                int next = pair.vector;
                int totalDis = pair.dis;

                if(dis[next] > dis[curV] + totalDis){
                    dis[next] = dis[curV] + totalDis;
                    pq.add(new Pair(dis[next], next));
                }
            }
        }
    }

    public static void fill(int[] arr, int value){
        for(int i=0; i<arr.length; i++){
            arr[i] = value;
        }
    }

    public static void fill(boolean[] arr, boolean value){
        for(int i=0; i<arr.length; i++){
            arr[i] = value;
        }
    }
}

class Pair implements Comparable<Pair>{
    int dis;
    int vector;

    public Pair(int dis, int vector){
        this.dis = dis;
        this.vector = vector;
    }

    @Override
    public int compareTo(Pair o) {
        return dis <= o.dis ? -1 : 1;
    }
}