package top_interview_150.matrix.medium

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size; val n = matrix[0].size
        var r0 = false; var c0 = false
        for (i in 0..m - 1) {
            for (j in 0..n - 1) {
                if (matrix[i][j] == 0) {
                    if (i == 0) r0 = true
                    if (j == 0) c0 = true
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }
        for (i in 1..m - 1) {
            for (j in 1..n - 1) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
        if (r0) {
            for (i in 0..n - 1)
                matrix[0][i] = 0
        }
        if (c0) {
            for (i in 0..m - 1)
                matrix[i][0] = 0
        }
    }
}