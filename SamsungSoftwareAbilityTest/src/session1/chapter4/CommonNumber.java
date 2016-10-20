package session1.chapter4;

/**
 * Created by dasom on 2016-10-20.
 */
public class CommonNumber {

    public static void main(String[] args){
        long num1 = 1587645;
        long num2 = 67545;

        long divisor = 2;
        long greatestCommonDivisor = 1; //최대공약수
        while(divisor<=num1 && divisor<=num2){
            if(num1%divisor == 0 && num2%divisor == 0){
                greatestCommonDivisor *= divisor;
                num1 /= divisor;
                num2 /= divisor;
            }else{
                divisor++;
            }
        }
        System.out.println(greatestCommonDivisor);

        long lowestCommonDenominator = (greatestCommonDivisor*num1*num2);   //최소공배수
        System.out.println(lowestCommonDenominator);


    }
}
