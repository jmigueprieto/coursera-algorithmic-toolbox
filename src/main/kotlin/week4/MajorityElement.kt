package week4

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class MajorityElement {
    companion object
}

fun MajorityElement.Companion.getMajorityElement(a: IntArray, n: Int): Boolean {
    a.sort()
    var current = a.first()
    var count = 1
    for (i in 1 until a.size) {
        if (a[i] == current) {
            count++
            if (count > n / 2)
                return true
        } else {
            current = a[i]
            count = 1
        }
    }

    return false
}

fun main() {
    class FastScanner(stream: InputStream) {
        var br: BufferedReader = BufferedReader(InputStreamReader(stream))
        var st: StringTokenizer? = null

        fun next(): String {
            while (st == null || !st!!.hasMoreTokens()) {
                try {
                    st = StringTokenizer(br.readLine())
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return st!!.nextToken()
        }

        fun nextInt() = next().toInt()
    }

    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    if (MajorityElement.getMajorityElement(a, n)) {
        println(1)
    } else {
        println(0)
    }
}
