package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 11.08.17.
 */
class ListPackingTests {

    @Test
    fun `should pack a list to list of lists`() {
        Assert.assertThat(pack("aaaabccaadeeee".toList()), Is.`is`(listOf(listOf('a', 'a', 'a', 'a'), listOf('b'), listOf('c', 'c'), listOf('a', 'a'), listOf('d'),
                listOf('e', 'e', 'e', 'e'))))

    }

    @Test
    fun `should encode a list to list of pairs`() {
        Assert.assertThat(encode("aaaabccaadeeee".toList()), Is.`is`(
                listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'),
                        Pair(4, 'e'))))

    }

    @Test
    fun `should decode a list from list of pairs`() {
        Assert.assertThat(decode(listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'),
                Pair(4, 'e'))), Is.`is`("aaaabccaadeeee".toList()))

    }

    @Test
    fun `should encode a list to list of pairs or any`() {
        Assert.assertThat(encodeModified("aaaabccaadeeee".toList()), Is.`is`(
                listOf<Any>(Pair(4, 'a'), 'b', Pair(2, 'c'), Pair(2, 'a'), 'd',
                        Pair(4, 'e'))))
    }

    @Test
    fun `should encode the same`() {
        Assert.assertEquals(encode("aaaabccaadeeee".toList()), encodeDirect("aaaabccaadeeee".toList()))
    }
}