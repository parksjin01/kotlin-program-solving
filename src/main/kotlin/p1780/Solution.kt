package p1780

import java.util.LinkedList
import java.util.Queue

data class Coordinate(val y: Int, val x: Int)

object Solution {
    val result: MutableList<Int> = MutableList(3) { 0 }

    fun isSameValue(board: List<List<Int>>, start: Coordinate, size: Int): Boolean {
        val current: Int = board[start.y][start.x]

        for (y: Int in start.y until start.y + size) {
            for (x: Int in start.x until start.x + size) {
                if (current != board[y][x]) {
                    return false
                }
            }
        }

        return true
    }
    fun count(board: List<List<Int>>, start: Coordinate, size: Int) {
        if (isSameValue(board, start, size)) {
            result[(board[start.y][start.x] + 1)] +=  1
        } else {
            for (dy: Int in 0 until size step (size / 3)) {
                for (dx: Int in 0 until size step (size / 3)) {
                    count(board, Coordinate(start.y + dy, start.x + dx), size / 3)
                }
            }
        }
    }

    fun solve() {
        val size: Int = readLine() ?. toInt() ?: 0
        val board: List<List<Int>> = (0 until size).map { readLine() ?. split(" ") ?. map { it.toInt() } ?: emptyList() }.toList()
        count(board, Coordinate(0, 0), size)

        println(result[0] )
        println(result[1] )
        println(result[2] )
    }
}

fun main() {
    Solution.solve()
}