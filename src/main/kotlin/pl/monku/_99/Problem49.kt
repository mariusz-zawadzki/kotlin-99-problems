package pl.monku._99

fun grayCode(bits: Int) : List<String> {
    if(bits == 1)
    {
        return listOf("0","1")
    }
    else
    {
        val less = grayCode(bits-1)
        return listOf(less.map { "0$it" }, less.reversed().map { "1$it" }).flatMap { it }
    }
}

fun main(args: Array<String>) {
    println(grayCode(1))
    println(grayCode(2))
    println(grayCode(3))
    println(grayCode(4))
}