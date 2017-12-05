import java.io.File

fun main(args: Array<String>) {

    val phrases = mutableListOf<String>()
    var valids = 0

    // list of strings from file, each representing a phrase
    File("/Users/jrno/Desktop/2017Day4_input.txt").useLines { line -> line.forEach { l -> phrases.add(l) }}


    phrases.forEach phrase@ { p ->

        // actual tokens delimited by whitespace
        val words = p.split(Regex(("\\s+")))

        // Part 1
        // if (words.size == words.distinct().size) {
        //     valids += 1
        // }

        // Part 2
        var anagrams = false
        words.forEachIndexed outer@ { i, word ->
            words.forEachIndexed { d, another ->
                if (i != d && word.toSortedSet() == another.toSortedSet()) {
                    anagrams = true
                    return@outer
                }
            }
        }

        if (!anagrams) {
            valids += 1
        }
    }

    println(valids)
}
