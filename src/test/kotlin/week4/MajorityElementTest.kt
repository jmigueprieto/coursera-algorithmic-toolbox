package week4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MajorityElementTest {

    @Test
    fun `sample 1`() {
        val res = MajorityElement.getMajorityElement(intArrayOf(2, 39, 2, 2), 5)
        assertThat(res).isEqualTo(true)
    }

    @Test
    fun `sample 2`() {
        val res = MajorityElement.getMajorityElement(intArrayOf(1, 2, 3, 4), 4)
        assertThat(res).isEqualTo(false)
    }

    @Test
    fun `sample 3`() {
        val res = MajorityElement.getMajorityElement(intArrayOf(1, 2, 3, 1), 4)
        assertThat(res).isEqualTo(false)
    }

    @Test
    fun `sample 4`() {
        val res = MajorityElement.getMajorityElement(
            intArrayOf(
                512766168,
                717383758,
                5,
                126144732,
                5,
                573799007,
                5,
                5,
                5,
                405079772
            ), 10
        )
        assertThat(res).isEqualTo(false)
    }

}