package top_interview_150.array_string.medium

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        var h = 0
        for (i in citations.size-1 downTo 0){
            if (citations[i] > h) ++h
            else break
        }
        return h
    }
}

fun main(){
    println(Solution274().hIndex(intArrayOf(3,0,6,1,5)))
}