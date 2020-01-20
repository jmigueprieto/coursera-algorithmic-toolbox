package week5

import org.assertj.core.api.Assertions.*
import org.junit.Test

class LCS3Test {

    @Test
    fun `sample 1`() {
        val a = intArrayOf(1, 2, 3)
        val b = intArrayOf(2, 1, 3)
        val c = intArrayOf(1, 3, 5)
        val lcs = LCS3().compute(a, b, c)
        assertThat(lcs).isEqualTo(2)
    }

    @Test
    fun `sample 2`() {
        val a = intArrayOf(8, 3, 2, 1, 7)
        val b = intArrayOf(8, 2, 1, 3, 8, 10, 7)
        val c = intArrayOf(6, 8, 3, 1, 4, 7)
        val lcs = LCS3().compute(a, b, c)
        assertThat(lcs).isEqualTo(3)
    }

    @Test
    fun `sample 3`() {
        val a = intArrayOf(1, 4, 8)
        val b = intArrayOf(2, 5, 8)
        val c = intArrayOf(3, 6, 8)
        val lcs = LCS3().compute(a, b, c)
        assertThat(lcs).isEqualTo(1)
    }

    @Test
    fun `sample 4`() {
        val a = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        val b = intArrayOf(1, 8)
        val c = intArrayOf(1, 8, 3)
        val lcs = LCS3().compute(a, b, c)
        assertThat(lcs).isEqualTo(2)
    }

    @Test
    fun `sample 5`() {
        val a = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val b = intArrayOf(0, 2, 3, 4, 5, 6)
        val c = intArrayOf(0, 2, 3, 4, 5, 6, 7, 8)
        val lcs = LCS3().compute(a, b, c)
        assertThat(lcs).isEqualTo(5)
    }

}