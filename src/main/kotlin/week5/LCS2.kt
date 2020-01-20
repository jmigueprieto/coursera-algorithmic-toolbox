package week5

import java.util.*
import kotlin.math.min

class LCS2 {
    fun compute(a: IntArray, b: IntArray): Int {
        val n = a.size
        val m = b.size
        val d = initMatrix(n, m)

        for (j in 1..m) {
            for (i in 1..n) {
                if (a[i - 1] == b[j - 1]) {
                    d[i][j] = d[i - 1][j - 1] + 1
                } else {
                    d[i][j] = maxOf(
                        d[i - 1][j],
                        d[i][j - 1]
                    )
                }
            }
        }
        return d[n][m]
    }

    private fun initMatrix(n: Int, m: Int): Array<Array<Int>> {
        return Array(n + 1) {
            Array(m + 1) { 0 }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }

    println(LCS2().compute(a, b))
}