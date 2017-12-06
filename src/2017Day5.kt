import java.io.File

/**
 * http://adventofcode.com/2017/day/5
 */
fun main(args: Array<String>) {

    val path = System.getProperty("user.dir")
    val values = mutableListOf<Int>()

    File("$path/inputs/2017Day5_input.txt").useLines { line -> line.forEach { l -> values.add(l.toInt())}}

    // start from the beginning
    var pos = 0
    var result = 0

    // check list edges to see when we'll exit the "maze"
    while (pos >= 0 && pos < values.size) {

        val next = pos + values[pos] // next position

        // Part 1
        // values[pos] = values[pos] + 1 // increment current offset value by one
        // Part 2
        values[pos] = if (values[pos] >= 3) values[pos]-1 else values[pos]+1

        // jump and increment counter
        pos = next
        ++result
    }

    println(result)
}