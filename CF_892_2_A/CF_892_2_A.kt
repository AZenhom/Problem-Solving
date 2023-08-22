package com.ahmedzenhom.problem_solving.cf_892_2_a

var input = mutableListOf<String>( // Not to be included in your submitting
    "5",
    "3",
    "2 2 2",
    "5",
    "1 2 3 4 5",
    "3",
    "1 3 5",
    "7",
    "1 7 7 2 9 1 4",
    "5",
    "4 8 12 12 4"
)

fun readLine(): String? { // Not to be included in your submitting
    val line = input.firstOrNull()
    input.removeAt(0)
    return line
}

// You answer goes here 

fun main() {
    val t = readLine()?.toInt()!!
    repeat(t){
        readLine()
        val list = readLine()!!.split(" ").toList().map{it.toInt()}
        val listA = list.sorted()
        var separator = -1
        for(i in 0 until listA.size-1){
            if(listA[i] != listA[i+1]){
                separator = i
                break
            }
        }
        if(separator == -1){
            println(-1)
        } else {
            val listB = listA.slice(0 .. separator)
            val listC = listA.slice(separator + 1 until listA.size)
            println("${listB.size} ${listC.size}")
            println(listB.joinToString(" "))
            println(listC.joinToString(" "))
        }
    }
}