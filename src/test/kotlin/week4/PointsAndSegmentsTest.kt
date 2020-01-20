package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import week4.PointsAndSegments.Point

class PointsAndSegmentsTest {

    @Test
    fun `binarySearch test`() {
        val points = listOf(
            Point(1),
            Point(3),
            Point(7),
            Point(10),
            Point(22)
        )
        assertThat(points.binarySearch(Point(0))).isEqualTo(-1)
        assertThat(points.binarySearch(Point(1))).isEqualTo(0)
        assertThat(points.binarySearch(Point(2))).isEqualTo(-2)
        assertThat(points.binarySearch(Point(3))).isEqualTo(1)
        assertThat(points.binarySearch(Point(4))).isEqualTo(-3)
        assertThat(points.binarySearch(Point(7))).isEqualTo(2)
        assertThat(points.binarySearch(Point(23))).isEqualTo(-6)
    }

    @Test
    fun `sample 1`() {
        val starts = intArrayOf(0, 7)
        val ends = intArrayOf(5, 10)
        val points = intArrayOf(1, 6, 11)
        val result = PointsAndSegments().fastCountSegments(starts, ends, points)
        assertThat(result).isEqualTo(intArrayOf(1, 0, 0))
    }

    @Test
    fun `sample 2`() {
        val starts = intArrayOf(-10)
        val ends = intArrayOf(10)
        val points = intArrayOf(-100, 100, 0)
        val result = PointsAndSegments().fastCountSegments(starts, ends, points)
        assertThat(result).isEqualTo(intArrayOf(0, 0, 1))
    }

    @Test
    fun `sample 3`() {
        val starts = intArrayOf(3, 0, -3, 7)
        val ends = intArrayOf(2, 5, 2, 10)
        val points = intArrayOf(1, 6)
        val result = PointsAndSegments().fastCountSegments(starts, ends, points)
        assertThat(result).isEqualTo(intArrayOf(2, 0))
    }

}