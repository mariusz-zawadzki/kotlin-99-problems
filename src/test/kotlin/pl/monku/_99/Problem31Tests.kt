package pl.monku._99

import org.junit.Assert
import org.junit.Test

class Problem31Tests {
    @Test
    fun `should find expected number of primes up to 1000`() {
        var count = 0
        for (i in 1..1000) {
            if (i.isPrime()) count++
        }
        Assert.assertEquals("Expected 168 primes in rante 1..1000", 168, count)
    }

    @Test
    fun `should recognise prime numbers`() {
        Assert.assertEquals(true, 1000003.isPrime())
        Assert.assertEquals(true, 13.isPrime())
        Assert.assertEquals(true, 31.isPrime())
        Assert.assertEquals(false, 1.isPrime())
        Assert.assertEquals(false, 0.isPrime())
        Assert.assertEquals(false, 99.isPrime())
        Assert.assertEquals(false, 1000000.isPrime())
    }
}