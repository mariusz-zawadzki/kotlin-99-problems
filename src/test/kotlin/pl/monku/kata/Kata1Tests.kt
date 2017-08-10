package pl.monku.kata

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */

class Kata1Tests {



    val testedFunction = ::chop

    val hayStack = listOf(1, 2, 3, 4, 5, 7, 8, 9, 123)
    val hayStackEven = listOf(1, 2, 3, 4, 5, 7, 8, 9)

    @Test fun `should find first element`() {
        Assert.assertThat(testedFunction(1, hayStack), Is.`is`(0))
    }
    @Test fun `should not find in empty list`() {
        Assert.assertThat(testedFunction(1, listOf()), Is.`is`(-1))
    }

    @Test fun `should find element mid -1 element`() {
        Assert.assertThat(testedFunction(4, hayStack), Is.`is`(3))
    }

    @Test fun `should find last element`() {
        Assert.assertThat(testedFunction(123, hayStack), Is.`is`(8))
    }

    @Test fun `should not find mid element`() {
        Assert.assertThat(testedFunction(6, hayStack), Is.`is`(-1))
    }

    @Test fun `should find element left of middle`() {
        Assert.assertThat(testedFunction(4, hayStackEven), Is.`is`(3))
    }

    @Test fun `should find element right of middle`() {
        Assert.assertThat(testedFunction(5, hayStackEven), Is.`is`(4))
    }

    @Test fun `should find second to last element`() {
        Assert.assertThat(testedFunction(9, hayStackEven), Is.`is`(7))
    }
}