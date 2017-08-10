package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 11.08.17.
 */
class FlattenTests{

    @Test
    fun `should flatten properly`() {
        Assert.assertThat(flatten(listOf(listOf(1, 1), 2, listOf(3, listOf(5, 8)))), Is.`is`(listOf<Any>(1, 1, 2, 3, 5, 8)))
    }
}