package week2

import java.util.*

// Week 2 - 6
class FibonacciSumLastDigit {

    private val pisano = Array<Long>(60) { 0 } // mod 10

    init {
        pisano[0] = 0
        pisano[1] = 1
        for (i in 2 until pisano.size) {
            pisano[i] = pisano[i - 1] + pisano[i - 2]
        }
    }

    fun getLastDigit(n: Long): Long {
        if (n <= 1) return n
        val index = (n + 2) % pisano.size
        return (pisano[index.toInt()] - 1) % 10
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val inst = FibonacciSumLastDigit()
    println(inst.getLastDigit(n))
}
