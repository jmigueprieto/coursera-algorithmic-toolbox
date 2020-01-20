package week4

import java.util.*

class PointsAndSegments {

    data class Point(val x: Int, var segmentCount: Int = 0) : Comparable<Point> {
        override fun compareTo(other: Point): Int {
            return x.compareTo(other.x)
        }
    }

    fun fastCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
        val sortedPoints = points.distinct().sorted().map { Point(x = it) }

        starts.forEachIndexed { index, start ->
            val end = ends[index]
            val startPosition = position(start, sortedPoints) // where start is or where should it be
            val endPosition = position(end, sortedPoints) // where end is or where should it be

            for (i in startPosition..endPosition) {
                if (i < sortedPoints.size && sortedPoints[i].x in start..end) { // is this check really needed
                    sortedPoints[i].segmentCount++
                }
            }
        }

        return points.map {
            val index = sortedPoints.binarySearch(Point(it))
            sortedPoints[index].segmentCount
        }.toIntArray()

    }

    private fun position(point: Int, distinctSortedPoints: List<Point>): Int {
        val position = distinctSortedPoints.binarySearch(Point(point))
        return if (position < 0) {
            -(position + 1)
        } else {
            position
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n: Int
    val m: Int
    n = scanner.nextInt()
    m = scanner.nextInt()
    val starts = IntArray(n)
    val ends = IntArray(n)
    val points = IntArray(m)
    for (i in 0 until n) {
        starts[i] = scanner.nextInt()
        ends[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        points[i] = scanner.nextInt()
    }

    val cnt = PointsAndSegments().fastCountSegments(starts, ends, points)
    for (x in cnt) {
        print("$x ")
    }
}