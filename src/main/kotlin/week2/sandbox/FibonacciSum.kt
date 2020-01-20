package week2.sandbox

import java.math.BigInteger

class FibonacciSum {

    private val f = mutableMapOf<Long, BigInteger>()

    //log n method to get a week2.Fibonacci number
    private fun fib(n: Long): BigInteger {
        if (n <= 0L) {
            return BigInteger.ZERO
        }

        if (n == 1L || n == 2L) {
            f[n] = BigInteger.ONE
            return f[n]!!
        }

        if (f.containsKey(n)) {
            return f[n]!!
        }

        val isEven = n % 2 == 0L

        val k = if (isEven) {
            n / 2
        } else {
            (n + 1) / 2
        }

        f[n] = if (isEven) {
            (2.toBigInteger() * fib(k - 1) + fib(k)) * fib(k)
        } else {
            fib(k) * fib(k) + fib(k - 1) * fib(k - 1)
        }

        return f[n]!!
    }

    fun getSum(n: Long): BigInteger {
        return fib(n + 2).minus(BigInteger.ONE)
    }
}