package pl.monku._99

import org.junit.Assert
import org.junit.Test

class Problem49Tests{
    @Test
    fun `should return proper gray code length per for bits`() {
        Assert.assertEquals(grayCode(10).count { it.length==10 }, 2.pow(10))
        Assert.assertEquals(grayCode(10).count { it.length!=10 }, 0)
        Assert.assertEquals(grayCode(4).count { it.length!=4 }, 0)
    }

    @Test
    fun `should return expected code`() {
        Assert.assertEquals(listOf("000","001","011","010","110","111","101","100"), grayCode(3))
    }
}