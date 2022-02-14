package p7785

object Solution {
    fun solve() {
        val employeeCnt: Int = readLine() ?. toInt() ?: 0
        val room: MutableSet<String> = mutableSetOf()

        for (i in 0 until employeeCnt) {
            val userInfo: List<String> = readLine() ?. split(" ") ?: listOf("", "")

            when(userInfo[1]) {
                "leave" -> room.remove(userInfo[0])
                "enter" -> room.add(userInfo[0])
            }
        }

        println(room.sortedDescending().joinToString("\n"))
    }
}

fun main() {
    Solution.solve()
}