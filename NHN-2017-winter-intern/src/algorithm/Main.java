package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by dasom on 2016-11-24.
 *
 *
 문제) Spade, Diamond, Heart, Clover 무늬와 1부터 13까지의 숫자가 있는 총 52장의 카드가 있다.
 S1, S2... S13,
 D1, D2... D13,
 H1, H2... H13,
 C1, C2... C13
 으로 표시된다.
 Player는 7장의 카드를 가지며, 숫자의 합이 제일 작은 사람이 이긴다.

 4명의 Player에게 중복 없이 랜덤하게 카드를 나누고, 이긴 Player를 출력하는 프로그램을 완성하시오.
 숫자의 합이 제일 작은 Player가 2명 이상이면 1명이 승리할 때까지 게임을 반복한다.

 출력 예)
 Player1: H2, H8, D5, D9, S12, S9, C13 : sum = 58
 Player2: C8, C6, S4, D4, D12, C2, C12 : sum = 48
 Player3: C10, S1, D2, D7, D10, C11, C9 : sum = 50
 Player4: D8, D1, H6, H13, C7, H10, S8 : sum = 53

 Winner : Player2

 * 요구 사항이 모호하다면, 그 부분을 재정의하여 서술하고 구현하시오.
 ** 시간 복잡도와 메모리 이슈, 최적의 성능에 중점을 두고, 읽기 좋은 코드로 작성해 주세요.
 */
public class Main {
    static final int CARD_NUMBER = 7;
    static final int PLAYER_NUMBER = 4;
    static int[] numOfCards = new int[53];
    static int cnt = 1; // 카드 카운터.

    public static void main(String[] args){

        // 플레이어수와 카드의 수만큼 배열을 생성한다.
        int[][] players = new int[PLAYER_NUMBER][CARD_NUMBER];

        // 섞기 전, 배열 초기화. 배열을 1~52까지 각 인덱스와 같은 값으로 초기화한다.
        Arrays.parallelSetAll(numOfCards, i -> i);

        // 최종 우승자 나올때까지 반복
        boolean isContinue = true;
        while(isContinue) {

            System.out.println("--- New Round! ---");


            // 카드를 섞는다.
            // 섞은 뒤에는 다시 맨 앞장(cnt=1)부터 ++cnt를 하며 한장씩 나눠준다.
            // 항상 맨 앞장부터 나누어 주므로 cnt를 0으로 초기화한다.
            cnt = 1;
            shuffle();


            // 플레이어 한 명씩 돌아가면서 카드를 배분하고 합을 구할 것이다.
            // 구한 합은 results에 저장한 뒤, Stream을 이용하여 같은 MIN값을 가진 플레이어가 있는지 판단할 때 사용한다.
            // 동시에 가장 작은 합을 가진 플레이어를 찾는다.
            int[] results = new int[PLAYER_NUMBER];
            int min = 9999;
            int minIndex = 0;

            for (int pNum = 0; pNum < PLAYER_NUMBER; pNum++) {
                System.out.print("Player" + (pNum+1) + ": ");

                // 먼저 카드를 7장 준다. 아직 1~52의 숫자로 구분되어 있다.
                Arrays.parallelSetAll(players[pNum], i -> numOfCards[cnt++]);


                // 1~52의 숫자를 1~13으로 구분하고, S,D,H,C로 구분하여 출력한다.
                // SUM도 구한다.
                int sum = 0;
                for(int i=0; i<CARD_NUMBER; i++){

                    // 1~52로 구분된 카드를 1~13의 값을 가지도록 계산한다.
                    int tempNum = players[pNum][i] % 13 == 0 ? 13 : players[pNum][i] % 13;
                    sum += tempNum;

                    // 카드의 종류를 구한다.
                    String tempType = "";
                    switch (players[pNum][i] / 13){
                        case 0: tempType = "S"; break;
                        case 1: tempType = "D"; break;
                        case 2: tempType = "H"; break;
                        case 3: tempType = "C"; break;
                        case 4: tempType = "C"; break;
                    }

                    System.out.print(tempType+tempNum);
                    if(i < CARD_NUMBER-1) System.out.print(", ");
                }

                if(sum < min){
                    min = sum;
                    minIndex = pNum;
                }
                results[pNum] = sum;
                System.out.println(" : sum = "+sum);
            }

            // 가장 작은 값을 가진 플레이어를 찾는다.
            final int MIN = min;

            // 가장 작은 값을 가진 플레이어가 한명이면 결과를 출력하고 루프를 빠져나간다.
            if((Arrays.stream(results).filter(i -> i == MIN).count()) == 1){

                // 결과 출력
                System.out.println("\nWinner : Player"+(minIndex + 1));
                isContinue = false;


            // 가장 작은 값을 가진 플레이어가 한명 이상이므로 루프를 빠져나가지 못한다.
            }else{
                System.out.println();
            }
        }
    }

    //카드를 섞는다. Fisher-Yates shuffle 알고리즘.
    public static void shuffle(){
        Random random = new Random();
        for (int i = numOfCards.length - 1; i >= 1; i--) {
            int x = random.nextInt(52) + 1;
            int temp = numOfCards[i];
            numOfCards[i] = numOfCards[x];
            numOfCards[x] = temp;
        }
    }

}
