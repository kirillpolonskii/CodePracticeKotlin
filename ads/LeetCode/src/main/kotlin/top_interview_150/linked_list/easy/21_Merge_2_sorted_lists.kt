package top_interview_150.linked_list.easy



class ListNode(var `val`: Int) {
    var next: ListNode? = null
 }
class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null){
            return list2
        }
        else if (list2 == null){
            return list1
        }
        else {
            var curList1 = list1
            var curList2 = list2
            var curRes: ListNode = if (list1.`val` < list2.`val`){
                curList1 = curList1.next
                list1
            }
            else{
                curList2 = curList2.next
                list2
            }
            val resHead = curRes
            // curList1 и curList2 -- потенц. кандидаты на curRes.next
            while (curList1 != null && curList2 != null) {
                if (curList1.`val` < curList2.`val`){
                    curRes.next = curList1
                    curList1 = curList1.next
                }
                else{
                    curRes.next = curList2
                    curList2 = curList2.next
                }
                curRes = curRes.next!!
            }
            if (curList1 == null){
                curRes.next = curList2
            }
            else if (curList2 == null){
                curRes.next = curList1
            }
            return resHead
        }

    }
}