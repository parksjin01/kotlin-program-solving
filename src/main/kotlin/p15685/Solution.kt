package p15685

enum class Direction {
    RIGHT,
    UP,
    LEFT,
    DOWN,
    ERROR;

    fun next(): Direction {
        when(this) {
            RIGHT -> return UP
            UP -> return LEFT
            LEFT -> return DOWN
            DOWN -> return RIGHT
            else -> return ERROR
        }
    }

    companion object Util {
        fun fromId(id: Int): Direction {
            when (id) {
                0 -> return RIGHT
                1 -> return UP
                2 -> return LEFT
                3 -> return DOWN
                else -> return ERROR
            }
        }
    }
}

object CurveGenerator {
    fun createCurve(prevCurves: List<Direction>, gen: Int): List<Direction> {
        if (gen == 0)
            return prevCurves

        val newCurvesToAdd: List<Direction> = prevCurves.reversed().map { direction: Direction -> direction.next() }.toList()
        return createCurve(newCurvesToAdd + prevCurves, gen - 1)
    }
}

object Board {
    private val board: Array<Array<Int>> = Array(200) { Array(200) { 0 } }

    fun mark(y: Int, x: Int, curves: List<Direction>) {
        board[y][x] = 1

        if (curves.isEmpty()) {
            return
        }

        for (direction: Direction in curves) {
            when (direction) {
                Direction.RIGHT -> return mark(y, x + 1, curves.drop(1))
                Direction.UP -> return mark(y - 1, x, curves.drop(1))
                Direction.LEFT -> return mark(y, x - 1, curves.drop(1))
                Direction.DOWN -> return mark(y + 1, x, curves.drop(1))
            }
        }
    }

    fun count(): Int {
        var cnt: Int = 0

        for (y: Int in 0 .. 99) {
            for (x: Int in 0 .. 99) {
                if (board[y][x] == 1 && board[y][x + 1] == 1 && board[y + 1][x] == 1 && board[y + 1][x + 1] == 1)
                    cnt += 1
            }
        }

        return cnt
    }
}

object Solution {
    fun solve() {
        val numberOfCurves = readLine() ?. toInt() ?: 0

        for (i in 0 until numberOfCurves) {
            val input: List<Int> = readLine() ?. split(" ") ?. map { v -> v.toInt() } ?. toList() ?: emptyList()
            val (x: Int, y: Int, directionId: Int, gen: Int) = input
            val initialDirection: Direction = Direction.Util.fromId(directionId)

            val initialCurve: List<Direction> = listOf(initialDirection)
            val curves: List<Direction> = CurveGenerator.createCurve(initialCurve, gen).reversed()

            Board.mark(y, x, curves)
        }

        println(Board.count())
    }
}

fun main() {
    Solution.solve()
}