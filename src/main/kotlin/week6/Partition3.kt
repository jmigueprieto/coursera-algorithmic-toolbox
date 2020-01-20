package week6

import java.util.*

class Partition3(private val items: IntArray) {

    private fun compute(): Int {
        if (items.size < 3) {
            return 0
        }

        val sum = items.sum()
        if (sum % 3 != 0) {
            return 0
        }
        val target = sum / 3

        val subset = sub(items.size - 1, target, target, target)
        return if (subset) 1 else 0
    }

    private fun sub(n: Int, sum0: Int, sum1: Int, sum2: Int): Boolean {
        if (sum0 == 0 && sum1 == 0 && sum2 == 0) {
            return true
        }

        if (n < 0) {
            return false
        }

        // item becomes part of first subset
        var a = false
        if (sum0 - items[n] >= 0) {
            a = sub(n - 1, sum0 - items[n], sum1, sum2)
        }

        // item becomes part of second subset
        var b = false
        if (!a && sum1 - items[n] >= 0) {
            b = sub(n - 1, sum0, sum1 - items[n], sum2)
        }

        // item becomes part of third subset
        var c = false
        if (!a && !b && sum2 - items[n] >= 0) {
            c = sub(n - 1, sum0, sum1, sum2 - items[n])
        }

        return a || b || c
    }

    //
    // Public members
    //
    val value = compute()

}

fun partition3(souvenirs: IntArray): Int {
    return Partition3(souvenirs).value
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }
    println(partition3(array))
}