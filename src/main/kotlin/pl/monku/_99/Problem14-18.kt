package pl.monku._99

//P14
fun <T> duplicate(list: List<T>): List<T> {
    val mlist: MutableList<T> = mutableListOf()
    list.forEach({e->
        mlist.add(e)
        mlist.add(e)
    })
    return mlist.toList()
}


//P15
fun <T> duplicateN(n : Int, list: List<T>): List<T> {
    val mlist: MutableList<T> = mutableListOf()
    list.forEach({e->
        repeat(n,{_-> mlist.add(e)})
    })
    return mlist.toList()
}
//P16
fun <T> drop(n : Int, list: List<T>): List<T> {
    val mlist: MutableList<T> = mutableListOf()
    list.forEachIndexed { index, e ->
        if((index+1)%n!=0) mlist.add(e)
    }
    return mlist.toList()
}

//P17
fun <T> split(n : Int, list: List<T>): List<List<T>> {
    return listOf(list.subList(0,n), list.subList(n, list.size))
}

//P18
fun <T> slice(i : Int, k: Int, list: List<T>): List<T> {
    return list.subList(i,k)
}

