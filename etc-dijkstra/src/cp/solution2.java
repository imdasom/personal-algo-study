package cp;

/**
 * Created by dasom on 2016-10-22.
 */
public class solution2 {
    public static int totalResult = 0;

    public static void main(String[] args){
        solution(new int[]{1, 2, 5, 10}, 1000);
        System.out.println(totalResult);

    }

    public static int solution(int[] coinTypes, int money) {

        if(coinTypes.length<1 || coinTypes.length>20) return -1;
        for(int i=0; i<coinTypes.length; i++){
            if(coinTypes[i]<1 || coinTypes[i]>10000) return -1;
        }
        if(money<1 || money>10000) return -1;

        getMoney(money, coinTypes, 0);

        return totalResult;
    }

    public static void getMoney(int money, int[] coinTypes, int coinTypeIndex){

        int maxNum = money / coinTypes[coinTypeIndex];

        for(int i=0; i<=maxNum; i++){
            int tempMoney = money - coinTypes[coinTypeIndex] * i;
            int nextCoinType = coinTypeIndex + 1;

            if(nextCoinType+1 == coinTypes.length){
                //맨 마지막 코인이라는 것이다. 이 코인으로 최종 결과를 계산한다.
                //코인타입의 마지막 인덱스라서 더 이상 사용할 코인이 없기 떄문.
                if(tempMoney % coinTypes[nextCoinType] == 0){
                    totalResult++;
                    continue;
                }
            }else if(coinTypes.length > 1){
                getMoney(tempMoney, coinTypes, nextCoinType);
            }
        }
    }
}