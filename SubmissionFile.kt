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
