package dp.compl_900

fun main(){
    val t = readln().toInt()
    val impStates = listOf(listOf(1, 1, 1),
        listOf(1, 0, 0),
        listOf(0, 1, 0),
        listOf(0, 0, 1))

    repeat(t){
        val p = readln().split(" ").map { it.toInt() }.toMutableList()
        var isImp = p.sum() % 2 == 1
        println(if (isImp) -1 else (p[0] + p[1] + p[2] - kotlin.math.max(0, p[2] - p[0] - p[1])) / 2)
    }
}