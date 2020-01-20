package week4

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class Sorting {

    private val random = Random()

    fun randomizedQuickSort(a: IntArray, l: Int, r: Int) {
        if (l >= r) {
            return
        }

        val k = random.nextInt(r - l + 1) + l
        val t = a[l]
        a[l] = a[k]
        a[k] = t

        val m = partition2(a, l, r)
        randomizedQuickSort(a, l, m - 1)
        randomizedQuickSort(a, m + 1, r)
    }

    fun improvedRandomizedQuickSort(a: IntArray, l: Int, r: Int) {
        if (l >= r) {
            return
        }

        val k = random.nextInt(r - l + 1) + l
        val t = a[l]
        a[l] = a[k]
        a[k] = t

        val (m, repetitions) = partition3(a, l, r)
        improvedRandomizedQuickSort(a, l, m - 1 - repetitions)
        improvedRandomizedQuickSort(a, m + 1, r)
    }

    private fun partition3(a: IntArray, l: Int, r: Int): Pair<Int, Int> {
        val x = a[l]
        var j = l

        for (i in l + 1..r) {
            if (a[i] < x) {
                j++
                val t = a[i]
                a[i] = a[j]
                a[j] = t
            }
        }
        val t = a[l]
        a[l] = a[j]
        a[j] = t

        var repetitions = 0
        for (i in l + 0..r) {
            if (i != j && a[i] == a[j]) {
                j++
                repetitions++
                a[i] = a[j]
                a[j] = x
            }
        }

        return Pair(j, repetitions)
    }

    private fun partition2(a: IntArray, l: Int, r: Int): Int {
        val x = a[l]
        var j = l
        for (i in l + 1..r) {
            if (a[i] <= x) {
                j++
                val t = a[i]
                a[i] = a[j]
                a[j] = t
            }
        }
        val t = a[l]
        a[l] = a[j]
        a[j] = t
        return j
    }

}

fun main() {
    class FastScanner(stream: InputStream) {
        private var br: BufferedReader = BufferedReader(InputStreamReader(stream))
        private var st: StringTokenizer? = null

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
    Sorting().improvedRandomizedQuickSort(a, 0, n - 1)
    for (i in 0 until n) {
        print(a[i].toString() + " ")
    }
}

