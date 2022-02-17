package p14916

object Solution {
    fun availalbe(remains: Int, cnt5: Int): Boolean {
        return (remains - cnt5 * 5) % 2 == 0
    }

    fun solve() {
        val remains: Int = readLine() ?. toInt() ?: 0
        var cnt5: Int = remains / 5

        while (cnt5 >= 0) {
            if (availalbe(remains, cnt5)) {
                println(cnt5 + ((remains - cnt5 * 5) / 2))
                return
            } else {
                cnt5 -= 1
            }
        }

        println(-1)
    }
}

fun main() {
    Solution.solve()
}