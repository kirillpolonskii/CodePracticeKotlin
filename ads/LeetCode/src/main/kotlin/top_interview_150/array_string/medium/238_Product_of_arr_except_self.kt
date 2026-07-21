package top_interview_150.array_string.medium

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixProds = IntArray(nums.size)
        val suffixProds = IntArray(nums.size)
        prefixProds[0] = nums[0]
        suffixProds[nums.size - 1] = nums[nums.size - 1]
        for (i in 1..<nums.size-1){
            prefixProds[i] = prefixProds[i-1] * nums[i]
            suffixProds[nums.size - 1 - i] = suffixProds[nums.size - 1 - i + 1] * nums[nums.size - 1 - i]
        }
        prefixProds[nums.size - 1] = prefixProds[nums.size - 2] * nums[nums.size - 1]
        suffixProds[0] = suffixProds[1] * nums[0]
        val answer = IntArray(nums.size)
        answer[0] = suffixProds[1]
        answer[nums.size - 1] = prefixProds[nums.size - 2]
        for (i in 1..<nums.size-1){
            answer[i] = prefixProds[i - 1] * suffixProds[i + 1]
        }
        return answer
    }
    fun productExceptSelf1(nums: IntArray): IntArray {
        val end = nums.lastIndex
        val res = IntArray(nums.size) { 1 }
        var left = 1
        var right = 1
        for (i in nums.indices) {
            res[i] *= left
            res[end - i] *= right
            right *= nums[end - i]
            left *= nums[i]
        }

        return res
    }
}

fun main() {
    println(Solution238().productExceptSelf1(intArrayOf(1,2,3,4)).joinToString(" "))
}