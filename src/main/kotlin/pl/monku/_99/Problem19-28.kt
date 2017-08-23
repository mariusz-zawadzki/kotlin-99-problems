package pl.monku._99

import java.security.SecureRandom
import java.util.*


//P19
fun <T> rotate(n: Int, list: List<T>): List<T>{
    var rotate = n;
    if(rotate==0) {
        return list;
    }

    rotate %= list.size
    if(rotate<0) {
        rotate += list.size
    }
    val result = arrayListOf<T>()
    result.addAll(list.subList(rotate,list.size))
    result.addAll(list.subList(0,rotate))
    return result.toList();
}

//P20
fun <T> removeAt(n: Int, list: List<T>): Pair<List<T>,T>{
    val toMutableList = list.toMutableList()
    val t = toMutableList.removeAt(n)
    return Pair(toMutableList, t)
}

//P21
fun <T> insertAt(c: T, n: Int, list: List<T>): List<T>{
    val toMutableList = list.toMutableList()
    val t = toMutableList.removeAt(n)
    toMutableList.add(n,c)
    return toMutableList.toList()
}

//P22
fun range(start: Int, end: Int): List<Int>
{
    return start.rangeTo(end).toList()
}

val r = SecureRandom()
//P23
fun <E> randomSelect(n:Int, list: List<E>, random: Random = r): List<E>{
    val mutList = list.toMutableList()
    if(n>= list.size)
    {
        return list
    }
    val result = mutableListOf<E>()
    while(result.size < n)
    {
        result.add(mutList.removeAt(random.nextInt(mutList.size)))
    }
    return result.toList()
}

//P24
fun randomSelect(n:Int, top: Int, random: Random = r): List<Int>{
    val list = 1.rangeTo(top).toMutableList()
    if(n>= list.size)
    {
        return list
    }
    val result = mutableListOf<Int>()
    while(result.size < n)
    {
        result.add(list.removeAt(random.nextInt(list.size)))
    }
    return result.toList()
}

//P25
fun <E> randomPermute(list: List<E>, random: Random = r): List<E>
{
    val result = list.toMutableList()
    Collections.shuffle(result, random)
    return result
}

//P26
fun <E> combinations(n:Int,  list: List<E>): List<List<E>>
{
    return Combinations(n, list.size).allCombinations.map { combination->
        val result = mutableListOf<E>()
        combination.forEach({el-> result.add(list[el])})
        result
    }
}
//P27
fun <E> group(groups: List<Int>, list: List<E>): List<List<List<E>>> {
    val groupSize = groups.reduce({ a, b -> a + b })
    check(list.size == groupSize, {"grouping size ($groupSize)should match list size (${list.size})"} )
    val combinations = mutableListOf<List<List<Int>>>()

    var size = list.size;
    groups.forEach { e->
        combinations.add(Combinations(e, size).allCombinations)
        size -=e
    }
    val groupedCombinations = groupCombinations(combinations)
    return groupedCombinations.map { parentCombinations->
        val result = mutableListOf<List<E>>()
        val reminder = list.toMutableList()
        parentCombinations.forEach { combination->
            var combinationResult = mutableListOf<E>()
            combination.sortedDescending().forEach({index->
                combinationResult.add(reminder.removeAt(index))
            })
            result.add(combinationResult)
        }
        result.toList()
    }
//    groupedCombinations.forEach({ c->println(c)})
//    return combinations.map { l->
//        var mutable = list.toMutableList()
//        l.map { e->mutable.removeAt(0)}
//    }
}

fun groupCombinations(combination : List<List<List<Int>>>): List<List<List<Int>>>{
    var prefixes = listOf<List<List<Int>>>()
    combination.forEach { combinationList->
        prefixes = groupCombinations1(prefixes, combinationList)
    }
    return prefixes
}

fun groupCombinations1(prefixes: List<List<List<Int>>>, combination: List<List<Int>>): List<List<List<Int>>> {
    return if(prefixes.isEmpty()) {
        combination.map { l-> listOf(l) };
    } else {
        prefixes.flatMap { prefix->
            val map = combination.map {c ->
                val toMutableList = prefix.toMutableList()
                toMutableList.add(c)
                toMutableList.toList()
            }
            map
        }
    }
}
//
//fun <E> extractGroups(groups: List<List<Int>>, list: List<E>): List<List<E>>
//{
//    while(groups.size>0)
//}
//
//fun <E> extractGroup(group: List<Int>, list: List<E>): Pair<List<E>, List<E>>{
//    val reminder = list.toMutableList()
//    val select = mutableListOf<E>()
//    group.forEach { e->select.add(reminder.removeAt(e)) }
//    return Pair(select, reminder)
//}



//P28
fun <E> lengthSort(list: List<List<E>>): List<List<E>>
{
    return list.sortedBy { l->l.size }
}

fun <E> lengthFreqSort(list: List<List<E>>): List<List<E>>
{
    val frequencyMap = mutableMapOf<Int, Int>()
    list.forEach({e->
        val plus = frequencyMap[e.size]?.plus(1)
        frequencyMap[e.size] = if(plus !=null) plus else 1
    })
    return list.sortedBy { l->frequencyMap[l.size] }

}

fun main(args: Array<String>) {
//    println(lengthFreqSort(listOf("abc".toList(), "de".toList(), "fgh".toList(), "de".toList(), "ijkl".toList(), "mn".toList(), "o".toList())))

    val message = group(listOf(2, 2, 5), listOf("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
    message.forEach { m->
        println(m)
    }

}

class Combinations(val m: Int, val n: Int) {
    private val combination = IntArray(m)
    val allCombinations = mutableListOf<List<Int>>()

    init {
        generate(0)
    }

    private fun generate(k: Int){
        if (k >= m) {
            allCombinations.add(combination.toList())
        }
        else {
            for (j in 0 until n)
                if (k == 0 || j > combination[k - 1]) {
                    combination[k] = j
                    generate(k + 1)
                }
        }
    }
}