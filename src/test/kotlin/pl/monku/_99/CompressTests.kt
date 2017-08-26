package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 11.08.17.
 */

class CompressTests {

    @Test
    fun `should compress list of characters`() {
        Assert.assertThat(compress("aaaabccaadeeee".toList()), Is.`is`(listOf<Char>('a', 'b', 'c', 'a', 'd', 'e')))
    }

    @Test
    fun `should encode list of characters`() {
        Assert.assertThat(compress("aaaabccaadeeee".toList()), Is.`is`(listOf<Char>('a', 'b', 'c', 'a', 'd', 'e')))
    }

    @Test
    fun `should encode list of characters with single start`() {
        Assert.assertThat(compress("abccaadeeee".toList()), Is.`is`(listOf<Char>('a', 'b', 'c', 'a', 'd', 'e')))
    }
}