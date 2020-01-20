import java.util.*

fun maxDotProduct(a: IntArray, b: IntArray): Long {
    var result: Long = 0
    a.sortDescending()
    b.sortDescending()
    for (i in a.indices) {
        result += a[i].toLong() * b[i].toLong()
    }
    return result
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val b = IntArray(n)
    for (i in 0 until n) {
        b[i] = scanner.nextInt()
    }
    println(maxDotProduct(a, b))
}