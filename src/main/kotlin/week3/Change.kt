import java.util.*

fun getChange(m: Int): Int {
    val tens: Int = m / 10
    val digit = m - (tens * 10)
    return tens + (if (digit >= 5) 1 + (digit - 5) else digit)
}

fun main() {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(getChange(m))
}