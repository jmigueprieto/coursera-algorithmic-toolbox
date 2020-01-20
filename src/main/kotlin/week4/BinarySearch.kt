package week4

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.math.floor

class BinarySearch {
    companion object {
        fun binarySearch(a: IntArray, x: Int): Int {
            var low = 0
            var high = a.size - 1

            while (high >= low) {
                var mid = floor((high - low).toDouble() / 2).toInt()
                val index = low + mid
                if (a[index] == x)
                    return index

                if (a[index] > x) {
                    high = index - 1
                } else {
                    low = index + 1
                }
            }

            return -1
        }
    }
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
    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        print(BinarySearch.binarySearch(a, b[i]).toString() + " ")
    }
}

