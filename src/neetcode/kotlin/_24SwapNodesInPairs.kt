package neetcode.kotlin

import neetcode.ListNodeFolder.Java.LinkedList
import neetcode.ListNodeFolder.Java.ListNode

class _24SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode {
        val temp = ListNode(0, head)
        var curr = head
        var prev = temp

        while (curr?.next != null) {
            val seconPair = curr.next
            val nextPair = seconPair.next

            seconPair.next = curr
            curr.next = nextPair
            prev.next = seconPair

            prev = curr
            curr = nextPair
        }
        return temp.next
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = _24SwapNodesInPairs()

            val list = LinkedList()
            list.insert(1)
            list.insert(2)
            list.insert(3)
            list.insert(4)

            list.show()
            list.show(obj.swapPairs(list.head))
        }
    }
}
