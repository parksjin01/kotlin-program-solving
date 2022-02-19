package p1038

import java.util.LinkedList
import java.util.Queue

object Solution {
    val queue: Queue<String> = LinkedList((0 .. 9).map { it.toString() }.toList()) 

    fun getDecreasingNumber(index: Int): String {
        var idx: Int = 9

        if (index < 10) {
            return index.toString()
        } else {
            while (idx < index) {
                val cur: String = queue.poll()
                val lastDigit: Int = cur.last() - '0'

                for (digit: Int in 0 .. 9) {
                    if (lastDigit <= digit) {
                        break
                    }

                    queue.add(cur + digit.toString())
                    idx += 1

                    if (idx == index) {
                        return queue.last()
                    } else if (queue.last() == "9876543210") {
                        return "-1"
                    }
                }
            }
        }

        return "-1"
    }

    fun solve() {
        val target: Int = readLine() ?. toInt() ?: 0

        println(getDecreasingNumber(target))
    }
}

fun main() {
    Solution.solve()
}