package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

public class _61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = size(head);
        k = k % len;
        len = len - k;
        if (k == 0) return head;
        ListNode node = head;
        while (node.next != null && len >= 2) {
            len--;
            node = node.next;
        }
        ListNode nextNode = node.next;
        ListNode temp = nextNode;
        node.next = null;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = head;
        return temp;
    }

    public int size(ListNode Head) {
        ListNode n = Head;
        int size = 1;
        while (n.next != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public static void main(String[] args) {
        _61RotateList obj = new _61RotateList();
        {
            for (int i = 1; i < 10; i++) {
                LinkedList list = new LinkedList();

                list.insert(1);
                list.insert(2);
                list.insert(3);
                list.insert(4);
                list.insert(5);

                //list.show();


                list.show(obj.rotateRight(list.head, i));
            }
            {
                LinkedList list = new LinkedList();

                list.insert(1);
                list.show();
                list.show(obj.rotateRight(list.head, 0));
            }

            {
                LinkedList list = new LinkedList();
                list.show();
                list.show(obj.rotateRight(list.head, 0));
            }
        }
    }
}
