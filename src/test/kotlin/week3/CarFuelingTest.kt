package week3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CarFuelingTest {

    @Test
    fun `sample 1`() {
        val refills = computeMinRefills(
            950,
            400,
            intArrayOf(200, 375, 550, 750)
        )
        assertThat(refills).isEqualTo(2)
    }

    @Test
    fun `sample 2`() {
        val refills = computeMinRefills(
            10,
            3,
            intArrayOf(1, 2, 5, 9)
        )
        assertThat(refills).isEqualTo(-1)
    }

    @Test
    fun `sample 3`() {
        val refills = computeMinRefills(
            200,
            250,
            intArrayOf(100, 150)
        )
        assertThat(refills).isEqualTo(0)
    }
}