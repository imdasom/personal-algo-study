package impl;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dasom on 2016-10-08.
 * 이 문제는 Collatz conjecture 라는 유명한 문제.
 */
public class ThreeNPlusOne {
    public static void main(String[] args){
        new ThreeNPlusOne();
    }

    public ThreeNPlusOne() {
        correctImpl();
    }

    public void idsImpl() {
        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.

            int K = sc.nextInt();
            Vector<Integer> mainArr = new Vector<>();
            mainArr.add(1);

            for (int j = 0; j < K; j++) {
                Vector<Integer> tempList = new Vector<>();
                for (int i = 0; i < mainArr.size(); i++) {
                    int number = mainArr.get(i);

                    tempList.add(number * 2);

                    int q = (number - 1) / 3;
                    int r = (number - 1) % 3;
                    if ((r == 0) && (q != 1) && (number != 1)) {
                        tempList.add(q);
                    }
                }

                mainArr = tempList;
            }

            Collections.sort(mainArr);
            /*mainArr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 < o2 ? -1 : 1;
                }
            });*/

            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);
            System.out.print(mainArr.get(0) + " " + mainArr.get(mainArr.size() - 1));
        }
    }

    public static void correctImpl() {
        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        if(T < 1 || T > 32) return;

        for (test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.

            int K = sc.nextInt();
            if(K < 0 || K > 63) return;

            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);
            System.out.println(get3N1Number(1, K, false) + " " + get3N1Number(1, K, true));
        }
    }

    public static long get3N1Number(long N, int K, boolean type) {
        if (K == 0) return N;

        // N/2 구하기 --> N*2를 해주어야 한다.
        long NN = Long.parseLong(String.valueOf(get3N1Number(N * 2, K - 1, type)));

        // 3N + 1 구하기 --> N/3 - 1을 해주어야 한다.
        long q = (N - 1) / 3;    //몫이 1이 아니어야만 한다.
        long r = (N - 1) % 3;    //나머지가 0이어야만 한다.
        if ((N-1 >= 6) && (r == 0) && (q%2 != 1)) {
            long tempNN = Long.parseLong(String.valueOf(get3N1Number(q, K - 1, type)));
            if (type) {
                // type == true 이면 최대값 구하기
                NN = (NN > tempNN ? NN : tempNN);
            } else {
                NN = (NN < tempNN ? NN : tempNN);
            }
        }

        return NN;
    }
}
