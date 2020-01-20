package week6

import org.assertj.core.api.Assertions.*
import org.junit.Test

class Partition3Test {

    @Test
    fun `sample 1`() {
        val output = partition3(intArrayOf(3, 3, 3, 3))
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `sample 2`() {
        val output = partition3(intArrayOf(40))
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `sample 3`() {
        val output = partition3(intArrayOf(17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59))
        assertThat(output).isEqualTo(1)
    }

    @Test
    fun `sample 4`() {
        val array = intArrayOf(1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25)
        //println(array.contentToString())
        val output = partition3(array)

        assertThat(output).isEqualTo(1)
    }

    @Test
    fun `sample 5`() {
        val output = partition3(intArrayOf(3, 2, 2, 1, 1))
        assertThat(output).isEqualTo(1)
    }

    @Test
    fun `sample 6`() {
        val output = partition3(intArrayOf(1, 1, 10))
        assertThat(output).isEqualTo(0)
    }


    @Test
    fun `sample 7`() {
        val output = partition3(intArrayOf(1, 1, 1))
        assertThat(output).isEqualTo(1)
    }

    @Test
    fun `sample 8`() {
        val output = partition3(intArrayOf(1, 2, 4, 2, 2, 2, 1, 7))
        assertThat(output).isEqualTo(1)
    }

    @Test
    fun `sample 9`() {
        val output = partition3(intArrayOf(3, 3, 6))
        assertThat(output).isEqualTo(0)
    }

    @Test
    fun `sample 10`() {
        val list = mutableListOf<Int>()
        repeat(18) {
            list.add(1)
        }
        val output = partition3(list.toIntArray())
        assertThat(output).isEqualTo(1)
    }
}