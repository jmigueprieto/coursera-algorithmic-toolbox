package week3

import getChange
import org.junit.Test

import org.assertj.core.api.Assertions.*

class ChangeTest {

    @Test
    fun `when input is 1 change should be 1`(){
        val change = getChange(1)
        assertThat(change).isEqualTo(1)
    }

    @Test
    fun `when input is 5 change should be 1`(){
        val change = getChange(5)
        assertThat(change).isEqualTo(1)
    }

    @Test
    fun `when input is 10 change should be 1`(){
        val change = getChange(10)
        assertThat(change).isEqualTo(1)
    }

    @Test
    fun `when input is 2 change should be 2`() {
        val change = getChange(2)
        assertThat(change).isEqualTo(2)
    }

    @Test
    fun `when input is 28 change should be 6`() {
        val change = getChange(28)
        assertThat(change).isEqualTo(6)
    }

    @Test
    fun `when input is 15 change should be 2`(){
        val change = getChange(15)
        assertThat(change).isEqualTo(2)
    }

    @Test
    fun `when input is 17 change should be 4`(){
        val change = getChange(17)
        assertThat(change).isEqualTo(4)
    }

}