package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists[0].next;
    }

    public static void main(String[] args) {
        _23MergekSortedLists obj = new _23MergekSortedLists();
        LinkedList linked = new LinkedList();
        linked.insert(1);
        linked.insert(4);
        linked.insert(5);
        linked.show();

        LinkedList linked2 = new LinkedList();
        linked2.insert(1);
        linked2.insert(3);
        linked2.insert(4);
        linked2.show();

        LinkedList linked3 = new LinkedList();
        linked3.insert(2);
        linked3.insert(6);
        linked3.show();

        linked.show(obj.mergeKLists(
                new ListNode[]{linked.head, linked2.head, linked3.head}));
    }
}
