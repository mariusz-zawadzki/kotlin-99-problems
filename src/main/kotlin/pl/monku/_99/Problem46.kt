package pl.monku._99


fun Boolean. and_ (b: Boolean ): Boolean = this.and(b)
fun Boolean. or_ (b: Boolean ): Boolean = this || b
fun Boolean. nano_ (b: Boolean ): Boolean = !(this && b)
fun Boolean. xor_ (b: Boolean ): Boolean = if (this) !b else b
fun Boolean. impl_ (b: Boolean ): Boolean = if (this) !b else b
fun Boolean. eq_ (b: Boolean ): Boolean = !this || b
fun Boolean. not_ (): Boolean = !this


fun printTruthTable(func :(Boolean,Boolean)->Boolean): String{
    val sb = StringBuilder()
    val table= getTable(func)
    sb.append(" a\\b \tfalse\ttrue\n")
    sb.append("false\t${table.first.first}\t${table.first.second}\n")
    sb.append("true \t${table.second.first}\t${table.second.second}\n")

    return sb.toString()
}

fun getTable(func: (Boolean, Boolean) -> Boolean) = Pair(
            Pair(func(false,false), func(false,true)),
            Pair(func(true,false), func(true,true)) )


fun main(args: Array<String>) {
    println(printTruthTable { a, b -> a.xor_(b) })
}