package greedy.compl_900

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map {it.toLong()}.sorted()
    val m = readln().toInt()
    val q = readln().split(" ").map {it.toInt()}
    val sum = a.sum()

    q.forEach {
        println(sum - a[n - it ])
    }
}