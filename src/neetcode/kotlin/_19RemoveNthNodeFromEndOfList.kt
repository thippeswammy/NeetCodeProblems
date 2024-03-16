package neetcode.kotlin

import neetcode.ListNodeFolder.Java.LinkedList
import neetcode.ListNodeFolder.Java.ListNode

class _19RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode, n: Int): ListNode {
        var n2 = head
        var n1 = head
        var size = 1
        while (n1.next != null) {
            size++
            n1 = n1.next
        }
        val ff = size - n
        n1 = n2
        if (ff == 0) {
            return head.next
        }
        var ind = 1
        while (true) {
            n1 = n2
            n2 = n2.next
            if (ind == ff) {
                n1.next = n2.next
                return head
            }
            ind++
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _19RemoveNthNodeFromEndOfList()
            val linked = LinkedList()
            linked.insert(1)
            linked.insert(2)
            linked.insert(3)
            linked.insert(4)
            linked.insert(5)
            linked.show()
            linked.show(obj.removeNthFromEnd(linked.head, 3))
        }
    }
}
