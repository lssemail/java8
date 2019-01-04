package leetcode;

import java.util.*;

/**
 * 回文数
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }

    /**
     * 有效符号判断
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('{', '}');
        mapping.put('[', ']');
        mapping.put('(', ')');


        Stack<Character> stack = new Stack<>();
        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(mapping.containsKey(c)){
                stack.push(c);
                continue;
            }else {
                char topElement =  stack.isEmpty() ? '#' : stack.pop();
                if(topElement == '#' || mapping.get(topElement) != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 寻找最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        List<Integer> sizeList = new ArrayList<>();
        if(strs.length == 0){
            return "";
        }
        int minLength = 0;
        for (String str : strs){
            int strLength = str.length();
            sizeList.add(strLength);
            minLength = minLength == 0 ? strLength : minLength <= strLength ? minLength : strLength;
        }
        int index = sizeList.indexOf(minLength);
        String minStr = strs[index];
        for (int i = minLength; i > 0; i--){
            String temp = minStr.substring(0, i);
            boolean equls = true;
            for (int j = 0; j < strs.length; j++){
                if(j == index){
                    continue;
                }

                if(!strs[j].startsWith(temp)){
                    equls = false;
                    break;
                }
            }
            if(equls){
                return temp;
            }
        }
        return "";
    }

    public static boolean isPalindrome1(int num){

        String str = Integer.valueOf(num).toString();
        String[] arr = str.split("");
        int length = arr.length;
        for(int i = 0; i< length/2; i++){
            if(!arr[i].equals(arr[length - 1-i])){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(int num){

        //小于0必定不是,若最后一位是0，则只有0是回文数
        if(num < 0 || (num % 10 == 0 && num != 0)){
            return false;
        }

        int revertedNumber = 0;
        while (num > revertedNumber){
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }
        return num == revertedNumber || num == revertedNumber / 10;
    }


    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>(7);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        if(s.length() == 1){
            return map.get(s);
        }
        String[] arr = s.split("");
        Integer sum = 0;
        int length = arr.length;
        for (int i = length - 1; i > 0; i-=2){
            Integer left = map.get(arr[i-1]);
            Integer right = map.get(arr[i]);
            sum += left >= right ? left + right : right - left;

        }
        if(length % 2 == 1){
            sum += map.get(arr[0]);
        }

        return sum;
    }

}
