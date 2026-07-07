package greedy.compl_900

fun main(){
    val n = readln().toInt()
    val field = Array(n){BooleanArray(n){false}}
    var i = 0
    var j = 0
    var emptyCnt = 0
    while(i < n){
        val curStr = readln()
        j = 0
        while(j < n){
            if (curStr[j] == '#') field[i][j] = true
            else ++emptyCnt
            ++j
        }
        ++i
    }
    if (emptyCnt % 5 == 0){
        var filledCnt = 0
        var possible = true
        for (i in 0..<n-2){
            for (j in 1..<n-1){
                if (!field[i][j]){
                    if (!field[i+1][j-1] && !field[i+1][j] && !field[i+1][j+1] && !field[i+2][j]){
                        field[i][j] = true
                        field[i+1][j-1] = true
                        field[i+1][j] = true
                        field[i+1][j+1] = true
                        field[i+2][j] = true
                        filledCnt += 5
                    }
                    else possible = false
                }
                if (!possible) break
            }
            if (!possible) break
        }
        println(if (emptyCnt == filledCnt) "YES" else "NO")
    }
    else {
        println("NO")
    }
}