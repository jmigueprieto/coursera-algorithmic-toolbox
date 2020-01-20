package week2

import java.util.*

// Week 2 - 7
class FibonacciPartialSum {

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

    fun getFibonacciPartialSum(from: Long, to: Long): Long {
        val fib0 = getPisanoFib(from + 1)
        val fib1 = getPisanoFib(to + 2)

        return if (fib1 > fib0 || ((fib0 - fib1) % 10 == 0L)) {
            (fib1 - fib0) % 10
        } else {
            (fib1 - fib0) % 10 + 10
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val from = scanner.nextLong()
    val to = scanner.nextLong()
    val inst = FibonacciPartialSum()
    println(inst.getFibonacciPartialSum(from, to))
}
