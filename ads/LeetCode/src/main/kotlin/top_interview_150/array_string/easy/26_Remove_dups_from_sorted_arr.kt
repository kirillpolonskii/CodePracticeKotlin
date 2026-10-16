package top_interview_150.array_string.easy

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        var originalElInd = 0
        var ansElInd = 0
        var ansNewPos = 0
        while (originalElInd < nums.size) {
            if (nums[originalElInd] == nums[ansElInd]){
                if (originalElInd == nums.size - 1){
                    nums[ansNewPos] = nums[originalElInd]
                    ++k
                }
                ++originalElInd
            }
            else {
                nums[ansNewPos] = nums[ansElInd]
                ++ansNewPos
                ++k
                ansElInd = originalElInd
            }
            //println("$originalElInd $ansElInd $ansNewPos")
            //println(nums.joinToString(" "))
        }
        return k
    }
}

fun main(){
    print(Solution26().removeDuplicates(intArrayOf(1)))
}