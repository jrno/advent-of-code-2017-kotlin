/**
 * http://adventofcode.com/2017/day/3
 */
fun main(args: Array<String>) {

    val puzzleInput = 361527

    var x = 0
    var y = 0
    var spiralDepth = 1
    var nodeValue = 1
    var nextDirection: Direction = Direction.RIGHT
    var points = mutableListOf<Point>()

    points.add(Point(0, 0, 1))

    // target number
    while (nodeValue < puzzleInput) {

        // end of the spiral loop
        if (x == spiralDepth && y == -spiralDepth) {
            spiralDepth += 1
            nextDirection = Direction.RIGHT
            continue
        }

        when (nextDirection) {
            Direction.RIGHT -> {
                x += 1
                if (x == spiralDepth) {
                    nextDirection = Direction.UP
                }
            }
            Direction.UP -> {
                y += 1
                if (y == spiralDepth) {
                    nextDirection = Direction.LEFT
                }
            }
            Direction.LEFT -> {
                x -= 1
                if (x == -spiralDepth) {
                    nextDirection = Direction.DOWN
                }
            }
            Direction.DOWN -> {
                y -= 1
                if (y == -spiralDepth) {
                    nextDirection = Direction.RIGHT
                }
            }
        }

        // Part 1
        // value += 1

        // Part 2 : Value is the sum of adjacent neighbours
        nodeValue = points.filter { p -> p.neighbourOf(x, y) }.sumBy { p -> p.sum }
        points.add(Point(x, y, nodeValue))

        val dist = Math.abs(x) + Math.abs(y)
        println("$x,$y, val: $nodeValue next_direction: $nextDirection, distance from root: $dist")
    }
}

open class Point constructor(val x: Int, val y: Int, val sum: Int) {

    fun neighbourOf(x: Int, y: Int): Boolean {
        return Math.abs(this.x - x) <= 1 && Math.abs(this.y - y)  <= 1
    }
}

enum class Direction {
    UP,DOWN,LEFT,RIGHT
}
