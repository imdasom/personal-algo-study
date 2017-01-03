package bj02820_dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by dasom on 2016-12-27.
 */
public class Main2 {
    static int N, M;
    static ArrayList<Integer> empRelationship[];
    static int[] payments;
    static boolean[] visited;

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        initValues();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "p":
                    // 월급을 증가시킨다.
                    int superior = Integer.parseInt(st.nextToken()) - 1;
                    int increasedPay = Integer.parseInt(st.nextToken());

                    visited = new boolean[N];
                    DFS(superior, increasedPay);
                    break;

                case "u":
                    System.out.println(payments[Integer.parseInt(st.nextToken()) - 1]);
                    break;
            }
        }

        br.close();
    }

    private static void DFS(int curEmp, int increasedPay) {
        for (int i = 0; i < empRelationship[curEmp].size(); i++) {
            int nextEmp = empRelationship[curEmp].get(i);

            if(!visited[nextEmp]) {
                visited[nextEmp] = true;
                payments[nextEmp] += increasedPay;
                if(empRelationship[nextEmp] != null) DFS(nextEmp, increasedPay);
            }
        }
    }

    public static void initValues() throws IOException {

        br = new BufferedReader(new InputStreamReader(new FileInputStream("Baekjoon\\src\\bj02820_dfs\\input.txt")));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N<1 || N>500000 || M<1 || M>500000) return;


        empRelationship = new ArrayList[N];
        payments = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());;

            int pay = Integer.parseInt(st.nextToken());
            payments[i] = pay;  // 초기월급을 세팅한다.
            int superior;
            try{
                superior = Integer.parseInt(st.nextToken()) - 1;
            }catch (NoSuchElementException e){
                continue;   // 사장은 부하직원이 아니므로 초기월급만 저장하고 넘어간다.
            }

            if(empRelationship[superior] == null)
                empRelationship[superior] = new ArrayList<>();

            empRelationship[superior].add(i);   // 부하직원을 상사에게 등록시킨다.
        }

    }
}
