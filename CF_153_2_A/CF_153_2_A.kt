package com.ahmedzenhom.problem_solving.cf_153_2_a

var input =
        mutableListOf<String>( // Not to be included in your submitting
                "4",
                ")(",
                "(()",
                "()",
                "))()"
        )

fun readLine(): String? { // Not to be included in your submitting
    val line = input.firstOrNull()
    input.removeAt(0)
    return line
}

// You answer goes here

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val sequence = readLine()!!
        val result = addToSequenceAndContinue(sequence, "(", 1)
        if(result.first){
            println("YES")
            println(result.second)
        } else {
            println("NO")
        }
    }
}

fun addToSequenceAndContinue(
        seqToPrevent: String,
        currentSeq: String,
        openBrackets: Int,
): Pair<Boolean, String?> {
    if (currentSeq.indexOf(seqToPrevent) != -1) {
        return Pair(false, null)
    }

    val leftSpaces = (seqToPrevent.length * 2) - currentSeq.length
    if (leftSpaces == 0) {
        return Pair(true, currentSeq)
    }
    val isSafeForAnOpenBracket = openBrackets < leftSpaces
    val isSafeForAColsedBracket = openBrackets > 0
    var result: Pair<Boolean, String?> = Pair(false, null)
    if (isSafeForAnOpenBracket) {
        result = addToSequenceAndContinue(seqToPrevent, currentSeq + "(", openBrackets + 1)
    }
    if (!result.first && isSafeForAColsedBracket) {
        result = addToSequenceAndContinue(seqToPrevent, currentSeq + ")", openBrackets - 1)
    }
    return result
}
