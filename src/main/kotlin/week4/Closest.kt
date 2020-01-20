package week4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.sqrt

class ClosestPair(private val points: Array<Point>) {

    data class Point(internal val x: Double, internal val y: Double) : Comparable<Point> {

        constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

        fun distanceTo(that: Point): Double {
            val dx = this.x - that.x
            val dy = this.y - that.y
            return sqrt(dx * dx + dy * dy)
        }

        override fun compareTo(other: Point): Int {
            if (this.y < other.y) {
                return -1
            }
            return if (this.y > other.y) 1 else this.x.compareTo(other.x)
        }

        override fun toString(): String {
            return "($x, $y)"
        }
    }

    private var closest = Double.POSITIVE_INFINITY

    fun calculateClosest(): Double {
        val n = points.size
        if (n <= 1) return 0.0

        val pointsX = pointsX()
        for (i in 0 until n - 1) {
            if (pointsX[i] == pointsX[i + 1]) {
                return 0.0
            }
        }

        val aux = Array(n) {
            Point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
        }

        closest(pointsX, pointsX().copyOf(), aux, 0, n - 1)
        return closest
    }

    private fun pointsX(): Array<Point> {
        val pointsByX = mutableListOf<Point>()
        points.forEach { point ->
            pointsByX.add(point)
        }
        pointsByX.sortWith(Comparator { p0, p1 ->
            p0.x.compareTo(p1.x)
        })
        return pointsByX.toTypedArray()
    }

    private fun closest(
        pointsX: Array<Point>,
        pointsY: Array<Point>,
        aux: Array<Point>,
        lo: Int,
        hi: Int
    ): Double {
        if (hi <= lo) return Double.POSITIVE_INFINITY

        val mid = lo + (hi - lo) / 2
        val median = pointsX[mid]

        val delta1 = closest(pointsX, pointsY, aux, lo, mid)
        val delta2 = closest(pointsX, pointsY, aux, mid + 1, hi)
        var delta = min(delta1, delta2)

        merge(pointsY, aux, lo, mid, hi)

        var m = 0
        for (i in lo..hi) {
            if (abs(pointsY[i].x - median.x) < delta)
                aux[m++] = pointsY[i]
        }

        for (i in 0 until m) {
            var j = i + 1
            while (j < m && aux[j].y - aux[i].y < delta) {
                val distance = aux[i].distanceTo(aux[j])
                if (distance < delta) {
                    delta = distance
                    if (distance < closest) {
                        closest = delta
                    }
                }
                j++
            }
        }

        return delta
    }

    private fun merge(a: Array<Point>, aux: Array<Point>, lo: Int, mid: Int, hi: Int) {
        for (i in lo..hi) {
            aux[i] = a[i]
        }

        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            when {
                i > mid -> a[k] = aux[j++]
                j > hi -> a[k] = aux[i++]
                aux[j] < aux[i] -> a[k] = aux[j++]
                else -> a[k] = aux[i++]
            }
        }
    }
}

fun main() {

    var tok = StringTokenizer("")

    fun next(reader: BufferedReader): String? {
        while (!tok.hasMoreTokens()) {
            var w: String? = null
            try {
                w = reader.readLine()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (w == null)
                return null
            tok = StringTokenizer(w)
        }
        return tok.nextToken()
    }

    fun nextInt(reader: BufferedReader): Int {
        return next(reader)!!.toInt()
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = nextInt(reader)
    val x = IntArray(n)
    val y = IntArray(n)
    for (i in 0 until n) {
        x[i] = nextInt(reader)
        y[i] = nextInt(reader)
    }
    val points = Array(n) { i ->
        ClosestPair.Point(x[i].toDouble(), y[i].toDouble())
    }
    val inst = ClosestPair(points)
    println(inst.calculateClosest())
}