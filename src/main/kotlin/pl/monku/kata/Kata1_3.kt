package pl.monku.kata

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */

fun chopRecursionIterative(needle: Int, hayStack: List<Int>): Int {

    var searchStack = hayStack
    var offset = 0
    while(searchStack.isNotEmpty())
    {
        val index = searchStack.size/2
        var upperBound = searchStack.size
        var lowerBound = 0
        val mid = searchStack[index]
        if(mid == needle)
        {
            return offset+index
        }
        if(needle< mid)
        {
            upperBound = index
        }
        else
        {
            lowerBound = index
        }
        if(lowerBound == 0 && upperBound == searchStack.size)
        {
            return -1
        }
        searchStack  = searchStack.subList(lowerBound, upperBound)
        offset += lowerBound
    }
    return -1
}