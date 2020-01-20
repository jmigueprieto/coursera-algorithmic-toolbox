package week3

import maxDotProduct
import org.junit.Test

import org.assertj.core.api.Assertions.*

class DotProductTest {

    @Test
    fun `sample 1`() {
        val p = maxDotProduct(intArrayOf(23), intArrayOf(39))
        assertThat(p).isEqualTo(897)
    }

    @Test
    fun `sample 2`() {
        val p = maxDotProduct(intArrayOf(1, 3, -5), intArrayOf(-2, 4, 1))
        assertThat(p).isEqualTo(23)
    }

    //+-10^5 == +-100_000
    @Test
    fun overflow() {
        val p = maxDotProduct(intArrayOf(100_000), intArrayOf(100_000))
        assertThat(p).isEqualTo(10_000_000_000)
    }
}
