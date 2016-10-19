package session1.chapter4;

/**
 * Created by dasom on 2016-10-19.
 */
public class PrimeNumber {

    public static void main(String[] args){

        int num1 = 300;
        int num2 = 500;

        final int OFFSET = num1;
        boolean[] normalNums = new boolean[(num2-num1)+1];   //+1을 하는 이뉴는 0번 인덱스를 사용하지 않기 위해.

        int divider = 2;
        int max = (int)Math.sqrt(num2);


        while(divider < max){

            for(int i=0; i<normalNums.length; i++){
                if(!normalNums[i]){
                    if ((OFFSET+i) % divider == 0){
                        normalNums[i] = true;
                    }
                }
            }
            divider++;
        }

        int counter = 0;
        for(int i=0; i<normalNums.length; i++){
            if(!normalNums[i]){
                if((counter%10 == 0) && (counter!=0)) System.out.println();
                counter++;
                System.out.print((i+OFFSET)+" ");
            }
        }

        System.out.println("\n"+counter);
    }
}
