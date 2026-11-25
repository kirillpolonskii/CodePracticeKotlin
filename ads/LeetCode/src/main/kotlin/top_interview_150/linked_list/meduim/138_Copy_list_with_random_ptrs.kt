package top_interview_150.linked_list.meduim

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
class Solution138 {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        if (node.next == null) {
            val newHead = Node(node.`val`)
            if (node.random != null) newHead.random = newHead
            return newHead
        }
        val origToNewElems = mutableMapOf<Node, Node>()
        // first copy the list without random
        var curOrigEl = node
        var nextOrigEl = curOrigEl.next
        val newHead: Node? = Node(node.`val`)
        var curNewEl = newHead
        //origToNewElems.put(curOrigEl, curNewEl)
        var nextNewEl: Node?
        while(curOrigEl != null) {
            if (curOrigEl.next != null){
                nextNewEl = Node(curOrigEl.next!!.`val`)
                curNewEl!!.next = nextNewEl
                origToNewElems[curOrigEl] = curNewEl
                curOrigEl = curOrigEl.next
                curNewEl = curNewEl.next
            }
            else{
                origToNewElems[curOrigEl] = curNewEl!!
                curOrigEl = curOrigEl.next
                curNewEl = curNewEl.next
            }

        }
        // traverse origList, go to random and via map fill it in newList
        var randOrigEl: Node
        //var randNewEl: Node
        curOrigEl = node
        curNewEl = newHead
        while (curOrigEl != null){
            if (curOrigEl.random != null){
                randOrigEl = curOrigEl.random!!
                curNewEl!!.random = origToNewElems[randOrigEl]
                curOrigEl = curOrigEl.next
                curNewEl = curNewEl.next
            }
            else {
                curOrigEl = curOrigEl.next
                curNewEl = curNewEl!!.next
            }
        }
        return newHead
    }
}
fun main(){
    //Solution138().copyRandomList()
}