package week3

import java.util.*

fun computeMinRefills(dist: Int, tank: Int, stops: IntArray): Int {
    val n = stops.size
    val points = getPoints(stops, dist)
    var numRefills = 0
    var currentRefill = 0
    while (currentRefill <= n) {
        val lastRefill = currentRefill
        while (currentRefill <= n &&
            (points[currentRefill + 1] - points[lastRefill] <= tank)) {
            currentRefill++
        }

        if (currentRefill == lastRefill)
            return -1

        if (currentRefill <= n)
            numRefills++

    }

    return numRefills
}

private fun getPoints(stops: IntArray, dist: Int): Array<Int> {
    val points = Array(stops.size + 2) { 0 }
    points[0] = 0
    points[points.size - 1] = dist
    stops.forEachIndexed { index, i ->
        points[index + 1] = i
    }
    return points
}

fun main() {
    val scanner = Scanner(System.`in`)
    val dist = scanner.nextInt()
    val tank = scanner.nextInt()
    val n = scanner.nextInt()
    val stops = IntArray(n)
    for (i in 0 until n) {
        stops[i] = scanner.nextInt()
    }

    println(computeMinRefills(dist, tank, stops))
}