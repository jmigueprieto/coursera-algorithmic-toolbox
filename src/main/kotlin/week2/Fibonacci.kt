package week2

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO
import java.util.*

// Week 2 - 1
class Fibonacci {
    companion object
}

fun Fibonacci.Companion.calcFib(n: Long): Long {
    val fibs = mutableMapOf<Long, BigInteger>()

    fibs[0] = ZERO
    fibs[1] = ONE
    for (i in 2..n) {
        fibs[i] = fibs[i - 1]!! + fibs[i - 2]!!
    }
    return fibs[n]!!.toLong()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    println(Fibonacci.calcFib(n))
}