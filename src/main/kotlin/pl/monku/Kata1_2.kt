package pl.monku

/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */


/**
 * Created by mariusz.r.zawadzki@gmail.com on 09.08.17.
 */
fun chopRecursion(needle: Int, hayStack: List<Int>): Int {
    return chopRecursionInner(needle, hayStack , 0)
}
fun chopRecursionInner(needle: Int, hayStack: List<Int>, offset: Int): Int {

    if(hayStack.size == 0){
        return -1;
    }
    var index = hayStack.size/2;
    var upperBound = hayStack.size;
    var lowerBound = 0;
    val mid = hayStack[index];
    if(mid == needle)
    {
        return offset+index;
    }
    if(needle< mid)
    {
        upperBound = index
    }
    else
    {
        lowerBound = index
    }
    if(lowerBound == 0 && upperBound == hayStack.size)
    {
        return -1
    }
    val chopRecursion = chopRecursionInner(needle, hayStack.subList(lowerBound, upperBound), lowerBound)
    return if(chopRecursion<0) -1 else offset+chopRecursion
}
