package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else
                current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(2);
            list.insert(3);
            list.insert(3);
            list.insert(3);
            list.insert(4);
            list.insert(4);
            list.insert(5);

            list.show();

            _83RemoveDuplicatesFromSortedList obj = new _83RemoveDuplicatesFromSortedList();
            list.show(obj.deleteDuplicates(list.head));
        }
    }
}
