package day2

import java.io.File

fun List<List<String>>.calcPosition() : Int {
    var depth = 0
    var horiz = 0
    for (i in this.indices)
        when (this[i][0]) {
            "forward" -> horiz += this[i][1].toInt()
            "down" -> depth += this[i][1].toInt()
            "up" -> depth -= this[i][1].toInt()
        }

    println("depth = $depth || horizontal pos = $horiz")
    return depth * horiz
}

fun List<List<String>>.calcAim() : Int {
    var depth = 0
    var horiz = 0
    var aim = 0
    for (i in this.indices)
        when (this[i][0]) {
            "forward" -> {
                horiz += this[i][1].toInt()
                depth += aim * this[i][1].toInt()
            }
            "down" -> aim += this[i][1].toInt()
            "up" -> aim -= this[i][1].toInt()
        }

    println("depth = $depth || horizontal pos = $horiz || aim $aim")
    return depth * horiz
}

fun main(args: Array<String>) {
    val orders = File("""src\main\kotlin\day2\input.txt""").readLines().map{it.split(" ")}
    println(orders.calcPosition()) // 1727835
    println(orders.calcAim()) // 8639175
}
