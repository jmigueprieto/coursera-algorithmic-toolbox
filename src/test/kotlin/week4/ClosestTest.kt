package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import week4.ClosestPair.Point
import kotlin.math.sqrt

class ClosestTest {

    @Test
    fun `sample 1`() {
        val points = arrayOf(Point(0, 0), Point(3, 4))
        val inst = ClosestPair(points)
        assertThat(inst.calculateClosest()).isEqualTo(5.0)
    }

    @Test
    fun `sample 2`() {
        val points = arrayOf(Point(7, 7), Point(1, 100), Point(4, 8), Point(7, 7))
        val inst = ClosestPair(points)
        assertThat(inst.calculateClosest()).isEqualTo(0.0)
    }

    @Test
    fun `sample 3`() {
        val points = arrayOf(
            Point(4, 4),
            Point(-2, -2),
            Point(-3, -4),
            Point(-1, 3),
            Point(2, 3),
            Point(-4, 0),
            Point(1, 1),
            Point(-1, -1),
            Point(3, -1),
            Point(-4, 2),
            Point(-2, 4)
        )
        val inst = ClosestPair(points)
        assertThat(inst.calculateClosest()).isEqualTo(sqrt(2.0))
    }
}