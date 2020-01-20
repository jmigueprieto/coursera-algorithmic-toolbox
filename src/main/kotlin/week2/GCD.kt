package week2

import java.util.*

// Week 2 - 3
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

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(gcd(a, b))
}