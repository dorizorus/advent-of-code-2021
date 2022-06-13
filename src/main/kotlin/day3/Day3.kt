package day3

import java.io.File
import kotlin.math.pow

fun Map<Int,Int?>.getStringOfMostPopularBit(inputSize : Int) : String {
    var string = ""
    when (inputSize.hasEvenEntries()) {
        true -> {
            for (key in this.keys)
                string += if (is1MostPopularBit_EvenSize(this[key], inputSize))
                    "1"
                else
                    "0"
        }
            false -> {
                for (key in this.keys)
                    string += if (is1MostPopularBit_OddSize(this[key], inputSize))
                        "1"
                    else
                        "0"
            }
    }

    return string
}

fun String.invertBits() : String {
    var string = ""
    for (char in this)
        string += if (char == '0')
            "1"
        else
            "0"
    return string
}

fun List<String>.`find CO2 scrubber rating`(gammaString : String) : String {
    return "0"
}

fun List<String>.`find oxygen generator rating`(epsilonString : String) : String {
    return "0"
}

fun String.convertBinaryToDecimal() : Int {
    var decimal = 0.0
    for (i in this.indices)
        decimal += this[i].toString().toDouble() * 2.0.pow(this.length - 1 - i)
    return decimal.toInt()
}


fun Int.hasOddEntreies() : Boolean = this % 2 != 0
fun Int.hasEvenEntries() : Boolean = this % 2 == 0
fun is1MostPopularBit_EvenSize(input : Int?, size : Int) : Boolean = input!! >= size / 2
fun is1MostPopularBit_OddSize(input : Int?, size : Int) : Boolean = input!! >= (size+1) / 2

fun main(args: Array<String>) {
    val input = File("""src\main\kotlin\day3\input.txt""").readLines().map {it}

    /**
     * Goal is :
     * 1. get a map of <Int,Int>
     *     The first Int is the position of the bit
     *     The second Int is a counter of how many "1"s there are in at that pos in the list of inputs
     * 2. if the counter of "1"s is >= input.size / 2 or is >= (input.size+1) / 2 (depending on even or odd number of entries)
     * this means 1 is the most popular else it's 0
     * 3. construct a string of most popular bits (gammaString) and its opposite (epsilonString)
     * 4. work from there to get the answer of part1 (which is just converting them to decimal and multiplying them)
     *      and of part2 (go through the list.. again ! to sort these out)
     */
    val mapOfBits = mutableMapOf<Int, Int>()

    for (sequence in input) {
        for (i in sequence.indices) {
            val bitCounter = when (mapOfBits[i]) {
                null -> sequence[i].toString().toInt()
                else -> mapOfBits[i]!!.plus(sequence[i].toString().toInt())
            }
            mapOfBits[i] = bitCounter
        }
    }

    val gammaString = mapOfBits.getStringOfMostPopularBit(input.size)
    val epsilonString = gammaString.invertBits()

    val answer1 = gammaString.convertBinaryToDecimal() * epsilonString.convertBinaryToDecimal()
    println(answer1) //4138664


    val answer2 = 0
    println(answer2) // XXX



// test stuff for my algorythm, lol
   /* for (i in input.first().indices) {
        val bitCounter = when (mapOfBits[i]) {
            null -> Integer.parseInt(input.first()[i].toString())
            else -> mapOfBits[i]?.plus(input.first()[i].toInt()) ?: 0
        }
        println("$i -> $bitCounter")
        mapOfBits[i] = bitCounter
    } */
}
