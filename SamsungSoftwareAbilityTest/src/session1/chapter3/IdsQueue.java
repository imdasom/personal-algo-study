package session1.chapter3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-10-19.
 */
public class IdsQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("SamsungSoftwareAbilityTest\\data\\QueueInputData.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrivalTime = Integer.parseInt(st.nextToken());
        int serviceTime = Integer.parseInt(st.nextToken());
        int testTime = Integer.parseInt(st.nextToken());

        int nPatient = 0;   //환자의 수 --> 큐에 있는 아이템의 갯수
        int nTotalPatient = 0;  //병원을 방문한 모든 환자의 수
        int maxPatientNumber = 0;   //최대 대기 고객 수





        System.out.println("서비스 받은 고객 : ");
        System.out.println("대기행렬에 남은 고객 수 : ");
        System.out.println("최대 대기 고객 수 : ");
    }
}
