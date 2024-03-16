package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode n2 = head;
        ListNode n1 = head;
        int size = 1;
        while (n1.next != null) {
            size++;
            n1 = n1.next;
        }
        int ff = size - n;
        n1 = n2;
        if (ff == 0) {
            return head.next;
        }
        int ind = 1;
        while (true) {
            n1 = n2;
            n2 = n2.next;
            if (ind == ff) {
                n1.next = n2.next;
                return head;
            }
            ind++;
        }
    }

    public static void main(String[] args) {
        _19RemoveNthNodeFromEndOfList obj = new _19RemoveNthNodeFromEndOfList();
        LinkedList linked = new LinkedList();
        linked.insert(1);
        linked.insert(2);
        linked.insert(3);
        linked.insert(4);
        linked.insert(5);
        linked.show();
        linked.show(obj.removeNthFromEnd(linked.head, 3));
    }
}
