package session1.chapter4;

/**
 * Created by dasom on 2016-10-19.
 */
public class Fibonacci {
    public static int[] fiboNums;

    public static void main(String[] args){
        int input = 13;

        fiboNums = new int[input+1];
        fiboNums[1] = 1;
        fiboNums[2] = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(fiboNums[1]).append(" ").append(fiboNums[2]).append(" ");

        for(int i=3; i<=input; i++){
            fiboNums[i] = fiboNums[i-2]+fiboNums[i-1];
            sb.append(fiboNums[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
}
