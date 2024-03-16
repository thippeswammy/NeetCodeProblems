package neetcode.Java;

import neetcode.ListNodeFolder.Java.LinkedList;
import neetcode.ListNodeFolder.Java.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _82RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(head!= null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else{
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        List<Integer> l = new ArrayList<>();
        while (current!=null){
            if(current.next!=null){
                if(current.val==current.next.val && !l.contains(current.val)) l.add(current.val);
            }
            current=current.next;
        }
        ListNode joint=new ListNode();
        current=head;
        head=joint;
        while (current!=null){
            if(!l.contains(current.val)){
                joint.next=current;
                joint=joint.next;
            }
            current=current.next;
        }
        joint.next=null;
        return head.next;
    }

    public static void main(String[] args) {
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(1);
            list.insert(1);
            list.insert(2);
            list.insert(2);
            list.insert(3);

            list.show();

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(1);
            list.insert(2);
            list.insert(2);

            list.show();

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
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

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(1);
            list.insert(1);
            list.insert(2);
            list.insert(3);

            list.show();

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(1);

            list.show();

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
        {
            LinkedList list = new LinkedList();
            list.insert(1);
            list.insert(2);
            list.insert(2);

            list.show();

            _82RemoveDuplicatesFromSortedListII obj = new _82RemoveDuplicatesFromSortedListII();
            list.show(obj.deleteDuplicates(list.head));
            System.out.println("\n");
        }
    }
}
