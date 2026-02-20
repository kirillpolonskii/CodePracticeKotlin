package top_interview_150.array_string.medium

class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0

        val dp = IntArray(prices.size)
        for (i in 1..<prices.size){
            println(dp.joinToString())
            dp[i] = dp[i - 1] + kotlin.math.max(0, prices[i] - prices[i - 1])
        }

        return dp[prices.size - 1]
    }
}

fun main(){
    println(Solution122().maxProfit(intArrayOf(7,1,5,3,9,4)))
}