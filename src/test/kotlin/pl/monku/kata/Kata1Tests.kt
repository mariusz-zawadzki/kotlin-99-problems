package pl.monku.kata

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */

class Kata1Tests {


    val testedFunction = listOf(
            ::chop,
            ::chopRecursion,
            ::chopRecursionIterative)

    val hayStack = listOf(1, 2, 3, 4, 5, 7, 8, 9, 123)
    val hayStackEven = listOf(1, 2, 3, 4, 5, 7, 8, 9)

    @Test
    fun `should find first element`() {
        testedFunction.forEach {
            Assert.assertThat(it(1, hayStack), Is.`is`(0))
        }

    }

    @Test
    fun `should not find in empty list`() {
        testedFunction.forEach {
            Assert.assertThat(it(1, listOf()), Is.`is`(-1))
        }
    }

    @Test
    fun `should find element mid -1 element`() {
        testedFunction.forEach {
            Assert.assertThat(it(4, hayStack), Is.`is`(3))
        }
    }

    @Test
    fun `should find last element`() {
        testedFunction.forEach {
            Assert.assertThat(it(123, hayStack), Is.`is`(8))
        }
    }

    @Test
    fun `should not find mid element`() {
        testedFunction.forEach {
            Assert.assertThat(it(6, hayStack), Is.`is`(-1))
        }
    }

    @Test
    fun `should find element left of middle`() {
        testedFunction.forEach {
            Assert.assertThat(it(4, hayStackEven), Is.`is`(3))
        }
    }

    @Test
    fun `should find element right of middle`() {
        testedFunction.forEach {
            Assert.assertThat(it(5, hayStackEven), Is.`is`(4))
        }
    }

    @Test
    fun `should find second to last element`() {
        testedFunction.forEach {
            Assert.assertThat(it(9, hayStackEven), Is.`is`(7))
        }
    }

    @Test
    fun `code kata original test data`() {

        testedFunction.forEach {
            Assert.assertEquals(-1, it(3, listOf()))
            Assert.assertEquals(-1, it(3, listOf(1)))
            Assert.assertEquals(0, it(1, listOf(1)))

            Assert.assertEquals(0, it(1, listOf(1, 3, 5)))
            Assert.assertEquals(1, it(3, listOf(1, 3, 5)))
            Assert.assertEquals(2, it(5, listOf(1, 3, 5)))
            Assert.assertEquals(-1, it(0, listOf(1, 3, 5)))
            Assert.assertEquals(-1, it(2, listOf(1, 3, 5)))
            Assert.assertEquals(-1, it(4, listOf(1, 3, 5)))
            Assert.assertEquals(-1, it(6, listOf(1, 3, 5)))

            Assert.assertEquals(0, it(1, listOf(1, 3, 5, 7)))
            Assert.assertEquals(1, it(3, listOf(1, 3, 5, 7)))
            Assert.assertEquals(2, it(5, listOf(1, 3, 5, 7)))
            Assert.assertEquals(3, it(7, listOf(1, 3, 5, 7)))
            Assert.assertEquals(-1, it(0, listOf(1, 3, 5, 7)))
            Assert.assertEquals(-1, it(2, listOf(1, 3, 5, 7)))
            Assert.assertEquals(-1, it(4, listOf(1, 3, 5, 7)))
            Assert.assertEquals(-1, it(6, listOf(1, 3, 5, 7)))
            Assert.assertEquals(-1, it(8, listOf(1, 3, 5, 7)))
        }
    }
}