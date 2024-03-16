package neetcode.ListNodeFolder.Kotlin

class LinkedList {
    var head: ListNode? = null
    fun insert(`val`: Int): ListNode? {
        val newNode = ListNode()
        newNode.`val` = `val`
        if (head == null) {
            head = newNode
        } else {
            var n = head
            while (n!!.next != null) n = n.next
            n.next = newNode
        }
        return head
    }

    fun insert(Head: ListNode?, `val`: Int): ListNode? {
        var Head = Head
        val newNode = ListNode()
        newNode.`val` = `val`
        if (Head == null) {
            Head = newNode
        } else {
            var n = head
            while (n!!.next != null) n = n.next
            n.next = newNode
        }
        return Head
    }

    fun show() {
        var n = head
        print("\n[")
        while (n!!.next != null) {
            print(n.`val`.toString() + " " + n + " ")
            n = n.next
        }
        println(n.`val`.toString() + " " + n + "]")

        n = head
        print("[")
        while (n!!.next != null) {
            print(n.`val`.toString() + " ")
            n = n.next
        }
        println(n.`val`.toString() + "]")
    }

    fun show(Head: ListNode?) {
        var n = Head
        /*System.out.print("\n[");
    while(n.next!=null){
      System.out.print(n.val+"="+n+" ");
      n=n.next;
    }
    System.out.println(n.val+"="+n+"]");
    */
        n = Head
        print("[")
        while (n!!.next != null) {
            print(n.`val`.toString() + " ")
            n = n.next
        }
        println(n.`val`.toString() + "]")
    }

    fun size(): Int {
        var n = head
        var size = 1
        while (n!!.next != null) {
            size++
            n = n.next
        }
        return size
    }

    fun size(Head: ListNode?): Int {
        var n = Head
        var size = 1
        while (n!!.next != null) {
            size++
            n = n.next
        }
        return size
    }

    fun RemoveNthNodeFromEnd(n: Int): ListNode? {
        var n2 = head
        var n1 = head
        var size = 1
        while (n1!!.next != null) {
            size++
            n1 = n1.next
        }
        val ff = size - n
        n1 = n2
        if (ff == 0) {
            return head!!.next
        }
        var ind = 1
        while (true) {
            n1 = n2
            n2 = n2!!.next
            if (ind == ff) {
                n1!!.next = n2!!.next
                return head
            }
            ind++
        }
    }

    fun RemoveNthNodeFromEnd(Head: ListNode, n: Int): ListNode? {
        var n2: ListNode? = Head
        var n1: ListNode? = Head
        var size = 1
        while (n1!!.next != null) {
            size++
            n1 = n1.next
        }
        val ff = size - n
        n1 = n2
        if (ff == 0) {
            return Head.next
        }
        var ind = 1
        while (true) {
            n1 = n2
            n2 = n2!!.next
            if (ind == ff) {
                n1!!.next = n2!!.next
                return Head
            }
            ind++
        }
    }
}
