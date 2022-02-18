package p1343

object Solution {
    fun solve() {
        val POLYOMINO4: String = "AAAA"
        val POLYOMINO2: String = "BB"
        val board: String = readLine() ?: ""

        val result: String = board.replace("XXXX", POLYOMINO4).replace("XX", POLYOMINO2)

        if (result.contains("X")) {
            println(-1)
        } else {
            println(result)
        }
    }
}

fun main() {
    Solution.solve()
}