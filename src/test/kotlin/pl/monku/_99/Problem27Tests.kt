package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test


class Problem27Tests {


    @Test
    fun `should group example value`() {
        val list = listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
        val groups = listOf(2, 2, 5)
        val message = group(groups, list)

        val size = calculateExpectedSize(groups, list)
        Assert.assertTrue(message.size == size)
    }

    @Test
    fun `should group small example`() {
        val list = listOf("Aldo", "Beat", "Carla")
        val groups = listOf(1, 1, 1)
        val message = group(groups, list)

        val size = calculateExpectedSize(groups, list)
        Assert.assertTrue(message.size == size)
    }

    @Test
    fun `should group small example with known result`() {
        val A = "Aldo"
        val B = "Beat"
        val C = "Carla"
        val list = listOf(A, B, C)
        val groups = listOf(1, 2)
        val message = group(groups, list)

        val size = calculateExpectedSize(groups, list)
        Assert.assertTrue(message.size == size)

        Assert.assertThat(message, Is.`is`(
                listOf(
                        listOf(listOf(A), listOf(C, B)),
                        listOf(listOf(B), listOf(C, A)),
                        listOf(listOf(C), listOf(B, A))
                )
        ))
    }

    @Test
    fun `should group into one group`() {
        val list = listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
        val groups = listOf(9)
        val message = group(groups, list)

        val size = calculateExpectedSize(groups, list)
        Assert.assertTrue(message.size == size)
    }

    private fun calculateExpectedSize(groups: List<Int>, list: List<String>): Int {
        var size = factorial(list.size)
        groups.forEach { i -> size /= factorial(i) }
        return size
    }

    private fun factorial(list: Int) = 1.rangeTo(list).reduce { a, b -> a * b }

}
