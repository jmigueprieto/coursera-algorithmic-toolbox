package week3

import getOptimalValue
import org.junit.Test

import org.assertj.core.api.Assertions.*

class FractionalKnapsackTest {

    @Test
    fun `sample 1`() {
        val value = getOptimalValue(
            50,
            intArrayOf(60, 100, 120),
            intArrayOf(20, 50, 30)
        )
        assertThat(value).isEqualTo(180.0)
    }

    @Test
    fun `sample 2`() {
        val value = getOptimalValue(
            10,
            intArrayOf(500),
            intArrayOf(30)
        )
        assertThat(value).isEqualTo(166.6667)
    }

}