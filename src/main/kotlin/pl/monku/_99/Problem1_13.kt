package pl.monku._99

/**
 * Created by mariusz.r.zawadzki@gmail.com on 11.08.17.
 */

//P01
fun <T> findLast(list: List<T>) = list.last()

//P02
fun <T> findPreLast(list: List<T>): T {
    return when {
        list.size > 1 -> list[list.lastIndex - 1]
        else -> throw NoSuchElementException("List is to short, at least 2 elements expected.")
    }
}

//P03
fun <T> nth(n: Int, list: List<T>) = list[n]

//P04
fun <T> length(list: List<T>) = list.size

//P05
fun <T> reverse(list: List<T>) = list.asReversed()

//P06
fun <T> isPalindrome(list: List<T>): Boolean {
    var offset = 0
    var isPalindrome = true
    while (offset*2 < list.size)
    {
        val areSame = list[offset]==list[list.lastIndex-offset]
        isPalindrome = isPalindrome && areSame
        if(!isPalindrome)
        {
            return isPalindrome
        }
        offset++
    }
    return isPalindrome
}

//P07
fun flatten(list: List<Any>): List<Any> {
    return list.flatMap { el-> if(el is List<*>) {
        flatten(el.requireNoNulls())
    } else listOf<Any>(el) }
}


//P08
fun <T> compress(list: List<T>): List<T> {
    return list.filterIndexed { index, t ->
        (index > 0 && list[index-1] != t)
    }
}

//P09
fun <T> pack(list: List<T>): List<List<T>> {
    var previous: T? = null
    var currentList = mutableListOf<T>()
    val result = mutableListOf<List<T>>()
    for(element in list)
    {
        if(previous == null || element == previous)
        {
            currentList.add(element)
        }
        else
        {
            result.add(currentList)
            currentList = mutableListOf<T>(element)
        }
        previous = element
    }
    result.add(currentList)
    return result

}

//P10
fun <T> encode(list: List<T>): List<Pair<Int,T>>{
    val packed = pack(list)

    return packed.map { l->Pair(l.size, l.first()) }
}
//P11
fun <T> encodeModified(list: List<T>): List<Any> {
    val encoded = encode(list)

    return encoded.map{p-> if(p.first == 1) p.second as Any else p}
}

//P12
fun <T> decode(list: List<Pair<Int,T>>): List<T>{
    return list.flatMap { p-> 1.rangeTo(p.first).map { p.second } }
}
//P09
fun <T> encodeDirect(list: List<T>): List<Pair<Int,T>> {
    var previous: T? = null
    var currentList: Pair<Int,T>? =  null
    val result = mutableListOf<Pair<Int,T>>()
    for(element in list)
    {
        if(previous == null || currentList == null)
        {
            currentList = Pair(1, element)
        }
        else if(element == previous)
        {
            currentList = Pair(currentList.first+1, element)
        }
        else
        {
            result.add(currentList)
            currentList = Pair(1, element)
        }
        previous = element
    }
    if(currentList!=null)
    {
        result.add(currentList)
    }
    return result

}