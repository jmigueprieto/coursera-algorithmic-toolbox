package week5

import java.util.*

class EditDistance {

    fun distance(a: String, b: String): Int {
        val n = a.length
        val m = b.length
        val d = initMatrix(n, m)

        for (j in 1..m) {
            for (i in 1..n) {
                val insertion = d[i][j - 1] + 1
                val deletion = d[i - 1][j] + 1
                val mismatch = d[i - 1][j - 1] + 1
                val match = d[i - 1][j - 1]
                if (a[i - 1] == b[j - 1]) {
                    d[i][j] = minOf(insertion, deletion, match)
                } else {
                    d[i][j] = minOf(insertion, deletion, mismatch)
                }
            }
        }
        return d[n][m]
    }

    private fun initMatrix(n: Int, m: Int): Array<Array<Int>> {
        val matrix = Array(n + 1) {
            Array(m + 1) { 0 }
        }

        (0..n).forEach { i ->
            matrix[i][0] = i
        }

        (0..m).forEach { i ->
            matrix[0][i] = i
        }

        return matrix
    }
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.next()
    val t = scan.next()

    println(EditDistance().distance(s, t))
}