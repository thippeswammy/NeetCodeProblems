package neetcode.Java;

import neetcode.ListNodeFolder.Java.ListNode;


public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null || l2 != null || carry == 1) {
            sum = 0;
            if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            temp.next = listNode;
            temp = temp.next;
        }
//        if (carry != 0) {
//            ListNode list = new ListNode(carry);
//            temp.next = list;
//            temp = temp.next;
//        }

        return head.next;
    }

    public static void main(String[] args) {
        _2AddTwoNumbers _2AddTwoNumbers = new _2AddTwoNumbers();
/*
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        list1.insert(2);
        list1.insert(4);
        list1.insert(3);

        list2.insert(5);
        list2.insert(6);
        list2.insert(4);

        //solution.AddTwoNumbers(list,list2);

        list1 = _2AddTwoNumbers.addTwoNumbers(list1,list2);

*/
    }
}
