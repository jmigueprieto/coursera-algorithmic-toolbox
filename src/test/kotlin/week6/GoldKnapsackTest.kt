package week6

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GoldKnapsackTest {

    @Test
    fun `sample 1`() {
        val w = GoldKnapsack(10, intArrayOf(1, 4, 8)).value
        assertThat(w).isEqualTo(9)
    }

    @Test
    fun `sample 2`() {
        val w = GoldKnapsack(240, intArrayOf(60, 100, 120)).value
        assertThat(w).isEqualTo(220)
    }
}