package p15969

object Solution {
    fun solve() {
        readLine()

        val scores: List<Int> = readLine() ?. split(" ") ?. map { it.toInt() } ?: emptyList()
        println((scores.maxOf { it.toDouble() } - scores.minOf { it.toDouble() }).toInt())
    }
}

fun main() {
    Solution.solve()
}