package neetcode.ListNodeFolder.Kotlin

class ListNode {
    var `val`: Int = 0
    var next: ListNode? = null
    var head: ListNode? = null

    constructor()
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}
