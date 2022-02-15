package p11931

object Solution {
    fun solve() {
        val n: Int = readLine() ?. toInt() ?: 0
        println((0 until n).map { readLine() ?. toInt() ?: 0 }.toList().sortedDescending().joinToString("\n"))
    }
}

fun main() {
    Solution.solve()
}