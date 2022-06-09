package day1

import java.io.File

fun List<Int>.countIncreasingDepth() : Int {
    var counter = 0
    for (i in this.indices)
        if (i != 0 && this[i] > this[i-1])
            counter++

    return counter
}

fun List<Int>.countGroupOf3sIncreasingDepth() : Int {
    var counter = 0
    for (i in 3 until this.size) {
        val group1 = this[i - 3] + this[i - 2] + this[i - 1]
        val group2 = this[i - 2] + this[i - 1] + this[i]
        if (group2 > group1)
            counter++
    }

    return counter
}

fun main(args: Array<String>) {
    // - read text file
    // - one line = one input, all integers, so a list of integers
    val listOfDepths = File("""src\main\kotlin\day1\input.txt""").readLines().map{ it.toInt() }
    println(listOfDepths.countIncreasingDepth()) //1752
    println(listOfDepths.countGroupOf3sIncreasingDepth()) //1781

}
