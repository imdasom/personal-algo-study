package cp;

/**
 * Created by dasom on 2016-10-22.
 */
public class solution3 {

    public static void main(String[] args) {
        System.out.println(solution("aaaabaa"));
    }

    public static int solution(String str) {

        //방법. 뒤집어서 겹치는 부분을 찾는 방법...
        if(str.length() == 1) return 1;

        StringBuilder sb = new StringBuilder(str);
        String reversedStr = sb.reverse().toString();

        final int STR_LEN = str.length();
        final int REV_STR_LEN = reversedStr.length();

        int strIndex = STR_LEN - 1;
        int revStrIndex = REV_STR_LEN - 1;
        int lastSameWordIndex = -1;

        while(true){
            char ch1 = str.charAt(strIndex);
            char ch2 = reversedStr.charAt(revStrIndex);

            if(ch1 == ch2){
                if(lastSameWordIndex == -1) lastSameWordIndex = revStrIndex;
                strIndex--;
                revStrIndex--;
            }else{
                lastSameWordIndex = -1;

                if(strIndex == STR_LEN - 1){
                    revStrIndex--;
                }else{
                    strIndex = STR_LEN - 1;
                }
            }

            if(revStrIndex == -1) break;
        }

        String newStr = reversedStr.substring(lastSameWordIndex+1, REV_STR_LEN);

        return (str+newStr).length();
    }
}