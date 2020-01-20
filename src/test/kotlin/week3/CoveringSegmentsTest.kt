package week3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CoveringSegmentsTest {

    @Test
    fun `sample 1`() {
        val optimalPoints = optimalPoints(
            mutableListOf(
                Segment(1, 3),
                Segment(2, 5),
                Segment(3, 6)
            )
        )
        assertThat(optimalPoints.size).isEqualTo(1)
        assertThat(optimalPoints[0]).isEqualTo(3)
    }

    @Test
    fun `sample 2`() {
        val optimalPoints = optimalPoints(
            mutableListOf(
                Segment(4, 7),
                Segment(1, 3),
                Segment(2, 5),
                Segment(5, 6)
            )
        )
        assertThat(optimalPoints.size).isEqualTo(2)
    }

    //  Unsorted - without ordering: [5, 6, 2]
    //  |    __    | #0
    //  |  ___     | #1
    //  |     __   | #2
    //  | __       | #3
    //
    // Sorted - ordering: [3, 6]
    //  | __       | #3
    //  |  ___     | #1
    //  |    __    | #0
    //  |     __   | #2
    @Test
    fun `failing test case 1`() {
        val points = mutableListOf(
            Segment(5, 6),
            Segment(3, 5),
            Segment(6, 7),
            Segment(2, 3)
        )

        val optimalPoints = optimalPoints(points)
        println(optimalPoints.contentToString())
        assertThat(optimalPoints.size).isEqualTo(2)
    }
}