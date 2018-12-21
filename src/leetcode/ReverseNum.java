package leetcode;

/**
 * 翻转整数
 */
public class ReverseNum {

    public static void main(String[] args) {

        int num = 96463243;
        int result = test2(num);


    }

    public static int test2(int num){

        int last = (num<<2) -1;
        System.out.println(last);
        return 0;
    }

    public static int test1(int num){

        String numStr = String.valueOf(num);
        boolean negative = false;
        if(numStr.contains("-")){
            negative = true;
        }
        if(negative){
            numStr = numStr.substring(1, numStr.length());
        }
        String[] chars = numStr.split("");
        String result = "";
        int length = chars.length;
        for (int i = length - 1; i>=0; i--){
            result += chars[i];
        }
        if(negative){
            result = "-"+result;
        }

        try {
            int last = Integer.valueOf(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return Integer.valueOf(result);
    }
}
