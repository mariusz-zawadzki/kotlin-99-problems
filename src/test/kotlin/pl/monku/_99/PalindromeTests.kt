package pl.monku._99

import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test

/**
 * Created by mariusz.r.zawadzki@gmail.com on 11.08.17.
 */
class PalindromeTests
{

    @Test
    fun `should be a palindrome`(){
        Assert.assertThat(isPalindrome(listOf(1,2,3,2,1)), Is.`is`(true) )
        Assert.assertThat(isPalindrome(listOf(1,2,2,1)), Is.`is`(true) )
        Assert.assertThat(isPalindrome(listOf(1)), Is.`is`(true) )
        Assert.assertThat(isPalindrome(listOf<Int>()), Is.`is`(true) )
    }

    @Test
    fun `should not be a palindrome`() {
        Assert.assertThat(isPalindrome(listOf(1,2)), Is.`is`(false) )
        Assert.assertThat(isPalindrome(listOf(1,2,3)), Is.`is`(false) )
    }
}