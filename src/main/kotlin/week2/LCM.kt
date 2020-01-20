package week2

import java.util.*

// Week 2 - 4
fun lcm(a: Int, b: Int): Long {
    fun gcd(a: Int, b: Int): Int {
        var aa = a
        var bb = b
        while (true) {
            val remainder = aa % bb
            if (remainder == 0) {
                break
            }
            aa = bb
            bb = remainder
        }
        return bb
    }
    return if (b > 0) (a.toLong() * b) / gcd(a, b) else 0
}

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    println(lcm(a, b))
}