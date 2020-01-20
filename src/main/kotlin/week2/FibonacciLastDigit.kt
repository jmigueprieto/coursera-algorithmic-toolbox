package week2

import java.util.*

// Week 2 - 2
class FibonacciLastDigit {
    companion object
}

fun FibonacciLastDigit.Companion.getFibonacciLastDigit(n: Int): Int {
    if (n <= 1)
        return n

    var previous = 0
    var current = 1

    for (i in 1 until n) {
        val tmpPrevious = previous
        previous = current
        current = (current + tmpPrevious) % 10
    }

    return current
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    println(FibonacciLastDigit.getFibonacciLastDigit(n))
}
