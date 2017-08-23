package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

class Problem19Tests{

    private val testedList = "abcde".toList()

    @Test
    fun `should not rotate if same as size or negative size`() {
        Assert.assertThat(rotate(testedList.size, testedList), Is.`is`(testedList))
        Assert.assertThat(rotate(-testedList.size, testedList), Is.`is`(testedList))
    }

    @Test
    fun `should rotate 1 and size+1 to the same list`() {
        val expectedResult = "bcdea".toList()
        Assert.assertThat(rotate(1, testedList), Is.`is`(expectedResult))
        Assert.assertThat(rotate(testedList.size+1, testedList), Is.`is`(expectedResult))
        Assert.assertThat(rotate(-testedList.size+1, testedList), Is.`is`(expectedResult))
    }

    @Test
    fun `should return problems expected examples`() {

        Assert.assertThat(rotate(3, "abcdefghijk".toList()), Is.`is`("defghijkabc".toList()))
        Assert.assertThat(rotate(-2, "abcdefghijk".toList()), Is.`is`("jkabcdefghi".toList()))
    }
}