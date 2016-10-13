package impl;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by dasom on 2016-10-11.
 */
public class SteppingStone {
    public static int totalNumber = 0;

    public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
        Scanner sc = new Scanner(new FileInputStream("input_data/scpc2016_1_2_input.txt"));

        //Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        if(T<1 || T>15) return;

        for(test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.

            int stone = sc.nextInt();
            if(stone<1 || stone>50000) return;

            int jumpCapacity = sc.nextInt();
            if(jumpCapacity<1 || jumpCapacity>100) return;

            int bumbs = sc.nextInt();
            if(bumbs<0 || bumbs>(stone/2)) return;

            int[] bumbsLocation = null;

            if(bumbs != 0){
                bumbsLocation = new int[bumbs];
                for(int i=0; i<bumbs; i++){
                    bumbsLocation[i] = sc.nextInt();
                }
            }




            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);

        }
    }

    public static void getNumber(int curruntPos, int ){


    }
}
