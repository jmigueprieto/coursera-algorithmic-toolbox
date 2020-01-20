package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

class InversionsTest {

    @Test
    fun `sample 1`() {
        val array = intArrayOf(2, 3, 9, 2, 9)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        assertThat(inversions).isEqualTo(2)
        println(array.contentToString())
    }

    @Test
    fun `test 0`() {
        val array = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        assertThat(inversions).isEqualTo(0)
        println(array.contentToString())
    }

    @Test
    fun `test 1`() {
        val array = intArrayOf(3, 2)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        println(array.contentToString())
        assertThat(inversions).isEqualTo(1)
    }

    @Test
    fun `test 2`() {
        val array = intArrayOf(9, 8, 7, 3, 2, 1)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        println(Arrays.toString(array))
        assertThat(inversions).isEqualTo(15)
    }

    @Test
    fun `test 3`() {
        val array = intArrayOf(2, 2, 2, 1)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        assertThat(inversions).isEqualTo(3)
        println(array.contentToString())
    }

    @Test
    fun `test 4`() {
        val array = intArrayOf(2, 2, 2, 3, 1)
        val inversions = getNumberOfInversions(array, array, 0, array.size)
        assertThat(inversions).isEqualTo(4)
        println(array.contentToString())
    }
}