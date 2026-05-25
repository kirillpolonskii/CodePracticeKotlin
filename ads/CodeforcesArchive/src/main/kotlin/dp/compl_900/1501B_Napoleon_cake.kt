package dp.compl_900

fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toMutableList()
        val ans = BooleanArray(n)
        var locMin = (n - 1) - a[n - 1]
        ans[n - 1] = locMin < (n - 1)
        for (i in n-2 downTo 0){
            locMin = kotlin.math.min(locMin, i - a[i])
            ans[i] = locMin < i
        }
        ans.forEach {
            print(if (it) 1 else 0)
            print(" ")
        }
        println()
    }
}