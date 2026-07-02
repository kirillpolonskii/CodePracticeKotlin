package greedy.compl_900

fun main(){
    val T = readln().toInt()

    repeat(T){
        val (n, k) = readln().split(" ").map {it.toInt()}
        val a = readln().split(" ").map {it.toInt()}
        val b = readln().split(" ").map {it.toInt()}.toMutableList()
        var m = 0
        val ops = mutableListOf<Int>()
        var curPriority = k
        while(curPriority > 0){
            for (i in 0..<n){
                if (b[i] == curPriority){
                    for (p in 0..<k+1-b[i]){
                        ops.add(i + 1)
                        ++m
                    }
                    if (m > 1000){
                        curPriority = 0
                        break
                    }
                    b[i] = k + 1
                }

            }
            --curPriority
        }
        if (m > 1000){
            println(-1)
        }
        else {
            println(m)
            println(ops.joinToString(" "))
        }
    }
}