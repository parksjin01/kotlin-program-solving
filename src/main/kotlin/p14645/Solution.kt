package p14645

object Solution {
    fun solve() {
        val (stations: Int, people: Int) = readLine() ?.split(" ") ?.map { it.toInt() } ?: listOf(0, 0)
        (0 until stations).map {readLine() ?: ""}
        println("비와이")
    }
}

fun main() {
    Solution.solve()
}