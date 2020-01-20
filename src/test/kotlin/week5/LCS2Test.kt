package week5

import org.assertj.core.api.Assertions.*
import org.junit.Test

class LCS2Test {

    @Test
    fun `sample 1`() {
        val a = intArrayOf(2, 7, 5)
        val b = intArrayOf(2, 5)
        val lcs = LCS2().compute(a, b)
        assertThat(lcs).isEqualTo(2)
    }

    @Test
    fun `sample 2`() {
        val a = intArrayOf(7)
        val b = intArrayOf(4)
        val lcs = LCS2().compute(a, b)
        assertThat(lcs).isEqualTo(0)
    }

    @Test
    fun `sample 3`() {
        val a = intArrayOf(2, 7, 8, 3)
        val b = intArrayOf(5, 2, 8, 7)
        val lcs = LCS2().compute(a, b)
        assertThat(lcs).isEqualTo(2)
    }

    @Test
    fun `sample 4`() {
        val a = intArrayOf(2, 3, 1, 2, 3)
        val b = intArrayOf(1, 2, 3)
        val lcs = LCS2().compute(a, b)
        assertThat(lcs).isEqualTo(3)
    }

    @Test
    fun `sample 5`() {
        val a = intArrayOf(2, 2, 2, 3)
        val b = intArrayOf(2, 3)
        val lcs = LCS2().compute(a, b)
        assertThat(lcs).isEqualTo(2)
    }
}
