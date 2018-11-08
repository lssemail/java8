package leetcode;

/**
 * Created by Administrator on 2018-11-3.
 */
public class TwoNumbersAdd {

    static ListNode result = new ListNode(0);

    public static void main(String[] args) {

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        ListNode r = addTwoNumbers(a1, b1);
        System.out.println(r);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){



        if(l1.next == null || l2.next == null){
            return result;
        }else {
            int v1 = l1.val;
            int v2 = l2.val;
            int add = v1 +  v2;
            int n = 0;
            if(add >= 10){
                n = add % 10;
                ListNode next = new ListNode(n);
                result.val = n;
                result.next = next;
            }else {
                result.val = add;
            }

            addTwoNumbers(l1.next, l2.next);

        }

        return result;
    }
}

class ListNode{

    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
