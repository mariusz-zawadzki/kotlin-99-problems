package pl.monku._99

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class Problem32_39KtTest {

    @Test
    fun `sould find correct gcd`() {
        Assert.assertEquals(13, gcd(13,39))
        Assert.assertEquals(1000003, gcd(2000006,1000003))
        Assert.assertEquals(1, gcd(13,1000003))
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
        Assert.assertEquals(listOf(2,2,2,3,5), (2*2*2*3*5).primeFactors())
        Assert.assertEquals(listOf(2,2,3,3,17), (2*2*3*3*17).primeFactors())
    }

    @Test
    fun `should find proper prime factors and their multiplicity`() {
        Assert.assertEquals(listOf(Pair(2,3),Pair(3,1), Pair(5,1)), (2*2*2*3*5).primeFactorMultiplicity())
        Assert.assertEquals(listOf(Pair(2,16)), (16*16*16*16).primeFactorMultiplicity())
    }

    @Test
    fun `should find same phi and totient values`() {
        for(n in 1..100)
        {
            Assert.assertEquals(n.totient(), n.phi())
        }
    }

    @Test
    fun `should find all primes in range`() {
        Assert.assertEquals(listOf(2,3,5,7,11,13,17,19,23
                ,29,31,37,41,43,47,53,59,61,67
                ,71,73,79,83,89,97,101,103,107,109
                ,113,127,131,137,139,149,151,157,163,167
                ,173,179,181,191,193,197,199,211,223,227
                ,229,233,239,241,251,257,263,269,271,277
                ,281,283,293,307,311,313,317,331,337,347
                ,349,353,359,367,373,379,383,389,397,401
                ,409,419,421,431,433,439,443,449,457,461
                ,463,467,479,487,491,499,503,509,521,523
                ,541,547,557,563,569,571,577,587,593,599
                ,601,607,613,617,619,631,641,643,647,653
                ,659,661,673,677,683,691,701,709,719,727
                ,733,739,743,751,757,761,769,773,787,797
                ,809,811,821,823,827,829,839,853,857,859
                ,863,877,881,883,887,907,911,919,929,937
                ,941,947,953,967,971,977,983,991,997), listPrimesInRange(1..1000))
    }
}