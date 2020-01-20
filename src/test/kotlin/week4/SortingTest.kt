package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SortingTest {

    @Test
    fun `test 1`() {
        val array = intArrayOf(45, 79, 1, 25, 3, 19, 22, 7, 2, 10)
        Sorting().improvedRandomizedQuickSort(array, 0, array.size - 1)
        println(array.contentToString())
        assertThat(array).isEqualTo(intArrayOf(1, 2, 3, 7, 10, 19, 22, 25, 45, 79))
    }

    @Test
    fun `test 2`() {
        val array = intArrayOf(22, 22, 22, 22, 22, 22, 22, 22, 22, 22)
        Sorting().improvedRandomizedQuickSort(array, 0, array.size - 1)
        println(array.contentToString())
        assertThat(array).isEqualTo(intArrayOf(22, 22, 22, 22, 22, 22, 22, 22, 22, 22))
    }

    @Test
    fun `test 3`() {
        val array = intArrayOf(2, 2, 2, 2, 2, 1, 3, 4, 2, 5)
        Sorting().improvedRandomizedQuickSort(array, 0, array.size - 1)
        println(array.contentToString())
        assertThat(array).isEqualTo(intArrayOf(1, 2, 2, 2, 2, 2, 2, 3, 4, 5))
    }
}