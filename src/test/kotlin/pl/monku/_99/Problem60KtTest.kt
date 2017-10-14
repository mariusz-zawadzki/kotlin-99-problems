package pl.monku._99

import org.hamcrest.CoreMatchers
import org.junit.Test

import org.junit.Assert.*

class Problem60KtTest {

    @Test
    fun `should return trees with proper nodes count`() {
        assertThat(allHBTreesWithNodeAmount(2, "X").size, CoreMatchers.equalTo(2))
        assertThat(allHBTreesWithNodeAmount(3, "X").size, CoreMatchers.equalTo(1))
        assertThat(allHBTreesWithNodeAmount(4, "X").size, CoreMatchers.equalTo(4))
        assertThat(allHBTreesWithNodeAmount(7, "X").size, CoreMatchers.equalTo(1))
        assertThat(allHBTreesWithNodeAmount(8, "X").size, CoreMatchers.equalTo(8))
        assertThat(allHBTreesWithNodeAmount(14, "X").size, CoreMatchers.equalTo(8))
        assertThat(allHBTreesWithNodeAmount(15, "X").size, CoreMatchers.equalTo(1))
        assertThat(allHBTreesWithNodeAmount(16, "X").size, CoreMatchers.equalTo(16))
    }
}