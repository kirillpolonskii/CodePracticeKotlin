package top_interview_150.linked_list.meduim

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || head.next == null) return null
        if (head.next!!.next == null){
            if (n == 1) {
                head.next = null
                return head
            }
            else {
                return head.next
            }
        }
        var elemBeforeDeleted = head
        var elemOnDelete = head
        var pointerN = head.next
        var ptrCounter = 1
        while(pointerN!!.next != null){
            if (ptrCounter < n){
                pointerN = pointerN.next
                ++ptrCounter
            }
            else {
                elemBeforeDeleted = elemBeforeDeleted!!.next
                elemOnDelete = elemOnDelete!!.next
                pointerN = pointerN.next
                ++ptrCounter
            }
        }
        // 2 edge cases: deleted is last or second to last
        if (n == 1){ // delete last
            elemBeforeDeleted!!.next = null
        }
        // 2 edge cases: deleted is second or first
        else if (ptrCounter == n){ // delete second
            head.next = head.next!!.next
        }
        else if (elemBeforeDeleted == head) { // delete head
            return head.next
        }
        else {
            elemBeforeDeleted!!.next = elemBeforeDeleted.next!!.next
        }
        return head
    }
}