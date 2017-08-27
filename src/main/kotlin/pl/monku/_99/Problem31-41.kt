package pl.monku._99

//P31
fun Int.isPrime(): Boolean {
    if (this <= 1)
        return false
    else if (this <= 3)
        return true
    else if (this % 2 == 0 || this % 3 == 0)
        return false
    var i = 5
    while (i * i <= this) {
        if (this % i == 0 || this % (i + 2) == 0)
            return false
        i += 6
    }
    return true
}

//P32
fun gcd(i1: Int, i2: Int): Int {
    var a = i1
    var b = i2
    while (b != 0) {
        val t = b
        b = a % b
        a = t
    }

    return a
}


//P33
fun Int.isCoprime(n: Int): Boolean = 1 == gcd(this, n)

//P34
fun Int.totient(): Int = (1..this).count { this.isCoprime(it) }

//P35
fun Int.primeFactors(): List<Int> {
    val result = mutableListOf<Int>()
    var reminder = this
    val primeCalculator = PrimesGenerator(2)
    while (reminder != 1) {
        if (reminder % primeCalculator.currentPrime == 0) {
            reminder /= primeCalculator.currentPrime
            result += primeCalculator.currentPrime
            primeCalculator.currentPrime
        } else {
            primeCalculator.nextPrime()
        }
        //is it an improvement? write tests!!
        if (reminder.isPrime()) {
            result.add(reminder)
            reminder = 1
        }

    }
    return result
}


//P36
fun Int.primeFactorMultiplicity(): List<Pair<Int, Int>> {
    val primeFactors = this.primeFactors()
    val result = mutableMapOf<Int, Int>()
    primeFactors.forEach {
        val count = result.getOrDefault(it, 0)
        result.put(it, count + 1)
    }
    return result.map { Pair(it.key, it.value) }
}

//P37
fun Int.phi(): Int {
    val primeFactorMultiplicity = this.primeFactorMultiplicity()
    return primeFactorMultiplicity.fold(1, { acc, p ->
        acc * (p.first - 1) * p.first.pow(p.second - 1)
    })
}

//p38
//ommited

//P39
fun listPrimesInRange(range: IntRange) = range.filter { it.isPrime() }

//P40
fun Int.goldbach(): Pair<Int,Int>{
    val goldbachLimited = this.goldbachLimited()
    return if(goldbachLimited !=null) goldbachLimited else TODO("Goldbach conjecture not found for $this. Get noble price in math ;-) ")
}

//P41
fun printGoldbachList(range: IntRange, limit: Int = Int.MIN_VALUE): List<Pair<Int,Int>> = range
        .filter { it % 2 == 0 }
        .mapNotNull {
            it.goldbachLimited(limit)
        }

fun printGoldbachListLimited(range: IntRange, limit: Int = 1) =
        printGoldbachList(range).filter { it.first>limit }

fun Int.goldbachLimited(limit:Int = Int.MIN_VALUE): Pair<Int,Int>?{
    if (this % 2 != 0) throw IllegalArgumentException("Number for goldbach should be even $this is odd")
    val half = this / 2
    val start = Math.max(limit, 2)
    for(i in start..half) {
        if(i.isPrime() && (this-i).isPrime())
            return Pair(i, this-i)
    }
    return null
}

fun Int.pow(n: Int): Int {
    if (n == 0) {
        return 1
    }
    var result = 1
    for (i in 1..n) {
        result *= this
    }
    return result
}


class PrimesGenerator(var currentPrime: Int) {
    fun nextPrime(): Int {
        if (currentPrime % 2 == 0)
            while (!(++currentPrime).isPrime()) {
            }
        else
            do {
                currentPrime += 2
            } while (!currentPrime.isPrime())
        return currentPrime
    }
}


fun main(args: Array<String>) {
    System.out.println(134.phi())
    System.out.println(134.totient())
    System.out.println(listPrimesInRange(7..31))
}
