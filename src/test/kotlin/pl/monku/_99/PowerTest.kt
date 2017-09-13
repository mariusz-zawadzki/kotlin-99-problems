package pl.monku._99

import org.junit.Assert
import org.junit.Test

class PowerTest{
    @Test
    fun `should produce epxected results of powering numbers`() {
        Assert.assertEquals(1, 1.pow(19))
        Assert.assertEquals(1, 1.pow(0))
        Assert.assertEquals(1, 142342.pow(0))
        Assert.assertEquals(256, 2.pow(8) )
        Assert.assertEquals(100_000_000, 10.pow(8))
    }
}