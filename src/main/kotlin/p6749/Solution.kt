package p6749

object Solution {
    fun solve() {
        val youngest: Int = readLine() ?. toInt() ?: 0
        val middle: Int = readLine() ?. toInt() ?: 0

        println(middle + (middle - youngest))
    }
}

fun main() {
    Solution.solve()
}