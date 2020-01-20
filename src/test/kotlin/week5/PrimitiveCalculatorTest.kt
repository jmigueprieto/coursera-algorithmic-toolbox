package week5

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PrimitiveCalculatorTest {

    @Test
    fun `sample 1`() {
        val list = PrimitiveCalculator().optimalSequence(1)
        println(list)
        assertThat(list).isEqualTo(listOf(1))
    }

    @Test
    fun `sample 2`() {
        val list = PrimitiveCalculator().optimalSequence(5)
        println(list)
        assertThat(list.size).isEqualTo(4)
        //assertThat(list).isEqualTo(listOf(1, 2, 4, 5))
    }

    @Test
    fun `sample 3`() {
        val list = PrimitiveCalculator().optimalSequence(96234)
        println(list)
        assertThat(list.size).isEqualTo(15)
        assertThat(list[list.size - 1]).isEqualTo(96234)
        /* This is just one possible sequence
        assertThat(list).isEqualTo(
            listOf(
                1, 2, 6, 7, 21, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234
            )
        )*/
    }

    @Test
    fun `sample 4`() {
        val list = PrimitiveCalculator().optimalSequence(1000000)
        println(list)
    }

    @Test
    fun `sample 5`() {
        val list = PrimitiveCalculator().optimalSequence(999997)
        println(list)
    }

}