package top_interview_150.array_string.hard

class Solution42 {
    fun trap(height: IntArray): Int {
        if (height.size < 3) return 0
        var globMax = height.max()
        val globMaxInd = height.indexOfFirst { it == globMax }
        // left half
        var waterLeftSum = 0
        var curMaxH = height[0]
        for (i in 1..<globMaxInd){
            if (height[i] > curMaxH) curMaxH = height[i]
            waterLeftSum += curMaxH - height[i]
        }
        // right half
        var waterRightSum = 0
        curMaxH = height[height.size - 1]
        for (i in height.size-1 downTo globMaxInd+1){
            if (height[i] > curMaxH) curMaxH = height[i]
            waterRightSum += curMaxH - height[i]
        }
        return waterLeftSum + waterRightSum
    }
}

fun main() {
    println(Solution42().trap(intArrayOf(4,2,0,3,2,5)))
}