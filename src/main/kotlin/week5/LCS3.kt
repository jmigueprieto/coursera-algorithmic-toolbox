package week5

import java.util.*
import kotlin.math.min

class LCS3 {
    fun compute(a: IntArray, b: IntArray, c: IntArray): Int {
        val n = a.size
        val m = b.size
        val o = c.size
        val d = initMatrix(n, m, o)

        for (j in 1..m) {
            for (i in 1..n) {
                for (k in 1..o) {
                    if (a[i - 1] == b[j - 1] && a[i - 1] == c[k - 1]) {
                        d[i][j][k] = d[i - 1][j - 1][k - 1] + 1
                    } else {
                        d[i][j][k] = maxOf(
                            d[i - 1][j][k],
                            d[i][j - 1][k],
                            d[i][j][k - 1]
                        )
                    }
                }
            }
        }
        return d[n][m][o]
    }

    private fun initMatrix(n: Int, m: Int, o: Int): Array<Array<Array<Int>>> {
        return Array(n + 1) {
            Array(m + 1) {
                Array(o + 1) {
                    0
                }
            }
        }
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val an = scanner.nextInt()
    val a = IntArray(an)
    for (i in 0 until an) {
        a[i] = scanner.nextInt()
    }
    val bn = scanner.nextInt()
    val b = IntArray(bn)
    for (i in 0 until bn) {
        b[i] = scanner.nextInt()
    }
    val cn = scanner.nextInt()
    val c = IntArray(cn)
    for (i in 0 until cn) {
        c[i] = scanner.nextInt()
    }
    println(LCS3().compute(a, b, c))
}