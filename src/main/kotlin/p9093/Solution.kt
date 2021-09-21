package p9093

object Solution {
    fun solve() {
        val numberOfTest = readLine() ?. toInt() ?: 0

        for (i in 0 until numberOfTest) {
            println(readLine() ?. split(" ") ?. map { it.reversed() } ?. joinToString(" ") ?: "")
        }
    }
}

fun main() {
    Solution.solve()
}