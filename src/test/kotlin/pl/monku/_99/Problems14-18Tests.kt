package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

class `Problems14-18Tests` {

    @Test
    fun `should duplicate entries`() {
        Assert.assertThat(duplicate("abccd".toList()), Is.`is`("aabbccccdd".toList()))
    }

    @Test
    fun `should duplicate entries N times`() {
        Assert.assertThat(duplicateN(3,"abccd".toList()), Is.`is`("aaabbbccccccddd".toList()))
    }

    @Test
    fun `should drop nth element from list`() {
        Assert.assertThat(drop(3,"abcdefghijk".toList()), Is.`is`("abdeghjk".toList()))
    }

    @Test
    fun `should split list on nth element `() {
        Assert.assertThat(split(3,"abcdefghijk".toList()), Is.`is`(listOf("abc".toList(), "defghijk".toList())))
    }

    @Test
    fun `should slice list on nth element `() {
        Assert.assertThat(slice(3, 7,"abcdefghijk".toList()), Is.`is`("defg".toList()))
    }
}