package p18108

object Solution {

    fun solve() {
        val diff: Int = 543
        val currentYear: Int = readLine()?.toInt() ?: 0

        println(currentYear - diff)
    }
}

fun main() {
    Solution.solve()
}