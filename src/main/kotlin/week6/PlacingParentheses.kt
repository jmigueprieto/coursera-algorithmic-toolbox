package week6

import java.util.*
import kotlin.math.max
import kotlin.math.min


class PlacingParentheses(private val exp: String) {

    private val maxMatrix: Array<Array<Long>>

    private val minMatrix: Array<Array<Long>>

    private val n = (exp.length + 1) / 2

    init {
        maxMatrix = Array(n) { Array(n) { 0L } }
        minMatrix = Array(n) { Array(n) { 0L } }
        for (i in 0 until n) { // the diagonals
            maxMatrix[i][i] = digit(i)
            minMatrix[i][i] = digit(i)
        }
    }

    private fun minAndMax(i: Int, j: Int): Pair<Long, Long> {
        var min = Long.MAX_VALUE
        var max = Long.MIN_VALUE
        for (k in i until j) {
            val op = op(k)
            val a = eval(M(i, k), M(k + 1, j), op)
            val b = eval(M(i, k), m(k + 1, j), op)
            val c = eval(m(i, k), M(k + 1, j), op)
            val d = eval(m(i, k), m(k + 1, j), op)
            min = min(min, a, b, c, d)
            max = max(max, a, b, c, d)
        }

        return Pair(min, max)
    }

    private fun M(i: Int, k: Int) = maxMatrix[i][k]

    private fun m(i: Int, k: Int) = minMatrix[i][k]

    private fun op(k: Int) = exp[2 * k + 1]

    private fun digit(k: Int) = Character.getNumericValue(exp[2 * k]).toLong()

    private fun max(max: Long, a: Long, b: Long, c: Long, d: Long) = max(max, max(a, max(b, max(c, d))))

    private fun min(min: Long, a: Long, b: Long, c: Long, d: Long) = min(min, min(a, min(b, min(c, d))))

    private fun eval(a: Long, b: Long, op: Char): Long = when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> {
            assert(false)
            0
        }
    }

    fun getMaxValue(): Long {
        for (s in 1 until n) {
            for (i in 0 until n - s) {
                val j = i + s
                val (min, max) = minAndMax(i, j)
                minMatrix[i][j] = min
                maxMatrix[i][j] = max
            }
        }

        return maxMatrix[0][n - 1]
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val exp = scanner.next()
    println(PlacingParentheses(exp).getMaxValue())
}