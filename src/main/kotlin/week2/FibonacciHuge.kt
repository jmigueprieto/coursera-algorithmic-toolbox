package week2

import java.math.BigInteger
import java.util.*
import java.math.BigInteger.ZERO
import java.math.BigInteger.ONE

// Week 2 - 5
class FibonacciHuge {

    private data class Element(val fib: BigInteger, val m: Long)

    fun getFibonacciHuge(n: Long, m: Long): Long {
        if (n <= 1) return n
        val list = pisanoPeriod(n, m)
        val index = n % list.size
        return list[index.toInt()].m
    }

    private fun pisanoPeriod(n: Long, m: Long): List<Element> {
        val list = mutableListOf<Element>()
        list.add(Element(ZERO, 0))
        list.add(Element(ONE, 1))
        val mod = m.toBigInteger()
        for (i in 2..n) {
            val index = i.toInt()
            val fib = list[index - 1].fib + list[index - 2].fib
            val r = fib.mod(mod).toLong()
            if (r == 1L && list[index - 1].m == 0L) {
                // Remove last 0, 1.
                list.removeAt(index - 1)
                break
            }
            list.add(Element(fib, r))
        }
        return list
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextLong()
    val inst = FibonacciHuge()
    println(inst.getFibonacciHuge(n, m))
}