package p15964

object Solution {
    fun solve() {
        val (a: Int, b: Int) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0)
        println((a + b) * (a - b))
    }
}

fun main() {
    Solution.solve()
}