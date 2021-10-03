package p15964

object Solution {
    fun solve() {
        val (a: Long, b: Long) = readLine() ?. split(" ") ?. map { it.toLong() } ?: listOf(0L, 0L)
        println((a + b) * (a - b))
    }
}

fun main() {
    Solution.solve()
}