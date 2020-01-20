package week2

import java.math.BigInteger.TEN
import java.util.*

// Week 2 - 8
class FibonacciSumSquares {

    private val pisano = Array<Long>(60) { 0 } // mod 10

    init {
        pisano[0] = 0
        pisano[1] = 1
        for (i in 2 until pisano.size) {
            pisano[i] = pisano[i - 1] + pisano[i - 2]
        }
    }

    private fun getPisanoFib(n: Long): Long {
        if (n <= 1) return n
        val index = n % pisano.size
        return pisano[index.toInt()]
    }

    fun getFibonacciSumSquares(n: Long): Long {
        val v = getPisanoFib(n).toBigInteger()
        val h = getPisanoFib(n + 1).toBigInteger()
        return (v * h).mod(TEN).toLong()
    }

}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val inst = FibonacciSumSquares()
    println(inst.getFibonacciSumSquares(n))
}