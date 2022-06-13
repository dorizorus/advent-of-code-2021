package day3

import java.io.File
import kotlin.math.pow

// really messy stuff. I had an idea, it was awful in the end.
fun Map<Int,Int?>.getGammaTimesEpsilonRayResult(inputSize : Int) : Double {
    var gamma = 0.0
    var epsilon = 0.0
    println(inputSize)

    if (inputSize % 2 == 0)
        for (key in this.keys) {
            println("key  $key || value ${this[key]}")
                if (this[key]!! >= (inputSize / 2))
                    gamma += 2.0.pow(key.toDouble())
                else
                    epsilon += 2.0.pow(key.toDouble())
        }
    else
        for (key in this.keys) {
            println("key  $key || value ${this[key]}")
            if (this[key]!! >= (inputSize + 1 / 2))
                gamma += 2.0.pow(key.toDouble())
            else
                epsilon += 2.0.pow(key.toDouble())
        }

        println("gamma : $gamma || epsilon : $epsilon")


    return gamma * epsilon
}

fun main(args: Array<String>) {
    val input = File("""src\main\kotlin\day3\input.txt""").readLines().map {it}
    val mapOfBits = mutableMapOf<Int, Int?>()
    for (sequence in input) {
        for (i in sequence.indices) {
            val bitCounter = when (mapOfBits[i]) {
                null -> sequence[i].toString().toInt()
                else -> mapOfBits[i]?.plus(sequence[i].toString().toInt())
            }
            mapOfBits[i] = bitCounter
        }
    }

    val answer1 = mapOfBits.getGammaTimesEpsilonRayResult(input.size)
    println(answer1) //1471406



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
