package week3

import java.util.*

fun optimalSummands(n: Int): List<Int> {
    val summands = mutableListOf(1)
    var remaining = n - 1
    while (remaining > 0) {
        val last = summands.last()
        if (remaining <= last) {
            for (i in summands.size - 1 downTo 0) {
                summands[i] = summands[i] + 1
                if (--remaining == 0)
                    break
            }
            break
        }
        summands.add(last + 1)
        remaining -= last + 1
    }

    return summands
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val summands = optimalSummands(n)
    println(summands.size)
    for (summand in summands) {
        print("$summand ")
    }
}