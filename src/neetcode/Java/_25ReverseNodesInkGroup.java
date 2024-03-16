package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _25ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = temp;

        while (curr != null && curr.next != null) {
            int kk=0;
            ListNode tt=curr;
            while (kk<k) {
                ListNode seconPair = curr.next;
                ListNode nextPair = seconPair.next;

                seconPair.next = curr;
                curr.next = nextPair;
                prev.next = seconPair;

                curr = curr.next;
                kk++;
            }
            curr.next=tt;
            prev = curr;
            //curr = curr.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        _25ReverseNodesInkGroup obj = new _25ReverseNodesInkGroup();
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.show();
        list.show(obj.reverseKGroup(list.head,2));
    }
}
