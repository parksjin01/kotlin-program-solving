package p1439

import kotlin.math.min

object Solution {
    fun counting(number: String): Pair<Int, Int> {
        var current: Char = number[0]
        var group0Cnt: Int = if (current == '0') 1 else 0
        var group1Cnt: Int = if (current == '1') 1 else 0

        for (char: Char in number) {
            if (char != current) {
                current = char

                if (current == '1') {
                    group1Cnt += 1
                } else {
                    group0Cnt += 1
                }
            }
        }

        return Pair(group0Cnt, group1Cnt)
    }

    fun solve() {
        val number: String = readLine() ?: ""
        println(counting(number).let { min(it.first, it.second) })
    }
}

fun main() {
    Solution.solve()
}