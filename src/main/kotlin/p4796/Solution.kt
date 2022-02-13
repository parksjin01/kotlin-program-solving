package p4796

import kotlin.math.min

object Solution {
    fun shouldTerminate(l: Int, p: Int, v: Int): Boolean {
        return l == 0 && p == 0 && v == 0
    }

    fun calcMaxReserve(l: Int, p: Int, v: Int): Int {
        return v / p * l + min( v % p, l)
    }

    fun solve() {
        var iter: Int = 1

        while (true) {
            val (l: Int, p: Int, v: Int) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0, 0)

            if (shouldTerminate(l, p, v)) {
                break
            }

            println("Case ${iter}: ${calcMaxReserve(l, p, v)}")
            iter += 1
        }
    }
}

fun main() {
   Solution.solve()
}