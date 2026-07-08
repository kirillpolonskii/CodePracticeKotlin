package greedy.compl_1000
import java.util.TreeSet
fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val a = readln().split(" ").map {it.toLong()}
        val b = readln().split(" ").map {it.toLong()}
        val remainingB = TreeSet<Long>()
        b.forEach { remainingB.add(it) }
        val c = LongArray(n)
        var isPossible = true
        for (i in 0..<n){
            val smallest = remainingB.ceiling(a[i])
            if (smallest == null){
                isPossible = false
                break
            }
            c[i] = smallest
            remainingB.remove(smallest)
        }
        if (!isPossible){
            println(-1)
        }
        else{
            var ans = 0
            for (i in 0..<n){
                for (j in i+1..<n){
                    if (c[i] > c[j]){
                        ++ans
                    }
                }
            }
            println(ans)
        }
    }
}