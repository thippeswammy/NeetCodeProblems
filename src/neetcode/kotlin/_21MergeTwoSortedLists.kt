package neetcode.kotlin

import neetcode.ListNodeFolder.Java.LinkedList
import neetcode.ListNodeFolder.Java.ListNode

class _21MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode {
        var list1 = list1
        var list2 = list2
        var head1 = ListNode()
        val head = head1
        while (list1 != null && list2 != null) {
            if (list1.`val` <= list2.`val`) {
                head1.next = list1
                list1 = list1.next
            } else {
                head1.next = list2
                list2 = list2.next
            }
            head1 = head1.next
        }
        if (list1 == null) head1.next = list2
        else head1.next = list1

        return head.next
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _21MergeTwoSortedLists()
            val linked = LinkedList()
            linked.insert(1)
            linked.insert(2)
            linked.insert(4)
            linked.show()

            val linked2 = LinkedList()
            linked2.insert(1)
            linked2.insert(3)
            linked2.insert(4)
            linked2.show()

            linked.show(obj.mergeTwoLists(linked.head, linked2.head))
        }
    }
}