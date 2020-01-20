package week5

import org.assertj.core.api.Assertions.*
import org.junit.Test

class EditDistanceTest {

    @Test
    fun `sample 1`() {
        val a = "ab"
        val b = "ab"
        val distance = EditDistance().distance(a, b)
        assertThat(distance).isEqualTo(0)
    }

    @Test
    fun `sample 2`() {
        val a = "short"
        val b = "ports"
        val distance = EditDistance().distance(a, b)
        assertThat(distance).isEqualTo(3)
    }


    @Test
    fun `sample 3`() {
        val a = "editing"
        val b = "distance"
        val distance = EditDistance().distance(a, b)
        assertThat(distance).isEqualTo(5)
    }

}