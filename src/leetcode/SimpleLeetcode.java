package leetcode;

import jodd.util.ArraysUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018-12-24.
 */
public class SimpleLeetcode {

    public static void main(String[] args) {


        String str = "105_0-56-1.jpg";
        String[] array = str.split(".jpg");
        System.out.println(str.split(".")[0].split("-")[2]);


    }


    public static int maxSubArray(int[] nums) {

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int sum = nums[0];
        return sum;
    }


    public static String countAndSay(int n) {


        return "";
    }

    public static int searchInsert(int[] nums, int target) {

        nums = new int[]{1,3,5,6};
        target = 0;

        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;

    }

    /**
     * 拓展可以了解：kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0){
            return 0;
        }

        if(!haystack.contains(needle)){
            return -1;
        }

        int k = needle.length();
        int i = 0;
        while (i + k <= haystack.length()){
            if(haystack.substring(i, k).equals(needle)){
                return i;
            }else {
                i++;
            }
        }
        return -1;

    }

    public static void removeElement() {
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        int count = 0;
        for (int i=0; i< nums.length; i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;

            }
        }
        System.out.println(count);
    }

    public static int removeDuplicates() {
        int[] nums={1, 1, 2};
        int count = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != nums[count]){
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }


    public  static void ans21(){
        ListNode ld2 = new ListNode(4, null);
        ListNode ld1 = new ListNode(2, ld2);
        ListNode ld0 = new ListNode(1, ld1);

        ListNode ld5 = new ListNode(4, null);
        ListNode ld4 = new ListNode(3, ld5);
        ListNode ld3 = new ListNode(1, ld4);

        ListNode node = mergeTwoLists(ld0, ld3);
        System.out.println(node);
    }
    /**
     * [Q]21
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1 == null){
            node.next = l2;
        }else {
            node.next = l1;
        }
        return  head.next;
    }
}
