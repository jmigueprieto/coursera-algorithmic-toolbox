package week3

import org.junit.Test

import org.assertj.core.api.Assertions.*

class DifferentSummandTest {

    @Test
    fun `sample 1`() {
        val summands = optimalSummands(6)
        assertThat(summands.size).isEqualTo(3)
        assertThat(summands.sum()).isEqualTo(6)
    }

    @Test
    fun `sample 2`() {
        val summands = optimalSummands(8)
        assertThat(summands.size).isEqualTo(3)
        assertThat(summands.sum()).isEqualTo(8)
    }

    @Test
    fun `sample 3`() {
        val summands = optimalSummands(2)
        assertThat(summands.size).isEqualTo(1)
        assertThat(summands.sum()).isEqualTo(2)
    }

}