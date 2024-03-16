package neetcode.ListNodeFolder.Java;

public class LinkedList {
    public ListNode head;

    public ListNode insert(int val) {
        ListNode newListNode = new ListNode();
        newListNode.val = val;
        if (head == null) {
            head = newListNode;
        } else {
            ListNode n = head;
            while (n.next != null) n = n.next;
            n.next = newListNode;
        }
        return head;
    }

    public ListNode insert(ListNode Head, int val) {
        ListNode newListNode = new ListNode();
        newListNode.val = val;
        if (Head == null) {
            Head = newListNode;
        } else {
            ListNode n = head;
            while (n.next != null) n = n.next;
            n.next = newListNode;
        }
        return Head;
    }

    public void show() {
        ListNode n = head;
        n = head;
        System.out.print("[ ");
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("]");

    }

    public void show(ListNode Head) {
        ListNode n = Head;
        n = Head;
        System.out.print("[ ");
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("]");
    }

    public int size() {
        ListNode n = head;
        int size = 1;
        while (n.next != null) {
            size++;
            n = n.next;
        }
        return size;
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

    public ListNode RemoveNthNodeFromEnd(int n) {
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

    public ListNode RemoveNthNodeFromEnd(ListNode Head, int n) {
        ListNode n2 = Head;
        ListNode n1 = Head;
        int size = 1;
        while (n1.next != null) {
            size++;
            n1 = n1.next;
        }
        int ff = size - n;
        n1 = n2;
        if (ff == 0) {
            return Head.next;
        }
        int ind = 1;
        while (true) {
            n1 = n2;
            n2 = n2.next;
            if (ind == ff) {
                n1.next = n2.next;
                return Head;
            }
            ind++;
        }
    }
}
