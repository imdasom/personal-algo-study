package session1.chapter4;

/**
 * Created by dasom on 2016-10-20.
 */
public class Pi {

    public static void main(String[] args){

        float maxN = 200;
        float N = 1;

        float result = 0.0f;

        while(N <= maxN){
            float newNum = ((float) Math.pow(-1, N-1)) / ((2*N) - 1.0f);
            //newNum = (newNum / (2*N - 1));
            result += newNum;
            N++;
        }

        result = result*4.0f;
        System.out.format("%.6f\n", result);
    }
}
