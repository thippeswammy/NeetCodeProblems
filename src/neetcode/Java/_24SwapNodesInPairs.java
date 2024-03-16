package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = temp;

        while (curr != null && curr.next != null) {
            ListNode seconPair = curr.next;
            ListNode nextPair = seconPair.next;

            seconPair.next = curr;
            curr.next = nextPair;
            prev.next = seconPair;

            prev = curr;
            curr = nextPair;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        _24SwapNodesInPairs obj = new _24SwapNodesInPairs();

        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.show();
        list.show(obj.swapPairs(list.head));
    }
}
