package week3

import java.util.*

fun optimalPoints(segments: MutableList<Segment>): IntArray {
    val optimalPoints = mutableListOf<Int>()

    segments.sortBy { it.start }
    segments.forEach { segment ->
        if (!segment.marked) {
            segment.marked = true
            val intersection = segment.intersection(segments.unMarkedSegments())
            intersection.markAll()
            optimalPoints.add(intersection.commonPoint())
        }
    }

    return optimalPoints.toIntArray()
}

private fun List<Segment>.commonPoint() = maxBy { it.start }!!.start
private fun List<Segment>.unMarkedSegments() = filter { !it.marked }
private fun List<Segment>.markAll() = forEach { it.marked = true }

data class Segment(var start: Int, var end: Int, var marked: Boolean = false) {
    private fun intersects(other: Segment): Boolean {
        return ((other.start >= this.start && other.start <= this.end)
                || (other.end >= this.start && other.start <= this.start))
    }

    private fun intersectsAll(group: List<Segment>): Boolean {
        return group.all { it.intersects(this) }
    }

    fun intersection(segments: List<Segment>): List<Segment> {
        val group = mutableListOf(this)
        segments.forEach {
            if (it.intersectsAll(group)) {
                group.add(it)
            }
        }
        return group
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val segments = ArrayList<Segment>(n)
    repeat(n) {
        val start: Int = scanner.nextInt()
        val end: Int = scanner.nextInt()
        segments += Segment(start, end)
    }
    val points = optimalPoints(segments)
    println(points.size)
    for (point in points) {
        print("$point ")
    }
}