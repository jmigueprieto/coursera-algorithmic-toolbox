package week3

import java.lang.StringBuilder
import java.util.*
import kotlin.Comparator

fun largestNumber(input: MutableList<String>): String {
    val num = StringBuilder()
    input.sortWith(Comparator { s1, s2 ->
        if (s1.length == s2.length) {
            s1.compareTo(s2)
        } else {
            "$s1$s2".compareTo("$s2$s1")
        }
    })

    input.reversed().forEach { num.append(it) }

    return num.toString()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = ArrayList<String>(n)
    repeat(n) {
        a += scanner.next()
    }
    println(largestNumber(a))
}