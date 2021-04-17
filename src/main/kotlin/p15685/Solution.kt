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

object Solution {
    val board: Array<Array<Int>> = Array(200, {
        Array(200, {
            0
        })
    })

    fun solve() {
        val numberOfCurves = readLine() ?. toInt() ?: 0

        for (i in 0 .. numberOfCurves - 1) {
            val input: List<Int> = readLine() ?. split(" ") ?. map { v -> v.toInt() } ?. toList() ?: emptyList()
            val x: Int = input[0]
            val y: Int = input[1]
            val initialDirection: Direction = Direction.Util.fromId(input[2])
            val gen: Int = input[3]

//            println("${x}, ${y}, ${gen}, ${initialDirection}")
            val initialCurve: List<Direction> = listOf(initialDirection)
            val curves: List<Direction> = createDragonCurve(initialCurve, gen).reversed()

            mark(y, x, curves)
        }

        println(counter())
    }

    fun createDragonCurve(prevCurves: List<Direction>, iter: Int): List<Direction> {
        if (iter == 0)
            return prevCurves

        val newCurvesToAdd: List<Direction> = prevCurves.reversed().map { direction: Direction -> direction.next() }.toList()
        return createDragonCurve(newCurvesToAdd + prevCurves, iter - 1)
    }

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

    fun counter(): Int {
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

fun main() {
    Solution.solve()
}