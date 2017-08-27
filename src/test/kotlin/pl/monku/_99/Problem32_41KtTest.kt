package pl.monku._99

import org.junit.Assert
import org.junit.Test

class Problem32_41KtTest {

    @Test
    fun `sould find correct gcd`() {
        Assert.assertEquals(13, gcd(13, 39))
        Assert.assertEquals(1000003, gcd(2000006, 1000003))
        Assert.assertEquals(1, gcd(13, 1000003))
    }

    @Test
    fun isCoprime() {
        Assert.assertEquals(true, 13.isCoprime(1000003))
        Assert.assertEquals(true, 13.isCoprime(1000000))
        Assert.assertEquals(false, 13.isCoprime(39))
    }

    @Test
    fun `should find proper value of totient - count of number 1 to n where n_isCooprime(i)`() {
        Assert.assertEquals(1000002, 1000003.totient())
        Assert.assertEquals(12, 13.totient())
        Assert.assertEquals(8, 24.totient())
        Assert.assertEquals(1, 1.totient())
    }

    @Test
    fun `should find proper prime factors`() {
        Assert.assertEquals(listOf(2, 2, 2, 3, 5), (2 * 2 * 2 * 3 * 5).primeFactors())
        Assert.assertEquals(listOf(2, 2, 3, 3, 17), (2 * 2 * 3 * 3 * 17).primeFactors())
    }

    @Test
    fun `should find proper prime factors and their multiplicity`() {
        Assert.assertEquals(listOf(Pair(2, 3), Pair(3, 1), Pair(5, 1)), (2 * 2 * 2 * 3 * 5).primeFactorMultiplicity())
        Assert.assertEquals(listOf(Pair(2, 16)), (16 * 16 * 16 * 16).primeFactorMultiplicity())
    }

    @Test
    fun `should find same phi and totient values`() {
        for (n in 1..100) {
            Assert.assertEquals(n.totient(), n.phi())
        }
    }

    @Test
    fun `should find all primes in range`() {
        Assert.assertEquals(listOf(2, 3, 5, 7, 11, 13, 17, 19, 23
                , 29, 31, 37, 41, 43, 47, 53, 59, 61, 67
                , 71, 73, 79, 83, 89, 97, 101, 103, 107, 109
                , 113, 127, 131, 137, 139, 149, 151, 157, 163, 167
                , 173, 179, 181, 191, 193, 197, 199, 211, 223, 227
                , 229, 233, 239, 241, 251, 257, 263, 269, 271, 277
                , 281, 283, 293, 307, 311, 313, 317, 331, 337, 347
                , 349, 353, 359, 367, 373, 379, 383, 389, 397, 401
                , 409, 419, 421, 431, 433, 439, 443, 449, 457, 461
                , 463, 467, 479, 487, 491, 499, 503, 509, 521, 523
                , 541, 547, 557, 563, 569, 571, 577, 587, 593, 599
                , 601, 607, 613, 617, 619, 631, 641, 643, 647, 653
                , 659, 661, 673, 677, 683, 691, 701, 709, 719, 727
                , 733, 739, 743, 751, 757, 761, 769, 773, 787, 797
                , 809, 811, 821, 823, 827, 829, 839, 853, 857, 859
                , 863, 877, 881, 883, 887, 907, 911, 919, 929, 937
                , 941, 947, 953, 967, 971, 977, 983, 991, 997), listPrimesInRange(1..1000))
    }

    fun `should calculate proper goldbach conjecture values - n_goldbach() ( a + b  ) = n  and a,b are prime`() {
        val values = listOf<Int>(14, 1_000_000, 113_123_4320)
        values.forEach {
            val (a, b) = it.goldbach()
            Assert.assertEquals(true, a.isPrime())
            Assert.assertEquals(true, b.isPrime())
            Assert.assertEquals(it, a + b)
        }
    }

    @Test
    fun `should find all goldbach pairs in range`() {

        Assert.assertEquals(
                listOf(Pair(3, 7),
                        Pair(5, 7),
                        Pair(3, 11),
                        Pair(3, 13),
                        Pair(5, 13),
                        Pair(3, 17)),
                printGoldbachList(9..20))
    }

    @Test
    fun `should find only goldbach pairs with first number greater th`() {

        Assert.assertEquals(
                listOf(
                        Pair(7, 7),
                        Pair(7, 11),
                        Pair(7, 13)
                ),

                printGoldbachList(9..20, 7))
    }

    @Test
    fun `should find only those goldbach pairs where lowest prime possible is greater than limit`() {

        Assert.assertEquals(
                listOf(
                        Pair(73, 919), 
                        Pair(61, 1321), 
                        Pair(67, 1789),
                        Pair(61, 1867),
                        Pair(61, 2017),
                        Pair(61, 2377),
                        Pair(53, 2459),
                        Pair(53, 2477),
                        Pair(61, 2557),
                        Pair(103, 2539)
                ),
                printGoldbachListLimited(2..3000, 50)
        )
    }
}