package com.ahmedzenhom.problem_solving.cf_892_2_b

var input =
        mutableListOf<String>( // Not to be included in your submitting
                "3",
                "2",
                "2",
                "1 2",
                "2",
                "4 3",
                "1",
                "3",
                "100 1 6",
                "3",
                "4",
                "1001 7 1007 5",
                "3",
                "8 11 6",
                "2",
                "2 9"
        )

fun readLine(): String? { // Not to be included in your submitting
    val line = input.firstOrNull()
    input.removeAt(0)
    return line
}

// You answer goes here

fun main() {
    val tests = readLine()?.toInt()!!
    repeat(tests) {
        val noOfarrays = readLine()?.toInt()!!
        val arrays = mutableListOf<List<Long>>()
        var minFirst = -1L
        var minSecond = Pair(-1L, -1L)

        for (i in 0 until noOfarrays) {
            readLine()
            val array = readLine()!!.split(" ").toList().map { it.toLong() }.sorted()
            arrays.add(array)
            val firstSmallest = array[0]
            if (minFirst == -1L || firstSmallest < minFirst) {
                minFirst = firstSmallest
            }
            val secondSmallest = array[1]
            if (minSecond.first == -1L || secondSmallest < minSecond.second) {
                minSecond = Pair(i.toLong(), secondSmallest)
            }
        }

        var sum = 0L
        for (i in 0 until noOfarrays) {
            sum += (if (i.toLong() != minSecond.first) arrays[i][1] else minFirst)
        }
        println(sum)
    }
}
