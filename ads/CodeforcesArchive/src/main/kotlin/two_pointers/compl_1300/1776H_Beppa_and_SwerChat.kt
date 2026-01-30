package two_pointers.compl_1300
// в разборе нет кода и само решение написано слишком сложно, пропущу эту задачу
fun main(){
    val T = readln().toInt()

    repeat(T){
        val n = readln().toInt()
        val indices9AM = IntArray(n + 1)
        val a = readln().split(" ").map{it.toInt()}
        val b = readln().split(" ").map{it.toInt()}
        var shiftedIDsAmount = 0
        a.forEachIndexed { index, id ->
            indices9AM[id] = index
        }
        b.forEachIndexed { index, id ->
            //println("$index  $id  ${indices9AM[id]}")
            if (indices9AM[id] > index){
                ++shiftedIDsAmount
            }
        }
        println(shiftedIDsAmount)
    }
}