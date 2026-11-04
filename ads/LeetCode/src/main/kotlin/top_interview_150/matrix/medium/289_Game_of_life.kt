package top_interview_150.matrix.medium

class Solution289 {
    val neighbourDelta = arrayOf(
        intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
        intArrayOf(0, -1), intArrayOf(0, 1),
        intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
    )
    fun gameOfLife(board: Array<IntArray>): Unit {
        val m = board.size
        val n = board[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                var liveCount = 0
                for ((dx, dy) in neighbourDelta) {
                    val nI = i + dx
                    val nJ = j + dy
                    if(nI in 0 until m && nJ in 0 until n){
                        liveCount += if (board[nI][nJ] == 1 || board[nI][nJ] == 2) 1 else 0
                    }
                }
                if (board[i][j] == 1) {
                    if (liveCount < 2 || liveCount > 3) {
                        board[i][j] = 2 // will die
                    }
                } else if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = -1 // will live
                    }
                }
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (board[i][j] == 2) {
                    board[i][j] = 0
                } else if (board[i][j] == -1) {
                    board[i][j] = 1
                }
            }
        }
    }
}