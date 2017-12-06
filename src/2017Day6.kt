/**
 * http://adventofcode.com/2017/day/6
 */
fun main(args: Array<String>) {

    val input = "2\t8\t8\t5\t4\t2\t3\t1\t5\t5\t1\t2\t15\t13\t5\t14"
    var allocs = 0

    var seen: MutableList<IntArray> = mutableListOf()
    var block: IntArray = input.split(Regex("\\s")).map { s -> s.toInt() }.toIntArray()

    while (seen.filter { s -> s.contentEquals(block) }.count() == 0) {

        seen.add(block.copyOf())

        val idx_max = block.indexOf(block.max() !!) // enforce Int?->Int using !!
        var idx_alloc = idx_max+1
        var to_distribute = block[idx_max]

        // re-allocation distributes current value among other nodes in the block
        block[idx_max] = 0

        while (to_distribute > 0) {

            // continue from beginning on block end
            if (idx_alloc > block.size - 1) {
                idx_alloc = 0
            }

            block[idx_alloc] = block[idx_alloc] + 1
            --to_distribute
            ++idx_alloc
        }

        ++allocs
    }

    // Part 1: Finding out the total allocation count
    println("Part 1 <> total allocations: $allocs")

    // Part 2: Finding out the "distance" between the two seen block structures
    seen.reversed().forEachIndexed {i, arr ->
        if (arr.contentEquals(block)) {
            val dist = i+1 // indexing starts from 0
            println("Part 2 <> distance between the seen entries: $dist")
        }
    }
}

