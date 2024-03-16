package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = new ListNode();
        ListNode head = head1;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head1.next = list1;
                list1 = list1.next;
            } else {
                head1.next = list2;
                list2 = list2.next;
            }
            head1 = head1.next;
        }
        if (list1 == null) head1.next = list2;
        else
            head1.next = list1;

        return head.next;
    }

    public static void main(String[] args) {
        _21MergeTwoSortedLists obj = new _21MergeTwoSortedLists();
        LinkedList linked = new LinkedList();
        linked.insert(1);
        linked.insert(2);
        linked.insert(4);
        linked.show();

        LinkedList linked2 = new LinkedList();
        linked2.insert(1);
        linked2.insert(3);
        linked2.insert(4);
        linked2.show();

        linked.show(obj.mergeTwoLists(linked.head, linked2.head));
    }
}